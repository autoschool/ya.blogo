package org.yablogo.practice.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
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
@Path("auth")
@Produces(MediaType.TEXT_HTML)
@ErrorTemplate(name = "/error.ftl")
public class AuthResource {
    @GET
    @Path("/register")
    @Template(name = "/auth/register.ftl")
    public ViewData showRegisterForm() {

        ViewData view = new ViewData();

        view.authUser = (User) securityContext.getUserPrincipal();

        return view;
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String processRegister(@FormParam("login") String login,
                                  @FormParam("password") String password) throws IOException {

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail("");
        user.setAvatar("");

        user.saveIt();

        HttpSession session = request.getSession(true);
        session.setAttribute("userId", user.getId());

        response.sendRedirect("/user/" + user.getId());

        return "";
    }

    @GET
    @Path("/signin")
    @Template(name = "/auth/login.ftl")
    public ViewData showLoginForm() {

        ViewData view = new ViewData();

        view.authUser = (User) securityContext.getUserPrincipal();

        return view;

    }

    @POST
    @Path("/signin")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String processLogin(@FormParam("login") String login,
                               @FormParam("password") String password) throws IOException {

        User user = User.findFirst("login = ? and password = ?", login, password);

        if (user == null) {
            System.out.println("Login or password is wrong");
            response.sendRedirect( "/auth/error" );

            return "";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute( USER_ID_ATTRIBUTE , user.getId() );

        response.sendRedirect("/user/" + user.getId());

        return "";
    }

    @GET
    @Path("/error")
    @Template(name = "/auth/error.ftl")
    public ViewData showLoginError() {
        return new ViewData();
    }

    @GET
    @Path("/signout")
    public String processLogout() throws IOException {
        HttpSession session = request.getSession(true);
        session.removeAttribute( USER_ID_ATTRIBUTE );

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
