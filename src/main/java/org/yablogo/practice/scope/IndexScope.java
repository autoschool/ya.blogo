package org.yablogo.practice.scope;

import org.javalite.activejdbc.LazyList;
import org.yablogo.practice.model.Post;
import org.yablogo.practice.model.User;

import javax.ws.rs.CookieParam;
import java.util.ArrayList;

/**
 * Created by sukharev on 25.11.14.
 */

public class IndexScope extends Scope {
    public IndexScope(@CookieParam(value = Scope.SESSION_ID_PARAM_NAME) String sid) {
        super(sid);
    }
}
