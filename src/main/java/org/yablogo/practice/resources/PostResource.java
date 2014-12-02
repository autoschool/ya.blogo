package org.yablogo.practice.resources;


import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import org.yablogo.practice.model.Comment;
import org.yablogo.practice.model.Post;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
* Created by litemn on 24.11.14.
*/

@Path("post")
@Produces(MediaType.TEXT_HTML)
@ErrorTemplate(name = "/error.ftl")
public class PostResource {

    @GET
    @Path("/{id}")
    @Template(name = "/post/showPost.ftl")
    public Post show(@PathParam("id") int id) {
        return Post.findById(id);
    }

    @GET
    @Path("/all")
    @Template(name = "/post/showPosts.ftl")
    public List<Post> showPosts() {
        return Post.findAll();
    }

    @GET
    @Path("/new")
    @Template(name = "/post/newPost.ftl")
    public Post newPost() {
        return new Post();
    }

    @POST
    @Path("/")
    @Template(name = "/post/showPost.ftl")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Post createPost(@FormParam("title") String title,
                           @FormParam("body") String body) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.saveIt();
        return post;
    }

    @GET
    @Path("/edit/{id}")
    @Template(name = "/post/editPost.ftl")
    public Post editPost(@PathParam("id") int id) {
        return Post.findById(id);
    }

    @POST
    @Path("/{id}")
    @Template(name = "/post/showPost.ftl")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Post changePost(@FormParam("changeTitle") String title,
                           @FormParam("changeBody") String body, @PathParam("id") int id) {
        Post post = Post.findById(id);
        if (post != null) {
            post.setBody(body);
            post.setTitle(title);
            post.saveIt();
        }
        return post;

    }

    @POST
    @Path("/delete/{id}")
    @Template(name = "/post/showPosts.ftl")
    public List<Post> deletePost(@PathParam("id") int id) {
        Post post = Post.findById(id);

        if (post != null) {
            List<Comment> comments = post.getComments();
            for (Comment comment : comments) {
                comment.delete();
            }
            post.delete();
        }
        return Post.findAll();
    }

    @POST
    @Path("/{id}/comment")
    @Template(name = "/post/showPost.ftl")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Post addComment(@PathParam("id") int postId, @FormParam("message") String message) {
        Comment comment = new Comment();
        Post post = Post.findById(postId);
        comment.setMessage(message);
        comment.setPostId(postId);
        comment.saveIt();
        if (post != null) {
            post.addComment(comment);
        }

        return post;
    }


}
