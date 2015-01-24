package org.yablogo.practice.view;

import org.yablogo.practice.model.Post;
import org.yablogo.practice.model.User;

import java.util.List;

/**
 * Created by Артем on 21.01.15.
 */
public class ViewData {
    public User authUser;
    public Post post;
    public List<Post> posts;
    public List<User> users;
    public User profile;


    public User getAuthUser() {
        return authUser;
    }

    public Post getPost() {
        return post;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getProfile() {
        return profile;
    }
}
