package tech.fertavora.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private final By cartCheckoutButton = By.className("checkout_button");
    // private final By cartQtyLabel = By.className("cart_quantity_label");
    // private final By cartDescriptionLabel = By.className("cart_desc_label");

    public CartPage(WebDriver driver){
        super(driver);
    }

    public WebElement cartCheckoutButtonIsClickable(){
        return waitForClickable(cartCheckoutButton);
    }
}
