package main.Java.service;

import dal.PostDAO;
import domain.Post;
import domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import service.PostService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

    @Mock
    private PostDAO postDAO;

    @InjectMocks
    private PostService postService;
    List<Post> posts;

//    @Before
//    public void setUp() throws Exception {
//        postService = new PostService();
//
//        int i = 0;
//        //make 10 posts
//        posts = new ArrayList<>();
//        Date date = new Date();
//        User user = new User(Long.valueOf(i),"test user " + i, "hallo ik ben naam", "Verweggiestan", "www.verweggiestan.org", false, new ArrayList<User>(), new ArrayList<User>());
//        for (i = 0; i < 10; i++) {
//            Post post = new Post(Long.valueOf(i), " text", date, false, user,null);
//            posts.add(post);
//        }
//    }
//
//    @Test
//    public void createPostPostitive() {
//        Post post0 = posts.get(0);
//        Boolean createdPost =  postService.createPost(post0);
//
//        assertTrue(createdPost);
//    }
//
//    @Test
//    public void createPostNegative() {
//        Post post1 = posts.get(1);
//        postService.createPost(post1);
//        Boolean createdPost =  postService.createPost(post1);
//
//        assertFalse(createdPost);
//    }
//
//    @Test
//    public void sendPostPositive() {
//        User user = new User(Long.valueOf(10),"test user ", "hallo ik ben naam", "Verweggiestan", "www.verweggiestan.org", false, new ArrayList<User>(), new ArrayList<User>());
//        String text = " test text ";
//        Boolean isreaction = false;
//
//        Boolean sendpost = postService.sendPost(user, text, isreaction);
//
//        assertTrue(sendpost);
//    }
//
//    @Test
//    public void sendPostNegative() {
//        User user = new User(Long.valueOf(10),"test user ", "hallo ik ben naam", "Verweggiestan", "www.verweggiestan.org", false, new ArrayList<User>(), new ArrayList<User>());
//        String text = " test text ";
//        Boolean isreaction = true;
//
//        Boolean sendpost = postService.sendPost(user, text, isreaction);
//
//        assertFalse(sendpost);
//    }
//
//    @Test
//    public void sendReactionPositive() {
//        Post post3 = posts.get(3);
//        postService.createPost(post3);
//        User user = new User(Long.valueOf(10),"test user ", "hallo ik ben naam", "Verweggiestan", "www.verweggiestan.org", false, new ArrayList<User>(), new ArrayList<User>());
//        String text = " test text ";
//        Boolean isreaction = true;
//
//        Boolean sendreaction = postService.sendReaction(user, post3, text, isreaction);
//
//        assertTrue(sendreaction);
//    }
//
//    @Test
//    public void sendReactionNegative() {
//        Post post3 = posts.get(3);
//        postService.createPost(post3);
//        User user = new User(Long.valueOf(10),"test user ", "hallo ik ben naam", "Verweggiestan", "www.verweggiestan.org", false, new ArrayList<User>(), new ArrayList<User>());
//        String text = " test text ";
//        Boolean isreaction = false;
//
//        Boolean sendreaction = postService.sendReaction(user, post3, text, isreaction);
//
//        assertFalse(sendreaction);
//    }
//
//    @Test
//    public void getLatestTenPosts() {
//        int i = 0;
//        //make 10 posts
//        posts = new ArrayList<>();
//        Date date = new Date();
//        User user = new User(Long.valueOf(i),"test user " + i, "hallo ik ben naam", "Verweggiestan", "www.verweggiestan.org", false, new ArrayList<User>(), new ArrayList<User>());
//        for (i = 0; i < 30; i++) {
//            Post post = new Post(Long.valueOf(i), " text", date, false, user,null);
//            postService.createPost(post);
//        }
//
//        List<Post> postList = postService.getLatestsTenPosts(user);
//
//        assertEquals(10, postList.size());
//    }
}