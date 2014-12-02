package org.yablogo.practice.integration.scope;


import com.jayway.restassured.internal.assertion.Assertion;
import net.anthavio.phanbedder.Phanbedder;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.yablogo.practice.rules.PhantomJSRule;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.File;

public class ClientIndexPageITest {
    protected static PhantomJSDriver driver;

    protected static final String BASEADDR = "http://0.0.0.0:3000";

    @Rule
    public PhantomJSRule ph = new PhantomJSRule();

    @Test
    public void testIt(){
        ph.driver.get(BASEADDR);
        WebElement el = ph.driver.findElementById("content");
        assertEquals("Tag should contain Hello world!","Hello world!",el.getText());
    }
}