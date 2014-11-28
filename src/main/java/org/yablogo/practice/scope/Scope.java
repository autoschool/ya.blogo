package org.yablogo.practice.scope;

import org.yablogo.practice.model.Session;
import org.yablogo.practice.model.User;

import javax.ws.rs.CookieParam;

/**
 * Created by sukharev on 25.11.14.
 */
public class Scope {

    public static final String SESSION_ID_PARAM_NAME = "sessionid";

    public Scope(@CookieParam(value = Scope.SESSION_ID_PARAM_NAME) String sid){
        try {
            this.session = Session.findFirst("hash = " + sid);
            user = Session.getUserBySessionId(sid);
        }
        catch(Throwable e){
            user = null;
            session = null;
        }
    }

    protected User      user;
    protected Session   session;

    public User getUser() {
        return user;
    }

    public boolean isOngoingSession() {
        return (session != null);
    }

    public boolean isUserLoggedIn(){
        return (user != null);
    }
}
