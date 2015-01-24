package org.yablogo.practice.context;

import org.yablogo.practice.model.User;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

/**
 * Created by Артем on 21.01.15.
 */
public class AuthUser implements SecurityContext {

    private User user;

    public AuthUser(final User user) {
        this.user = user;
    }

    @Override
    public Principal getUserPrincipal() {
        return this.user;
    }

    @Override
    public boolean isUserInRole(String role) {
        return false;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public String getAuthenticationScheme() {
        return null;
    }
}
