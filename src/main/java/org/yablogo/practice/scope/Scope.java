package org.yablogo.practice.scope;

import org.yablogo.practice.model.Session;
import org.yablogo.practice.model.User;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.CookieParam;
import javax.ws.rs.core.Context;

/**
 * Created by sukharev on 25.11.14.
 */
public class Scope {
    public static final String SESSION_ID_PARAM_NAME = "sessionid";
    public static final int SESSIONID_LIVETIME = 24 * 3600;

    protected User user;
    protected Session session;

    public Scope(@Context HttpServletResponse response, @CookieParam(value = Scope.SESSION_ID_PARAM_NAME) String sid) {
        this.session = Session.findFirst("hash = " + sid);
        if (this.session != null) {
            user = Session.getUserBySessionId(sid);
        } else {
            user = null;
            session = null;
        }
    }

    public User getUser() {
        return user;
    }

    public boolean isUserLoggedIn() {
        return (user != null);
    }
}
