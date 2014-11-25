package org.yablogo.practice.resources;

import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;

import org.javalite.activejdbc.LazyList;
import org.yablogo.practice.model.Post;
import org.yablogo.practice.scope.IndexScope;
import org.yablogo.practice.scope.PostScope;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    @Path("/")
    @Template(name = "/index.ftl")
    public IndexScope showIndex(@BeanParam IndexScope scope) {
        return scope;
    }
}
