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
    @Path("/{username: .*}")
    @Template(name = "/index.ftl")
    public String showIndex(@PathParam("username") String path) {
        return path;
    }
}
