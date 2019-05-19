package boudrary.rest;

import com.sun.jndi.toolkit.url.Uri;
import domain.User;
import service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Stateless
@Path("users")
public class UserRescource {

    private final String URI = "/kwetter/api/users";

    @Inject
    UserService userService;

    @GET
    @Path("{ID}")
    public Response getUserByID(@PathParam("ID") Long ID) {
        User user = this.userService.getUserByID(ID);
        return Response.ok(user).build();
    }

    @POST
    public Response createUser(User user) {
        if (this.userService.createUser(user)) {
            user.add(linkTo(UserRescource.class).slash(URI + "/" +user.getUserID()).withSelfRel());
            user.add(linkTo(UserRescource.class).slash(URI + "/" +user.getUserID() + "/following").withRel("following"));
            user.add(linkTo(UserRescource.class).slash(URI + "/" +user.getUserID() + "/followers").withRel("followers"));

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
    @Path("byname/{name}")
    public Response getUserByName(@PathParam("name") String name) {
        List<User> users = this.userService.getUserByName(name);
        return Response.ok(users).build();
    }

    @GET
    @Path("{ID}/following")
    public Response getUserFollowing(@PathParam("ID") Long userID) {
        List<User> users = this.userService.getUserFollowing(userID);
        return Response.ok(users).build();
    }

    // haalt dezelfde lijst op als following, haalt altijd de following op van een user.
    @GET
    @Path("{ID}/followers")
    public Response getUserFollowers(@PathParam("ID") Long userID) {
        List<User> users = this.userService.getUserFollowers(userID);
        return Response.ok(users).build();
    }
}
