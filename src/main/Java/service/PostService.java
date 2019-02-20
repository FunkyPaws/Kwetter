package service;

import dal.PostDAO;
import domain.Post;
import domain.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PostService {

    @EJB
    PostDAO postDAO;

//    public PostService() {
//        postDAO = new PostDAOImpl();
//    }

    public Boolean createPost(Post post){
        return this.postDAO.createPost(post);
    }

    public Boolean deletePost(Post post){
        return this.postDAO.deletePost(post);
    }

    public Boolean sendPost(User user, String text, Boolean isReaction){
        return this.postDAO.sendPost(user, text, isReaction);
    }

    public Boolean sendReaction(User user, Post post, String text, Boolean isReaction){
        return this.postDAO.sendReaction(user, post,text, isReaction);
    }

    public List<Post> getLatestsTenPosts(User user){
        return this.postDAO.getLatestTenPosts(user);
    }
}