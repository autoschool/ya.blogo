package org.yablogo.practice.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import org.yablogo.practice.model.Post;
import org.yablogo.practice.model.User;
import org.yablogo.practice.view.ViewData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;

/**
 * Created by Артем on 21.01.15.
 */
@Path("user")
@Produces(MediaType.TEXT_HTML)
@ErrorTemplate(name = "/error.ftl")
public class UserResource {

    @GET
    @Path("/{id}")
    @Template(name = "/user/profile.ftl")
    public ViewData showUser(@PathParam("id") int id) {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.profile = User.findById(id);
        return view;
    }

    @GET
    @Path("/{id}/allposts")
    @Template(name = "/user/posts.ftl")
    public ViewData showUserposts(@PathParam("id") int id) {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.posts = Post.findAll();
        view.profile = User.findById(id);
        return view;
    }

    @GET
    @Path("/all")
    @Template(name = "/user/showUsers.ftl")
    public ViewData showUsers() {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.users = User.findAll();
        return view;
    }

    @GET
    @Path("/editprofile")
    @Template(name = "/user/editprofile.ftl")
    public ViewData showRegisterForm() {

        ViewData view = new ViewData();

        view.authUser = (User) securityContext.getUserPrincipal();

        return view;
    }

    @POST
    @Path("/editprofile")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String processRegister(@FormParam("email") String email,
                                  @FormParam("avatar") String avatar) throws IOException {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.authUser.setEmail(email);
        view.authUser.setAvatar(avatar);
        view.authUser.saveIt();

        response.sendRedirect("/");

        return "";
    }

    final static String USER_ID_ATTRIBUTE = "userId";

    @Context
    SecurityContext securityContext;

    @Context
    HttpServletRequest request;

    @Context
    HttpServletResponse response;

}
