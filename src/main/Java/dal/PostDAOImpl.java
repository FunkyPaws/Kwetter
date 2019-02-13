package main.Java.dal;

import main.Java.domain.Post;
import main.Java.domain.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDAOImpl implements PostDAO {

    //private final EntityManager em;

//    public UserDAOImpl(EntityManager em) {
////        this.em = em;
////    }

    private List<Post> posts;

    public PostDAOImpl() {
        posts = new ArrayList<>();

    }

    @Override
    public Boolean createPost(Post post) {

        if (!posts.contains(post)){
            posts.add(post);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deletePost(Post post) {
        //TODO: will be implemented with the entity manager
        throw new NotImplementedException();
    }

    @Override
    public Boolean sendPost(User user, String text, Boolean isReaction) {
        if(isReaction == false){
            Date date = new Date();
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
