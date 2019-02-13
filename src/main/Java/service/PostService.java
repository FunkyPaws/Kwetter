package main.Java.service;

import main.Java.dal.PostDAO;
import main.Java.domain.Post;
import main.Java.domain.User;

import java.util.List;

public class PostService {

    PostDAO postDAO;

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