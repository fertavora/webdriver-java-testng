package tech.fertavora.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By cartCheckoutButton = By.className("checkout_button");
    // private final By cartQtyLabel = By.className("cart_quantity_label");
    // private final By cartDescriptionLabel = By.className("cart_desc_label");

    /***
     * The Shoping Cart Page Object constructor
     * @param driver The webdriver for the base class constructor
     */
    public CartPage(WebDriver driver){
        super(driver);
    }

    /**
     * Checks whether the checkout button is displayed
     * @return boolean true for displayed, false for not displayed
     */
    public boolean cartCheckoutButtonIsClickable(){
        return this.isElementClickable(cartCheckoutButton);
    }
}
