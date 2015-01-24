package org.yablogo.practice.resources;


import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Template;
import org.yablogo.practice.model.Comment;
import org.yablogo.practice.model.Post;
import org.yablogo.practice.model.User;
import org.yablogo.practice.view.ViewData;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;
import java.util.List;

/**
 * Created by litemn on 24.11.14.
 */

@Path("post")
@Produces(MediaType.TEXT_HTML)
@ErrorTemplate(name = "/error.ftl")
public class PostResource {
    @Context
    HttpServletResponse response;

    @Context
    SecurityContext securityContext;

    @GET
    @Path("/{id}")
    @Template(name = "/post/showPost.ftl")
    public ViewData showPost(@PathParam("id") int id) {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.post = Post.findById(id);
        return view;
    }

    @GET
    @Path("/all")
    @Template(name = "/post/showPosts.ftl")
    public ViewData showPosts() {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.posts = Post.findAll();
        return view;
    }

    @GET
    @Path("/new")
    @Template(name = "/post/newPost.ftl")
    public ViewData newPost() {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.post = new Post();
        return view;
    }

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createPost(@FormParam("title") String title,
                             @FormParam("body") String body) throws IOException {

        User authUser = (User) securityContext.getUserPrincipal();

        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.setUserId((int) authUser.getId());
        post.saveIt();

        response.sendRedirect("/post/" + post.getId());

        return "";
    }

    @POST
    @Path("/{id}/comment")
    @Template(name = "/post/showPosts.ftl")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addComment(@PathParam("id") String fPostId,
                             @FormParam("message") String fCommentBody) throws IOException {

        User authUser = (User) securityContext.getUserPrincipal();

        Comment comment = new Comment();
        comment.setPostId(Integer.parseInt(fPostId));
        comment.setMessage(fCommentBody);
        comment.setUserId((int) authUser.getId());
        comment.saveIt();

        response.sendRedirect("/post/" + fPostId);

        return "";
    }

    @GET
    @Path("/edit/{id}")
    @Template(name = "/post/editPost.ftl")
    public ViewData editPost(@PathParam("id") int id) {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.post = Post.findById(id);
        return view;
    }

    @POST
    @Path("/editing/{id}")
    public String updatePost(@FormParam("changeTitle") String title,
                             @FormParam("changeBody") String body,@PathParam("id") int id) throws IOException {

        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.post = Post.findById(id);
        view.post.setTitle(title);
        view.post.setBody(body);
        view.post.saveIt();

        response.sendRedirect("/");

        return "";
    }

    @POST
    @Path("/delete/{id}")
    public String deletePost(@PathParam("id") int id) throws IOException {
        ViewData view = new ViewData();
        view.authUser = (User) securityContext.getUserPrincipal();
        view.post = Post.findById(id);
        if (view.post != null) {
            List<Comment> comments = view.post.getComments();
            for (Comment comment : comments) {
                comment.delete();
            }
            view.post.delete();
        }

        response.sendRedirect("/");
        return "";
    }
}
