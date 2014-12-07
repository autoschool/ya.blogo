package org.yablogo.practice.integration.scope.API;

import com.jayway.restassured.http.ContentType;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

/**
 * Created by sukharev on 02.12.14.
 */
public class PostTest {

    final static String HOST = "http://127.0.0.1:3000";


    @Test
    public void testGetRequest() {
        expect().statusCode(200).contentType(ContentType.JSON).when()
                .get(HOST + "/api/posts");
    }

    @Test
    public void testPostRequest() {
        String json = "{\"type\":\"post\",\"body\":\"message\",\"title\":\"test\"}";

        given().body(json).contentType(MediaType.APPLICATION_JSON).expect().
                statusCode(200).
                body(
                        "id.value", is(1),
                        "title", is("test"),
                        "body", is("message")).
                when().
                post(HOST + "/api/posts");

    }

    @Test
    public void testBadPostRequest() {
        String json = "Bad Json";

        given().body(json).contentType(MediaType.APPLICATION_JSON).expect().
                statusCode(400).
                post(HOST + "/api/posts");

    }

    @Test
    public void testGetBadIdRequest() {
        expect().statusCode(204).when()
                .get(HOST + "/api/posts/0");
    }


    @Test
    public void testPutRequest() {
        String json = "{\"type\":\"post\",\"body\":\"message\",\"title\":\"test\"}";

        given().body(json).contentType(MediaType.APPLICATION_JSON).
                expect().
                statusCode(204).
                when().put(HOST + "/api/posts/1");
    }

    @Test
    public void testBadPutRequest() {
        String json = "Not JSON as well";
        given().body(json).contentType(MediaType.APPLICATION_JSON).
                expect().
                statusCode(400).
                when().put(HOST + "/api/posts/1");
    }


}
