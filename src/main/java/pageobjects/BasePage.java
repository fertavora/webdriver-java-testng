package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForVisible(By byLocator) {
        this.waitForVisible(byLocator, 15);
    }
    public void waitForVisible(By byLocator, long seconds){
        WebDriverWait driverWait = new WebDriverWait(driver, seconds);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    }

    public void waitForAlertIsPresent() {
        WebDriverWait driverWait = new WebDriverWait(driver, 15);
        driverWait.until(ExpectedConditions.alertIsPresent());
    }
}
