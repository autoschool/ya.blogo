package org.yablogo.practice.service;

import org.yablogo.practice.context.AuthUser;
import org.yablogo.practice.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import java.io.IOException;

/**
 * Created by Артем on 21.01.15.
 */
public class AuthUserProvider implements ContainerRequestFilter {
    @Context
    HttpServletRequest request;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        HttpSession session = request.getSession(true);
        Object userId = session.getAttribute("userId");

        User user = null;
        if (userId != null) {
            user = User.findById(userId);
        }

        requestContext.setSecurityContext(new AuthUser(user));
    }

}
