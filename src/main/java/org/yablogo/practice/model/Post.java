package org.yablogo.practice.model;

import org.javalite.activejdbc.Model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by litemn on 22.11.14.
 */
public class Post extends Model {
    public String getTitle() {
        return getString("title");
    }

    public void setTitle(String title) {
        setString("title", title);
    }

    public String getBody() {
        return getString("body");
    }

    public void setBody(String body) {
        setString("body", body);
    }

    public Timestamp getUpdatedAt() {
        return getTimestamp("updated_at");
    }

    public Timestamp getCreatedAt() {
        return getTimestamp("created_at");
    }


}
