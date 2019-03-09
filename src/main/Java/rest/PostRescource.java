package rest;

import domain.Post;
import domain.User;
import service.PostService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

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

}