package main.Java.dal;

import main.Java.domain.User;

import java.util.List;

public interface UserDAO {

    Boolean createUser(User user);

    Boolean deleteUser(User user);

    Boolean updateUser(User user);

    User getUser(Long ID);

    List<User> getUserFollowers(User user);

    List<User> getUserFollowing(User user);

    Boolean follow(User follower, User followed);

    Boolean unfollow(User follower, User followed);

    List<User> getAllUsers();

}