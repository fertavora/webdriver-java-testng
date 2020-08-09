package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By placeOrderButton = By.cssSelector("button.btn[data-target='#orderModal']");
    
    public CartPage(WebDriver driver){
        super(driver);
    }

    public PlaceOrderPage clickPaceOrderButton(){
        this.driver.findElement(this.placeOrderButton).click();
        return new PlaceOrderPage(this.driver);
    }
}