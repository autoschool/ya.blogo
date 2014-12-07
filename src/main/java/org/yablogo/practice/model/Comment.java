package org.yablogo.practice.model;

import org.javalite.activejdbc.Model;

import java.sql.Timestamp;

/**
 * Created by litemn on 18.11.14.
 */
public class Comment extends Model {

    public int getPostId() {
        return getInteger("post_id");
    }

    public void setPostId(int postId) {
        setInteger("post_id", postId);
    }

    public String getMessage() {
        return getString("message");
    }

    public void setMessage(String message) {
        setString("message", message);
    }

    public Timestamp getUpdatedAt() {
        return getTimestamp("updated_at");
    }

    public Timestamp getCreatedAt() {
        return getTimestamp("created_at");
    }
}
