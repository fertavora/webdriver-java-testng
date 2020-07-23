package tech.fertavora.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected final String sauceDemoURL = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected void driverWaitElement(ExpectedCondition<?> expectedCondition){
        WebDriverWait wait = new WebDriverWait(this.driver,15);
        wait.until(expectedCondition);
    }
}
