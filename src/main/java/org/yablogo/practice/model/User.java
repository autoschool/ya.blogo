package org.yablogo.practice.model;

import org.javalite.activejdbc.Model;

/**
 * Created by sukharev on 25.11.14.
 */
public class User extends Model {

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

}
