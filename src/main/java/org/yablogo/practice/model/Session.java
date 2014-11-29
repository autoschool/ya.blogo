package org.yablogo.practice.model;

import org.javalite.activejdbc.Model;

/**
 * Created by sukharev on 25.11.14.
 */
public class Session extends Model {
    public Session() {}

    public int getUserId(){
        return this.getInteger("user_id");
    }

    public static Session getSessionForUser(User u) {
        Session s = new Session();
        return s;
    }

    public static User getUserBySessionId(String sessionId) {
        Session s = Session.findFirst("hash = "+sessionId);
        return User.findById(s.getUserId());
    }
}
