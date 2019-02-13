package main.Java.dal;

import main.Java.domain.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    List<User> users;

    //private final EntityManager em;

//    public UserDAOImpl(EntityManager em) {
////        this.em = em;
////    }


    public UserDAOImpl() {
        users = new ArrayList<>();
    }

    @Override
    public Boolean createUser(User user) {
        if (!users.contains(user)){
            users.add(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUser(User user) {
        if(users.contains(user)){
            users.remove(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateUser(User user) {
        for (User u : users){
            if (users.contains(user)){
                users.remove(u);
                users.add(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public User getUser(Long ID) {

        for ( User u: users) {
            if (u.getUserID().equals(ID)){
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> getUserFollowers(User user) {
        //TODO: will be implemented with the entity manager
        throw new NotImplementedException();
    }

    @Override
    public List<User> getUserFollowing(User user) {
        //TODO: will be implemented with the entity manager
        throw new NotImplementedException();
    }

    @Override
    public Boolean follow(User follower, User followed) {
        if(!follower.getFollowing().contains(followed)) {
            follower.getFollowing().add(followed);
            followed.getFollowers().add(follower);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean unfollow(User follower, User followed) {
        if(follower.getFollowing().contains(followed) && followed.getFollowers().contains(follower)){
            follower.getFollowing().remove(followed);
            followed.getFollowers().remove(follower);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}