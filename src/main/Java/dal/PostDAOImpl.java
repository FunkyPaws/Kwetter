package dal;

import domain.Post;
import domain.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
public class PostDAOImpl implements PostDAO {

    @PersistenceContext
    private EntityManager em;

    @EJB
    UserDAO userDAO;


    @Override
    public Boolean createPost(Post post) {
        em.persist(post);
        return true;
    }

    @Override
    public Boolean deletePost(Post post) {
       em.remove(post);
       return true;
    }

    @Override
    public Boolean sendPost(Long userID, String text, Boolean isReaction) {
        if(isReaction == false){
            Date date = new Date();
            User user = userDAO.getUser(userID);
            Post post = new Post(text, date, isReaction, user, null);

            createPost(post);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean sendReaction(Long ID, Long postID, String text, Boolean isReaction) {
        User user = userDAO.getUser(ID);

        if(isReaction == true){
            Date date = new Date();
            Post reaction = new Post(text, date, isReaction, user, postID);

            createPost(reaction);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<Post> getLatestTenPosts(Long ID) {
        List<Post> userPosts = new ArrayList<>();
        userPosts = em.createNamedQuery("Post.getLatestTen").setParameter("id", ID).getResultList();
        if(userPosts.size() > 10){
            return userPosts.subList(userPosts.size()-10, userPosts.size());
        }
        else {
            return userPosts;
        }
    }
}