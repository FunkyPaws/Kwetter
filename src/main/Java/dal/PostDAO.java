package dal;

import domain.Post;
import domain.User;

import java.util.List;

public interface PostDAO {

    Boolean createPost(Post post);

    Boolean deletePost(Post post);

    Boolean sendPost(Long userID, String text, Boolean isReaction);

    Boolean sendReaction(Long userID, Long postID, String text, Boolean isReaction);

    List<Post> getLatestTenPosts(Long userID);

}
