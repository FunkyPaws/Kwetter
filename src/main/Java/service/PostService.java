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

    public Boolean sendPost(Long userID, String text, Boolean isReaction){
        return this.postDAO.sendPost(userID, text, isReaction);
    }

    public Boolean sendReaction(Long ID, Post post, String text, Boolean isReaction){
        return this.postDAO.sendReaction(ID, post,text, isReaction);
    }

    public List<Post> getLatestsTenPosts(Long ID){
        return this.postDAO.getLatestTenPosts(ID);
    }
}