package org.yablogo.practice.scope;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.CookieParam;
import javax.ws.rs.core.Context;

/**
 * Created by sukharev on 25.11.14.
 */

public class PostScope extends Scope {
    public PostScope(@Context HttpServletResponse response, @CookieParam(value = Scope.SESSION_ID_PARAM_NAME) String sid) {
        super(response, sid);
    }
}
