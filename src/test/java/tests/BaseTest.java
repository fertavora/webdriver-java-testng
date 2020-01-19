package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.URL;

import pageobjects.TodoMVCPage;

public class BaseTest {
    private WebDriver driver;
    protected TodoMVCPage todoMVCPage;
    private String appUrl = "http://todomvc.com/examples/react/#/";
    public static final String SELENIUM_HOST = "http://localhost:4444/wd/hub";
    
    @BeforeClass
    public void start() throws Exception{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "chrome");
        caps.setCapability("platform", "linux");
        caps.setCapability("name", "My First Test");

        driver = new RemoteWebDriver(new URL(SELENIUM_HOST), caps);
        driver.manage().window().maximize();
        driver.get(appUrl);

        todoMVCPage = new TodoMVCPage(driver);
    }

    @AfterClass
    public void stop() {
        driver.quit();
    }
    

}