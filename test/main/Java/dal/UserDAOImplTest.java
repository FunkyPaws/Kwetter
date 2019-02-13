package main.Java.dal;

import main.Java.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserDAOImplTest {

    private UserDAO userDAO;
    private List<User> users;

    @Before
    public void setUp() throws Exception {
        userDAO = new UserDAOImpl();

        int i = 0;
        //make 10 users
        users = new ArrayList<>();
        for (i = 0; i < 10; i++) {
            User user = new User(Long.valueOf(i),"test user " + i, "hallo ik ben naam", "Verweggiestan", "www.verweggiestan.org", false, new ArrayList<User>(), new ArrayList<User>());
            users.add(user);
        }
    }

    @Test
    public void createUser() {
        User user0 = users.get(0);
        Boolean createuserPositive = userDAO.createUser(user0);

        assertTrue(createuserPositive);
    }

    @Test
    public void createUserNegative() {
        User user0 = users.get(0);
        userDAO.createUser(user0);
        Boolean createuserPositive = userDAO.createUser(user0);

        assertFalse(createuserPositive);
    }

    @Test
    public void deleteUser() {
        User user1 = users.get(1);
        userDAO.createUser(user1);
        Boolean deleteuserPositive = userDAO.deleteUser(user1);

        assertTrue(deleteuserPositive);
    }

    @Test
    public void deleteUserNegative() {
        User user1 = users.get(1);
        User user2 = users.get(2);
        userDAO.createUser(user1);
        Boolean deleteuserNegative = userDAO.deleteUser(user2);

        assertFalse(deleteuserNegative);
    }

    @Test
    public void updateUser() {
        User user2 = users.get(2);
        userDAO.createUser(user2);
        user2.setBiography("dit is nu anders");
        Boolean updeteduserPositive = userDAO.updateUser(user2);

        assertTrue(updeteduserPositive);
    }

    @Test
    public void updateUserNegative() {
        User user2 = users.get(2);
        User user3 = users.get(3);
        userDAO.createUser(user2);
        user2.setBiography("dit is nu anders");
        Boolean updeteduserNegative = userDAO.updateUser(user3);

        assertFalse(updeteduserNegative);
    }

    @Test
    public void getUser() {
        User user4 = users.get(4);
        userDAO.createUser(user4);
        User testUser = userDAO.getUser(user4.getUserID());

        assertEquals(user4, testUser);
    }

    @Test
    public void getUserNegative() {
        User user4 = users.get(4);
        User user5 = users.get(5);
        userDAO.createUser(user4);
        User testUser = userDAO.getUser(user4.getUserID());

        assertNotEquals(user5, testUser);
    }


    @Test
    public void followPositive() {
        User user4 = users.get(4);
        User user5 = users.get(5);

        Boolean userFollowsUser = userDAO.follow(user4, user5);
        assertTrue(userFollowsUser);
    }

    @Test
    public void followNegative() {
        User user4 = users.get(4);
        User user5 = users.get(5);

        userDAO.follow(user4, user5);
        Boolean userFollowsUser = userDAO.follow(user4, user5);
        assertFalse(userFollowsUser);
    }

    @Test
    public void unfollowPositive() {
        User user6 = users.get(6);
        User user7 = users.get(7);

        userDAO.follow(user6, user7);

        Boolean userUnfollowsUser = userDAO.unfollow(user6, user7);
        assertTrue(userUnfollowsUser);
    }

    @Test
    public void unfollowNegative() {
        User user6 = users.get(6);
        User user7 = users.get(7);
        User user8 = users.get(8);

        userDAO.follow(user6, user7);

        Boolean userUnfollowsWrongUser = userDAO.unfollow(user6, user8);
        assertFalse(userUnfollowsWrongUser);
    }

    @Test
    public void getAllUsers() {
        User user6 = users.get(6);
        User user7 = users.get(7);
        User user8 = users.get(8);
        User user9 = users.get(9);
        User user10 = users.get(5);

        userDAO.createUser(user6);
        userDAO.createUser(user7);
        userDAO.createUser(user8);
        userDAO.createUser(user9);
        userDAO.createUser(user10);

        List<User> users1 = userDAO.getAllUsers();

        assertEquals(5, users1.size());
    }

    @Test
    public void getAllUsersNegative() {
        User user6 = users.get(6);
        User user7 = users.get(7);
        User user8 = users.get(8);
        User user9 = users.get(9);
        User user10 = users.get(5);

        userDAO.createUser(user6);
        userDAO.createUser(user7);
        userDAO.createUser(user8);
        userDAO.createUser(user9);
        userDAO.createUser(user10);

        List<User> users1 = userDAO.getAllUsers();

        assertNotEquals(10, users1.size());
    }
}