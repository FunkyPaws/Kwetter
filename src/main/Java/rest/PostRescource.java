package rest;

import domain.Post;
import domain.User;
import service.PostService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("posts")
public class PostRescource {

    @Inject
    PostService postService;

    @POST
    @Path("userSendPost/{ID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String sendUserPost(@PathParam("ID") Long userID, JsonObject text) {
        this.postService.sendPost(userID, text.getString("text"), false);
        return "Post created";
    }

    @GET
    @Path("getUserPosts/{ID}")
    public List<Post> getLatestTenPosts(@PathParam("ID") Long userID){
        return this.postService.getLatestsTenPosts(userID);
    }

    @POST
    @Path("userSendReaction/{ID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String sendReaction(@PathParam("ID") Long userID, JsonObject text){
        this.postService.sendReaction(userID, Long.parseLong(text.getString("postID")), text.getString("text"), true);
        return " reaction created";
    }
}