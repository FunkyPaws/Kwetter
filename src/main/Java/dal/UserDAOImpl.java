package dal;

import domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

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

    //TODO: finish this method
    @Override
    public List<User> getUserFollowers(Long userID) {
        User user = getUser(userID);
        List<User> followers = em.createNamedQuery("User.getFollowers").setParameter("user", user).getResultList();
        return followers;
        //throw new NotImplementedException();
    }

    //TODO: finish this method
    @Override
    public List<User> getUserFollowing(Long userID) {
        User user = getUser(userID);
        List<User> following = em.createNamedQuery("User.getFollowers").setParameter("user", user).getResultList();
        return following;
        //throw new NotImplementedException();
    }

    @Override
    public Boolean follow(Long userID, Long following) {
        User user = em.find(User.class, userID);
        User followinguser = em.find(User.class, following);
        user.addFollowing(followinguser);
//        followinguser.addFollower(user);
        em.merge(user);
        em.merge(followinguser);
        return true;
    }

    @Override
    public Boolean unfollow(Long userID, User followed) {
        User user = em.find(User.class, userID);
        User following = em.find(User.class, followed.getUserID());
        user.removeFollowed(following);
        em.merge(user);
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        Query query = em.createNamedQuery("User.getAll", User.class);
        return query.getResultList();
    }
}