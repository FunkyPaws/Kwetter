package dal;

import domain.Post;
import domain.User;

import java.util.List;

public interface PostDAO {

    Boolean createPost(Post post);

    Boolean deletePost(Post post);

    Boolean sendPost(User user, String text, Boolean isReaction);

    Boolean sendReaction(User user, Post post, String text, Boolean isReaction);

    List<Post> getLatestTenPosts(User user);

}
