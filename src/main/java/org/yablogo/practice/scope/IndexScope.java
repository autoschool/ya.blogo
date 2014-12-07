package org.yablogo.practice.scope;

import org.yablogo.practice.model.Post;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.CookieParam;
import javax.ws.rs.core.Context;
import java.util.List;

/**
 * Created by sukharev on 25.11.14.
 */

public class IndexScope extends Scope {

    List<Post> posts;

    public IndexScope(@Context HttpServletResponse response, @CookieParam(value = Scope.SESSION_ID_PARAM_NAME) String sid) {
        super(response, sid);
        if (isUserLoggedIn()) {
            posts = Post.find("").limit(10).orderBy("created_ts desc");
        }
    }
}
