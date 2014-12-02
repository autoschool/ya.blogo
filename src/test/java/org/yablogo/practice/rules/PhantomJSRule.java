package org.yablogo.practice.rules;

import net.anthavio.phanbedder.Phanbedder;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * Created by sukharev on 02.12.14.
 */

public class PhantomJSRule extends ExternalResource {

    public static PhantomJSDriver driver;

    @Override
    public void before(){
        File phantomjs = Phanbedder.unpack();
        DesiredCapabilities dcaps = new DesiredCapabilities();
        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs.getAbsolutePath());
        driver = new PhantomJSDriver(dcaps);
    }

    @Override
    public void after(){
        driver.close();
    }
}
