package org.yablogo.practice.resources;


import org.yablogo.practice.model.Post;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by litemn on 30.11.14.
 */
@Path("/api/posts")
public class ApiPostResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getPosts() {
        return Post.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post getPost(@PathParam("id") int id) {
        return Post.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Post newPost(Post post) {
        Post newPost = new Post();
        newPost.setBody(post.getBody());
        newPost.setTitle(post.getTitle());
        newPost.saveIt();
        return newPost;

    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Post editPost(Post post, @PathParam("id") int id) {
        Post editPost = Post.findById(id);
        if (editPost != null) {
            editPost.setBody(post.getBody());
            editPost.setTitle(post.getTitle());
            editPost.saveIt();
        }
        return editPost;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePost(@PathParam("id") int id) {
        Post post = Post.findById(id);
        Response res;
        if (post != null) {
            post.delete();
            res = Response.accepted().build();
        } else {
            res = Response.notModified().build();
        }

        return res;
    }


}
