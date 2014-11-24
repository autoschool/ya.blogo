package org.yablogo.practice.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import org.yablogo.practice.model.Post;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
    public List<Post> showIndex() {
        return Post.findAll();
    }


}
