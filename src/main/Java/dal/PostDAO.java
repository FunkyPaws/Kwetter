package dal;

import domain.Post;
import java.util.List;

public interface PostDAO {

    Boolean createPost(Post post);

    Boolean deletePost(Post post);

    List<Post> getAllPosts();

    List<Post> getAllUserPosts(Long userID);

    Boolean sendPost(Long userID, String text, Boolean isReaction);

    Boolean sendReaction(Long userID, Long postID, String text, Boolean isReaction);

    List<Post> getLatestTenPosts(Long userID);

}
