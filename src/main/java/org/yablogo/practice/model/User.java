package org.yablogo.practice.model;

import org.javalite.activejdbc.Model;

/**
 * Created by sukharev on 25.11.14.
 */
public class User extends Model {

    public class NoSuchUser extends Throwable {

    }

    public static User findUser(String login,String password){
        return User.findFirst("(login = ? or email = ?) and password = ?",login,login,password);
    }

}
