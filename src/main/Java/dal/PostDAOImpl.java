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

    private List<Post> posts;

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
    public Boolean sendReaction(User user, Post post, String text, Boolean isReaction) {
        if(isReaction == true){
            Date date = new Date();
            Post reaction = new Post(text, date, isReaction, user, post.getPostID());

            createPost(reaction);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<Post> getLatestTenPosts(User user) {
        List<Post> userPosts = new ArrayList<>();

        for (Post p :posts){
            if(p.getUser().equals(user)){
                userPosts.add(p);
            }
        }
        return userPosts.subList(userPosts.size()-10, userPosts.size());
    }
}