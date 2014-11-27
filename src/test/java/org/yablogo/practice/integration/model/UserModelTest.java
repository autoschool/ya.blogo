package org.yablogo.practice.integration.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.hamcrest.CoreMatchers.is;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.yablogo.practice.model.User;
import org.yablogo.practice.service.DatabaseProvider;

import java.util.Date;


/**
 * Created by sukharev on 27.11.14.
 */
public class UserModelTest {
    private static final String WRONGLOGIN = "wronglogin";
    private static final String TESTLOGIN = "testuser";
    private static final String TESTPASSWORD = "testpassword";
    private static final String TESTEMAIL = "some@some.com";

    private static User user;

    @BeforeClass
    public static void connectToDB() {
        DatabaseProvider.openConnection();
    }

    @BeforeClass
    public static void setup(){
        user = new User();
        user.setString("login",TESTLOGIN);
        user.setString("password",TESTPASSWORD);
        user.setString("email", TESTEMAIL);
        user.saveIt();
    }

    @AfterClass
    public static void tearDown() {
        User.findById(user.getId()).delete();
    }

    @Test
    public void shouldFindAUser(){
        assertNotEquals("should not be a null",User.findFirst("login = ?", TESTLOGIN), null);
    }

    @Test
    public void shouldFindExistingUser() {
        assertEquals(User.findFirst("login = ?", TESTLOGIN).getInteger("id"), user.getInteger("id"));
    }

    @Test
    public void shouldFindUserByLogin() {
        assertEquals(User.findUser(TESTLOGIN, TESTPASSWORD).getInteger("id"), user.getInteger("id"));
    }

    @Test
    public void shouldFindUserByEmail() {
        assertEquals(User.findUser(TESTEMAIL, TESTPASSWORD).getInteger("id"), user.getInteger("id"));
    }

    @Test
    public void shouldNotFindUserByWrongLogin() {
        assertEquals(User.findUser(WRONGLOGIN, TESTPASSWORD), null);
    }
}
