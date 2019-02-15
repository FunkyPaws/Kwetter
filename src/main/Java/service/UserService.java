package main.Java.service;

import main.Java.dal.UserDAO;
import main.Java.dal.UserDAOImpl;
import main.Java.domain.User;

import java.util.List;

public class UserService {

    UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAOImpl();
    }

    public Boolean createUser(User user) {
        return this.userDAO.createUser(user);
    }

    public Boolean deleteUser(User user) {
        return this.userDAO.deleteUser(user);
    }

    public Boolean updateUser(User user) {
        return this.userDAO.updateUser(user);
    }

    public User getUserByID(Long ID) {
        return this.userDAO.getUser(ID);
    }

    public Boolean followUser(User follower, User following) {
        return this.userDAO.follow(follower, following);
    }

    public Boolean unfollowUser(User follower, User following) {
        return this.userDAO.unfollow(follower, following);
    }

    public List<User> getAllUsers() {
        return this.userDAO.getAllUsers();
    }
}