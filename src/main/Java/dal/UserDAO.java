package dal;


import domain.User;

import java.util.List;

public interface UserDAO {

    Boolean createUser(User user);

    Boolean deleteUser(Long id);

    Boolean updateUser(User user);

    User getUser(Long ID);

    List<User> getUserFollowers(User user);

    List<User> getUserFollowing(User user);

    Boolean follow(Long ID, User followed);

    Boolean unfollow(Long ID, User followed);

    List<User> getAllUsers();
}