package tech.fertavora.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected final String sauceDemoURL = "https://www.saucedemo.com/";

    /**
     * The Base page constructor
     * @param driver the webdriver running tests
     */
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Generic wait for expected condition
     * If waitTimeout system property is not set, it defaults to 15 seconds
     * @param expectedCondition the condition to expect
     */
    protected void driverWaitElement(ExpectedCondition<?> expectedCondition){
        int timeout = Integer.parseInt(System.getProperty("waitTimeout", "15"));
        WebDriverWait wait = new WebDriverWait(this.driver,timeout);
        wait.until(expectedCondition);
    }

    /**
     * Executes a script in the browser console to set specific page states
     * @param method The javascript script to run
     */
    public void runJavaScript(String method){
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript(method);
    }

    /**
     * Executes a script in the browser console to set specific page states
     * @param method The javascript script to run
     * @param args The javascript script arguments to pass to the method
     */
    public void runJavaScript(String method, Object args){
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript(method, args);
    }
}
