package org.yablogo.practice.resources;


        import org.glassfish.jersey.server.mvc.ErrorTemplate;
        import org.glassfish.jersey.server.mvc.Template;
        import org.yablogo.practice.model.User;
        import javax.ws.rs.*;
        import javax.ws.rs.core.MediaType;
        import java.util.List;


/**
 * Created by Артем on 12.01.15.
 */
@Path("reg")
@Produces(MediaType.TEXT_HTML)
@ErrorTemplate(name = "/error.ftl")
public class RegResource {
    @GET
    @Path("/new")
    @Template(name = "/reg/newUser.ftl")
    public User newUser() {
        return new User();
    }

    @GET
    @Path("/all")
    @Template(name = "/reg/showUsers.ftl")
    public List<User> showUsers() {
        return User.findAll();
    }

    @POST
    @Path("/")
    @Template(name = "/reg/showUser.ftl")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public User createUser(@FormParam("login") String login,
                           @FormParam("password") String password,
                           @FormParam("email") String email) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.saveIt();
        return user;
    }
}
