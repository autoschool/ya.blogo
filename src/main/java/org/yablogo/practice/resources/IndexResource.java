package org.yablogo.practice.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import org.yablogo.practice.model.Post;
import org.yablogo.practice.model.User;
import org.yablogo.practice.view.ViewData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;


/**
 * Created by litemn on 22.11.14.
 */

@Path("/")
@ErrorTemplate(name = "/error.ftl")
@Produces(MediaType.TEXT_HTML)
public class IndexResource {
    @Context
    HttpServletRequest request;

    @Context
    HttpServletResponse response;

    @Context
    SecurityContext securityContext;

    @GET
    @Path("/")
    @Template(name = "/post/showPosts.ftl")
    public ViewData showIndex() {

        ViewData view = new ViewData();

        view.authUser = (User) securityContext.getUserPrincipal();
        view.posts = Post.findAll();

        return view;
    }
}
