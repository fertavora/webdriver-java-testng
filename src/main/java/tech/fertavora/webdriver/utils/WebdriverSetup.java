package tech.fertavora.webdriver.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebdriverSetup {
    public static final String SELENIUM_HOST = "http://localhost:4444/wd/hub";

    public static WebDriver setWebdriver(String browserName, String location) throws MalformedURLException {
        WebDriver driver;

        switch(location){
            case "remote":
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browserName", browserName);
                caps.setCapability("platform", "linux");
                caps.setCapability("name", "My First Test");
                driver = new RemoteWebDriver(new URL(SELENIUM_HOST), caps);
                break;
            case "local":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected WebdriverLocation value: " + location);
        }

        return driver;
    }
}
