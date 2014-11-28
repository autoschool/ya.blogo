package org.yablogo.practice.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;

import org.yablogo.practice.model.Session;
import org.yablogo.practice.model.User;
import org.yablogo.practice.scope.IndexScope;
import org.yablogo.practice.scope.Scope;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;



/**
 * Created by litemn on 22.11.14.
 */

@Path("/")
@ErrorTemplate(name = "/error.ftl")
@Produces(MediaType.TEXT_HTML)
public class IndexResource {
    @GET
    @Path("/")
    @Template(name = "/index.ftl")
    public IndexScope showIndex(@BeanParam IndexScope scope) {
        System.err.print("here");
        return scope;
    }

    @GET
    @Path("/notfound")
    @Template(name= "/notfound.ftl")
    public Scope showIndex(@BeanParam Scope scope) {
        return scope;
    }

    @POST
    @Path("/signin")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void signIn(@Context HttpServletResponse resp, @FormParam("login") String login, @FormParam("password") String password) throws IOException {
        User loginUser = User.findFirst("(login = ? or email = ?) and password = ?",login,login,password);
        if (loginUser == null) {
            resp.sendRedirect("/notfound");
        }
        else {
            Session s = Session.create();
            resp.sendRedirect("/");
        }
    }
}
