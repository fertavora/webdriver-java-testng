package tech.fertavora.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventoryPage extends BasePage implements IPage {

    private final By inventoryItems = By.className("inventory_item");
    private final By inventoryItemsNames = By.className("inventory_item_name");
    private final By inventoryItemsAddButtons = By.cssSelector(".btn_primary.btn_inventory");
    // todo review this locator for the remove scenario adding products with setCartState
    // locator for remove by item id //*[contains(@id, 'item_*_')]/../following-sibling::div/button[contains(@class, 'btn_secondary')]
    private final By inventoryPageTitle = By.className("product_label");
    private final By inventoryCartQtyBadge = By.cssSelector(".shopping_cart_badge");

    /***
     * The Inventory Page Object constructor
     * @param driver The webdriver for the base class constructor
     */
    public InventoryPage(WebDriver driver){
        super(driver);
    }

    /**
     * See the interface method
     * @return InventoryPage The inventory page object in a ready state
     */
    public InventoryPage isReady() {
        driverWaitElement(ExpectedConditions.visibilityOfAllElementsLocatedBy(this.inventoryItems));
        return this;
    }

    /**
     * See the interface method
     * @return InventoryPage The inventory page object in a ready state
     */
    public InventoryPage goToPage() {
        driver.get(sauceDemoURL + "inventory.html");
        this.isReady();
        return this.resetShoppingCart();
    }

    /**
     * Gets the list of inventory items
     * @return List<WebElement> Inventory Items WebElements list
     */
    public List<WebElement> getInventoryItemsList() {
        return this.driver.findElements(inventoryItems);
    }

    /**
     * Gets a product from the list by its name
     * @param name The name of the product to be returned
     * @return WebElement The product WebElement
     */
    public WebElement getInventoryItemByName(String name) {
        List<WebElement> inventoryItems = this.getInventoryItemsList();

        for(WebElement inventoryItem: inventoryItems){
            WebElement item = inventoryItem.findElement(this.inventoryItemsNames);
            if (item.getText().equals(name)){
                return item;
            }
        }

        return null;
    }

    /**
     * Gets the inventory page title
     * @return String the inventory page title
     */
    public String getInventoryPageTitle() {
        return driver.findElement(this.inventoryPageTitle).getText();
    }

    /**
     * Clicks a product add button by its index
     * @param buttonIndex The index of the add button to be clicked
     * @return InventoryPage The current inventory page
     */
    public InventoryPage clickAddButtonByIndex(int buttonIndex){
        List<WebElement> addButtonsList = driver.findElements(this.inventoryItemsAddButtons);
        addButtonsList.get(buttonIndex).click();
        return this;
    }

    /***
     * Returns the quantity of products already added to cart from the cart icon badge
     * @return int The quantity of products in the car
     */
    public int getCartQuantity(){
        if(driver.findElement(this.inventoryCartQtyBadge).isDisplayed()){
            return Integer.parseInt(driver.findElement(this.inventoryCartQtyBadge).getText(), 10);
        }
        return 0;
    }

    /**
     * Removes products from the shopping cart icon in the Inventory Page
     * @return InventoryPage The current inventory page
     */
    public InventoryPage resetShoppingCart(){
        runJavaScript("sessionStorage.clear();");
        return this;
    }

    /**
     * Sets the product cart state with the specified amount of products
     * @param productsQuantity The amount of products to have in the cart. Should be 1 <= productsQuantity <= 6
     * @return
     */
    public InventoryPage setCartState(int productsQuantity) {
        // todo validate that 1 <= productsQuantity <= 6
        ArrayList<Integer> products = new ArrayList<Integer>();

        for(int i=0; i < productsQuantity; i++){
            products.add(i+1);
        }
        System.out.println("products: " + products.toString());
        String jsMethod = "sessionStorage.setItem('cart-contents', '" + products.toString() + "');";
        runJavaScript(jsMethod);
        this.driver.navigate().refresh();
        return this;
    }

}
