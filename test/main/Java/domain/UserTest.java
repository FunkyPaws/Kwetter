package main.Java.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {
    private List<User> users;
    private List<Post> posts;

    private Post post;


    @Before
    public void setUp() throws Exception {
        int i = 0;
        //make 10 users
        users = new ArrayList<>();
        for (i = 0; i<10; i++){
            User user = new User("test user " +i, "hallo ik ben naam", "Verweggiestan", "www.verweggiestan.org", false, new ArrayList<User>(), new ArrayList<User>());
            users.add(user);
        }

        //make 10 posts
//        posts = new ArrayList<>();
//        for (i = 0; i<10; i++){
//            Date date = new Date();
//            Post post = new Post("test post " +i, date, false, , );
//            posts.add(post);
//        }
        Date date = new Date();
        post = new Post("hello", date, false, users.get(0),new ArrayList<Post>());
    }

    @Test
    public void sendPostPositive() {
        User user0 = users.get(0);
        Boolean postIsSend = user0.sendPost("hallo betra", false);

        assertTrue(postIsSend);
    }

    @Test
    public void sendPostNegative() {
        User user1 = users.get(1);
        Boolean postIsNotSend = user1.sendPost("hallo betra", true);

        assertFalse(postIsNotSend);
    }

    @Test
    public void sendReactionPositive() {
        User user2 = users.get(2);
        Boolean reactionIsSend = user2.sendReaction(post, "Hello 2 u 2", true);

        assertTrue(reactionIsSend);
    }

    @Test
    public void sendReactionNegative() {
        User user3 = users.get(3);
        Boolean reactionIsNotSend = user3.sendReaction(post, "Hello 2 u 2", false);

        assertFalse(reactionIsNotSend);
    }

    @Test
    public void getLatestTenPosts() {
        // TODO: check todo in user method
    }

    @Test
    public void follow() {
    }

    @Test
    public void unfollow() {
    }
}