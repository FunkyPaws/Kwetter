package service;

import dal.UserDAO;
import domain.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;


@Stateless
public class UserService {

    @Inject
    UserDAO userDAO;

    public Boolean createUser(User user) {
        return this.userDAO.createUser(user);
    }

    public Boolean deleteUser(Long id) {
        return this.userDAO.deleteUser(id);
    }

    public Boolean updateUser(User user) {
        return this.userDAO.updateUser(user);
    }

    public User getUserByID(Long ID) {
        return this.userDAO.getUser(ID);
    }

    public Boolean followUser(Long ID, Long following) {
        return this.userDAO.follow(ID, following);
    }

    public Boolean unfollowUser(Long ID, User following) {
        return this.userDAO.unfollow(ID, following);
    }

    public List<User> getAllUsers() {
        return this.userDAO.getAllUsers();
    }

    public List<User> getUserFollowers(Long userID) {
        return this.userDAO.getUserFollowers(userID);
    }

    public List<User> getUserFollowing(Long userID) {
        return this.userDAO.getUserFollowing(userID);
    }
}