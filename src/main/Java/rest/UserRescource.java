package rest;

import domain.User;
import service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("users")
public class UserRescource {

    @Inject
    UserService userService;

    @POST
    public Response createUser(User user) {
        if (this.userService.createUser(user)) {
            return Response.ok(user).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("{ID}")
    public Response updateUser(@PathParam("ID") Long ID, User user) {
        user.setUserID(ID);
        if (this.userService.updateUser(user) == true) {
            return Response.ok(user).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("{ID}")
    public Response deleterUser(@PathParam("ID") Long ID) {
        if (this.userService.deleteUser(ID)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    public Response getAllUsers() {
        List<User> users = this.userService.getAllUsers();
        return Response.ok(users).build();
    }

//    @POST
//    @Path("follow/{ID}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public String followUser(@PathParam("ID") Long ID, JsonObject text) {
//        this.userService.followUser(ID, Long.parseLong(text.getString("userID")));
//        return "follower followed user 2";
//    }

    @POST
    @Path("{ID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response followUser(@PathParam("ID") Long ID, JsonObject text) {
        if (this.userService.followUser(ID, Long.parseLong(text.getString("userID")))) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

//    @POST
//    @Path("unfollow/{ID}")
//    public String unfollowUser(@PathParam("ID") Long ID, User user) {
//        this.userService.unfollowUser(ID, user);
//        return "follower unfollowed user 2";
//    }

    @POST
    @Path("{ID}/unfollow")
    public Response unfollowUser(@PathParam("ID") Long ID, User user) {
        if (this.userService.unfollowUser(ID, user)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

    @GET
    @Path("{ID}")
    public Response getUserByID(@PathParam("ID") Long ID){
        User user  = this.userService.getUserByID(ID);
        return Response.ok(user).build();
    }



//    @GET
//    @Path("getFollowing/{ID}")
//    public List<User> getUserFollowing(@PathParam("ID") Long userID) {
//        return this.userService.getUserFollowing(userID);
//    }

    @GET
    @Path("{ID}/following")
    public Response getUserFollowing(@PathParam("ID") Long userID){
        List<User> users = this.userService.getUserFollowing(userID);
        return Response.ok(users).build();
    }


//    @GET
//    @Path("getFollowers/{ID}")
//    public List<User> getUserFollowers(@PathParam("ID") Long userID) {
//        return this.userService.getUserFollowers(userID);
//    }

    @GET
    @Path("{ID}/followers")
    public Response getUserFollowers(@PathParam("ID") Long userID){
        List<User> users = this.userService.getUserFollowers(userID);
        return Response.ok(users).build();
    }
}