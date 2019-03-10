package service;

import dal.UserDAO;
import domain.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;


@Stateless
public class UserService {

    @EJB
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

    public Boolean followUser(Long ID, User user) {
        return this.userDAO.follow(ID, user);
    }

    public Boolean unfollowUser(Long ID, User following) {
        return this.userDAO.unfollow(ID, following);
    }

    public List<User> getAllUsers() {
        return this.userDAO.getAllUsers();
    }

    //TODO: vergeten methode erbij maken get user followers
    //Select u from User where :user MEMBER OF u.following
}