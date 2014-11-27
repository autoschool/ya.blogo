package org.yablogo.practice.scope;

import javax.ws.rs.CookieParam;

/**
 * Created by sukharev on 25.11.14.
 */

public class PostScope extends Scope{
    public PostScope(@CookieParam(value = Scope.SESSION_ID_PARAM_NAME) String sid){
        super(sid);
    }
}
