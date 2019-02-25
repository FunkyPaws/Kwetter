package rest;

import domain.User;
import service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Stateless
@Path("users")
public class UserRescource {

    @Inject
    UserService userService;

    @POST
    public String createUser(User user) {
        this.userService.createUser(user);
        return "User created";
    }

    @PUT
    @Path("{ID}")
    public String updateUser(@PathParam("ID") Long ID, User user) {
        user.setUserID(ID);
        this.userService.updateUser(user);
        return "User updated";
    }

    @DELETE
    @Path("{ID}")
    public String deleteUser(@PathParam("ID") Long ID) {
        this.userService.deleteUser(ID);
        return "Delete created";
    }

    @GET
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @POST
    @Path("follow/{ID}")
    public String followUser(@PathParam("ID") Long ID, User user) {
        this.userService.followUser(ID, user);
        return "follower followed user 2";
    }
}
