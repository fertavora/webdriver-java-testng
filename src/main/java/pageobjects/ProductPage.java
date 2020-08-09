package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private By addToCartButton = By.cssSelector("a.btn");

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public ProductPage clickAddToCartButton() {
        waitForVisible(this.addToCartButton);
        this.driver.findElement(this.addToCartButton).click();
        return this;
    }

    public void acceptAlert() {
        waitForAlertIsPresent();
        this.driver.switchTo().alert().accept();
    }
}