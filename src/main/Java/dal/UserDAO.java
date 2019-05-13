package dal;

import domain.User;

import java.util.List;

public interface UserDAO {

    Boolean createUser(User user);

    Boolean deleteUser(Long id);

    Boolean updateUser(User user);

    User getUser(Long ID);

    List<User> getUserbyName(String name);

    List<User> getUserFollowers(Long userID);

    List<User> getUserFollowing(Long userID);

    Boolean follow(Long userID, Long following);

    Boolean unfollow(Long ID, User followed);

    List<User> getAllUsers();

    Long loginUser(String username, String password);
}
