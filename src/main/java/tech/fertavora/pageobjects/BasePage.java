package tech.fertavora.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected static final int WAIT_TIMEOUT_IN_SECONDS = 20;
    protected final String sauceDemoURL = System.getenv("SAUCEDEMO_URL");

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, WAIT_TIMEOUT_IN_SECONDS);
    }

    public void runJavaScript(String method){
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript(method);
    }

    public void runJavaScript(String method, Object args){
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript(method, args);
    }

    public WebElement waitForDisplayed(By locator){
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator){
        return this.wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
