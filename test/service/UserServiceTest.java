package service;

import dal.UserDAO;
import domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        User user = new User("henk", "ooit iets gedaan", "de put", "www.henk.nl", false, new ArrayList<>(), new ArrayList<>());
        User user2 = new User("berta", "nooit iets gedaan", "de kuil", "www.berta.nl", false, new ArrayList<>(), new ArrayList<>());

        when(userDAO.getAllUsers()).thenReturn(Arrays.asList(user, user2));
        when(userDAO.getUser(1L)).thenReturn(user);
        when(userDAO.getUser(2L)).thenReturn(user2);
        when(userDAO.createUser(any(User.class))).thenReturn(true);

    }

    @Test
    public void createUser() {
        User user = new User();

        assertThat(userService.createUser(user), is(true));
    }

    @Test
    public void deleteUser() {
        when(userDAO.deleteUser(1L)).thenReturn(true);
        assertThat(userService.deleteUser(1L), is(true));

        when(userDAO.deleteUser(3L)).thenReturn(false);
        assertThat(userService.deleteUser(3L), is(false));
    }

    @Test
    public void updateUser() {
        when(userDAO.updateUser(any(User.class))).thenReturn(true);

        User user = new User();

        assertThat(userService.updateUser(user), is(true));
    }

    @Test
    public void getUserByID() {
        User user = userService.getUserByID(1L);

        assertThat(user.getName(), is("henk"));
        assertThat(user.getLocation(), is("de put"));
    }

    @Test
    public void followUser() {
        when(userDAO.follow(1L, 2L)).thenReturn(true);
        assertThat(userService.followUser(1L, 2L), is(true));

        when(userDAO.follow(1L, 3L)).thenReturn(false);
        assertThat(userService.followUser(1L, 3L), is(false));
    }

    //TODO: chagne methode params to: id, id
    @Test
    public void unfollowUser() {
    }

    @Test
    public void getAllUsers() {
        List<User> users = userService.getAllUsers();

        assertThat(users.size(), is(2));
    }

    //TODO: first fix methode
    @Test
    public void getUserFollowers() {
    }


    @Test
    public void getUserFollowing() {
        List<User> users = new ArrayList<>();
        users.add(new User("henk", "ooit iets gedaan", "de put", "www.henk.nl", false, new ArrayList<>(), new ArrayList<>()));

        when(userDAO.getUserFollowing(1L)).thenReturn(users);
        List<User> following = userService.getUserFollowing(1L);

        assertThat(userService.getUserFollowing(1L), is(following));
        assertThat(userService.getUserFollowing(1L).size(), is(1));
    }
}