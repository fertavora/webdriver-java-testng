package tech.fertavora.webdriver.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebdriverSetup {
    public static final String SELENIUM_HOST = "http://localhost:4444/wd/hub";

    // todo what about using DesiredCapabilities as method argument?
    public static WebDriver setWebdriver(String browserName, String location) throws MalformedURLException {
        WebDriver driver;

        switch(location){
            case "remote":
                DesiredCapabilities caps = new DesiredCapabilities();
                ChromeOptions opt = new ChromeOptions();
                caps.setCapability("browserName", browserName);
                caps.setCapability("platform", "linux");
                caps.setCapability("name", "My First Test");
                driver = new RemoteWebDriver(new URL(SELENIUM_HOST), opt);
                break;
            case "local":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;
            default:
                throw new IllegalStateException("Unexpected WebdriverLocation value: " + location);
        }

        return driver;
    }
}
