package org.yablogo.practice.integration.scope;


import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.yablogo.practice.rules.PhantomJSRule;

import static org.junit.Assert.assertEquals;

public class ClientIndexPageITest {
    protected static PhantomJSDriver driver;

    protected static final String BASEADDR = "http://0.0.0.0:3000";

    @Rule
    public PhantomJSRule ph = new PhantomJSRule();

    @Test
    public void testIt() {
        ph.driver.get(BASEADDR);
        WebElement el = ph.driver.findElementById("content");
        assertEquals("Tag should contain Hello world!", "Hello world!", el.getText());
    }
}