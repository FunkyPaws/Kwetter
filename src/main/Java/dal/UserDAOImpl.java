package dal;

import domain.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserDAOImpl implements UserDAO {
    List<User> users;

    @PersistenceContext
    private EntityManager em;

//    public UserDAOImpl(EntityManager em) {
//        this.em = em;
//    }


    public UserDAOImpl() {
        users = new ArrayList<>();
    }

    @Override
    public Boolean createUser(User user) {
        em.persist(user);
        return true;
    }

    @Override
    public Boolean deleteUser(Long id) {
        User user = em.find(User.class, id);
        em.remove(user);
        return true;
    }

    @Override
    public Boolean updateUser(User user) {
        em.merge(user);
        return true;
    }

    @Override
    public User getUser(Long ID) {
        return em.find(User.class, ID);
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
    public Boolean follow(Long ID, User following) {
        User user = em.find(User.class, ID);
        user.addFollower(following);
        em.merge(user);

        return true;
    }

    @Override
    public Boolean unfollow(User follower, User followed) {
        return null;
//        if (follower.getFollowing().contains(followed) && followed.getFollowers().contains(follower)) {
//            follower.getFollowing().remove(followed);
//            followed.getFollowers().remove(follower);
//            return true;
//        } else {
//            return false;
//        }
    }

    @Override
    public List<User> getAllUsers() {
        Query query = em.createNamedQuery("User.getAll", User.class);
        return query.getResultList();
    }
}