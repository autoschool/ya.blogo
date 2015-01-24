package org.yablogo.practice.model;

import org.javalite.activejdbc.Model;

import java.security.Principal;
import java.sql.Timestamp;

/**
 * Created by sukharev on 25.11.14.
 */
public class User extends Model implements Principal {

    public String getName() {
        return getString("name");
    }

    public static User findUser(String login, String password) {
        return User.findFirst("(login = ? or email = ?) and password = ?", login, login, password);
    }

    public String getLogin() {
        return getString("login");
    }

    public String getPassword() {
        return getString("password");
    }

    public String getEmail() {
        return getString("email");
    }

    public void setLogin(String login) {
        setString("login", login);
    }

    public void setPassword(String password) {
        setString("password", password);
    }

    public void setEmail(String email) {
        setString("email", email);
    }

    public String getAvatar() {
        return getString("avatar");
    }

    public void setAvatar(String avatar) {
        setString("avatar", avatar);
    }

    public Timestamp getCreatedAt() {
        return getTimestamp("created_at");
    }
}
