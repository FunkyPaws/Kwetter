package service;

import dal.PostDAO;
import domain.Post;
import domain.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PostService {

    @Inject
    PostDAO postDAO;

    public Boolean createPost(Post post){
        return this.postDAO.createPost(post);
    }

    public Boolean deletePost(Post post){
        return this.postDAO.deletePost(post);
    }

    public Boolean sendPost(Long userID, String text, Boolean isReaction){
        return this.postDAO.sendPost(userID, text, isReaction);
    }

    public List<Post> getAllPosts(){return this.postDAO.getAllPosts();}

    public Boolean sendReaction(Long ID, Long postID, String text, Boolean isReaction){
        return this.postDAO.sendReaction(ID, postID ,text, isReaction);
    }

    public List<Post> getLatestsTenPosts(Long ID){
        return this.postDAO.getLatestTenPosts(ID);
    }
}
