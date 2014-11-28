package org.yablogo.practice.integration.scope;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;

/**
 * Created by sukharev on 25.11.14.
 */
public class ScopeTest{
    @Test
    public void testIt(){
        get("http://127.0.0.1:9998").then().assertThat().statusCode(200);
    }
}
