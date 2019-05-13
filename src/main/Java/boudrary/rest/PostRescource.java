package boudrary.rest;

        import domain.Post;
        import security.JWToken;
        import service.PostService;

        import javax.ejb.Stateless;
        import javax.inject.Inject;
        import javax.json.JsonObject;
        import javax.ws.rs.*;
        import javax.ws.rs.core.MediaType;
        import javax.ws.rs.core.Response;
        import java.util.List;

@Stateless
@Path("posts")
public class PostRescource {

    @Inject
    PostService postService;


    @GET
    @Path("")
    public Response getAllPosts(){
        List<Post> posts = this.postService.getAllPosts();
        return Response.ok(posts).build();
    }

    @POST
    @JWToken
    @Path("userSendPost/{ID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendUserPost(@PathParam("ID") Long userID, JsonObject text){
        if (this.postService.sendPost(userID, text.getString("text"), false)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("getUserPosts/{ID}")
    public Response getLatestTenPost(@PathParam("ID") Long userID){
        List<Post> posts = this.postService.getLatestsTenPosts(userID);
        return Response.ok(posts).build();
    }

    @POST
    @Path("userSendReaction/{ID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String sendReaction(@PathParam("ID") Long userID, JsonObject text){
        this.postService.sendReaction(userID, Long.parseLong(text.getString("postID")), text.getString("text"), true);
        return " reaction created";
    }
}
