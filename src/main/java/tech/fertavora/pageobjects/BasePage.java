package tech.fertavora.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected final String sauceDemoURL = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected WebDriverWait driverWait(int timeout) {
        return new WebDriverWait(this.driver, timeout);
    }
}
