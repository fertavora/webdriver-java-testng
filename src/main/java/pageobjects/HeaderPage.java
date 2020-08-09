package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage extends BasePage {
    
    private By cartButton = By.id("cartur");
    private By homeButton = By.id("nava");

    public HeaderPage(WebDriver driver) {
        super(driver);
        WebDriverWait driverWait = new WebDriverWait(driver, 15);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(cartButton));
    }
    
    public HomePage goHome() {    
        this.driver.findElement(homeButton).click();
        return new HomePage(this.driver);
    }

    public CartPage clickCartLink() {
        this.driver.findElement(this.cartButton).click();
        return new CartPage(this.driver);
    }
}