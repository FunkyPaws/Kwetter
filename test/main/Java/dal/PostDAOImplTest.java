package main.Java.dal;

import main.Java.domain.Post;
import main.Java.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class PostDAOImplTest {

    PostDAO postDAO;
    List<Post> posts;

    @Before
    public void setUp() throws Exception {
        postDAO = new PostDAOImpl();

        int i = 0;
        //make 10 posts
        posts = new ArrayList<>();
        Date date = new Date();
        User user = new User(Long.valueOf(i),"test user " + i, "hallo ik ben naam", "Verweggiestan", "www.verweggiestan.org", false, new ArrayList<User>(), new ArrayList<User>());
        for (i = 0; i < 10; i++) {
            Post post = new Post(Long.valueOf(i), " text", date, false, user,null);
            posts.add(post);
        }
    }

    @Test
    public void createPostPositive() {
        Post post0 = posts.get(0);
        Boolean createdPost =  postDAO.createPost(post0);

        assertTrue(createdPost);
    }

    @Test
    public void createPostNegative() {
        Post post1 = posts.get(1);
        postDAO.createPost(post1);
        Boolean createdPost =  postDAO.createPost(post1);

        assertFalse(createdPost);
    }

    @Test
    public void sendPostPositive() {
        User user = new User(Long.valueOf(10),"test user ", "hallo ik ben naam", "Verweggiestan", "www.verweggiestan.org", false, new ArrayList<User>(), new ArrayList<User>());
        String text = " test text ";
        Boolean isreaction = false;

        Boolean sendpost = postDAO.sendPost(user, text, isreaction);

        assertTrue(sendpost);
    }

    @Test
    public void sendPostNegative() {
        User user = new User(Long.valueOf(10),"test user ", "hallo ik ben naam", "Verweggiestan", "www.verweggiestan.org", false, new ArrayList<User>(), new ArrayList<User>());
        String text = " test text ";
        Boolean isreaction = true;

        Boolean sendpost = postDAO.sendPost(user, text, isreaction);

        assertFalse(sendpost);
    }

    @Test
    public void sendReactionPositive() {
        Post post3 = posts.get(3);
        postDAO.createPost(post3);
        User user = new User(Long.valueOf(10),"test user ", "hallo ik ben naam", "Verweggiestan", "www.verweggiestan.org", false, new ArrayList<User>(), new ArrayList<User>());
        String text = " test text ";
        Boolean isreaction = true;

        Boolean sendreaction = postDAO.sendReaction(user, post3, text, isreaction);

        assertTrue(sendreaction);
    }

    @Test
    public void sendReactionNegative() {
        Post post3 = posts.get(3);
        postDAO.createPost(post3);
        User user = new User(Long.valueOf(10),"test user ", "hallo ik ben naam", "Verweggiestan", "www.verweggiestan.org", false, new ArrayList<User>(), new ArrayList<User>());
        String text = " test text ";
        Boolean isreaction = false;

        Boolean sendreaction = postDAO.sendReaction(user, post3, text, isreaction);

        assertFalse(sendreaction);
    }

    @Test
    public void getLatestTenPosts() {
        int i = 0;
        //make 10 posts
        posts = new ArrayList<>();
        Date date = new Date();
        User user = new User(Long.valueOf(i),"test user " + i, "hallo ik ben naam", "Verweggiestan", "www.verweggiestan.org", false, new ArrayList<User>(), new ArrayList<User>());
        for (i = 0; i < 30; i++) {
            Post post = new Post(Long.valueOf(i), " text", date, false, user,null);
            postDAO.createPost(post);
        }

        List<Post> postList = postDAO.getLatestTenPosts(user);

        assertEquals(10, postList.size());
    }
}