package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class FunctionalTests {
    private WebDriver driver;
    private String appUrl = "http://todomvc.com/examples/react/#/";
    public static final String SELENIUM_HOST = "http://localhost:4444/wd/hub";

    @BeforeMethod
    public void start() throws Exception{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "chrome");
        caps.setCapability("platform", "linux");
        caps.setCapability("name", "My First Test");

        driver = new RemoteWebDriver(new URL(SELENIUM_HOST), caps);
        driver.manage().window().maximize();
        driver.get(appUrl);
    }

    @Test
    public void firstTest() {
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void stop() {
        driver.quit();
    }
}
