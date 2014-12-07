package org.yablogo.practice.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


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
