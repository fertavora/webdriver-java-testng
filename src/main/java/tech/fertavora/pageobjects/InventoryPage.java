package tech.fertavora.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage implements IPage {

    private final By inventoryItems = By.className("inventory_item");
    private final By inventoryItemsNames = By.className("inventory_item_name");
    private final By inventoryItemsImages = By.cssSelector("div[class='inventory_item_img']");
    private final By inventoryItemsAddButtons = By.cssSelector(".btn_primary.btn_inventory");
    private final By inventoryItemsRemoveButtons = By.cssSelector(".btn_secondary.btn_inventory");
    // todo review this locator for the remove scenario adding products with setCartState
    // locator for remove by item id //*[contains(@id, 'item_*_')]/../following-sibling::div/button[contains(@class, 'btn_secondary')]
    private final By inventoryPageTitle = By.className("product_label");
    private final By inventoryCartQtyBadge = By.cssSelector(".shopping_cart_badge");
    private final By inventoryGoToCartButton = By.id("shopping_cart_container");

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

    /**
     * Clicks a product remove button by its index
     * @param buttonIndex The index of the remove button to be clicked
     * @return InventoryPage The current inventory page
     */
    public InventoryPage clickRemoveButtonByIndex(int buttonIndex){
        List<WebElement> removeButtonsList = driver.findElements(this.inventoryItemsRemoveButtons);
        removeButtonsList.get(buttonIndex).click();
        return this;
    }

    /**
     * Clicks a product name by its index
     * @param nameIndex The index of the item name to be clicked
     * @return InventoryPage The current inventory page
     */
    public InventoryPage clickItemNameByIndex(int nameIndex){
        List<WebElement> removeButtonsList = driver.findElements(this.inventoryItemsNames);
        removeButtonsList.get(nameIndex).click();
        return this;
    }

    /**
     * Clicks a product image by its index
     * @param imageIndex The index of the item name to be clicked
     * @return InventoryPage The current inventory page
     */
    public InventoryPage clickItemImageByIndex(int imageIndex){
        List<WebElement> removeButtonsList = driver.findElements(this.inventoryItemsImages);
        removeButtonsList.get(imageIndex).click();
        return this;
    }

    /**
     * Clicks the shopping cart button
     * @return CartPage The shopping cart page
     */
    public CartPage clickGoToCartButton(){
        driver.findElement(inventoryGoToCartButton).click();
        return new CartPage(this.driver);
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
        String jsMethod = "sessionStorage.setItem('cart-contents', '" + products.toString() + "');";
        runJavaScript(jsMethod);
        this.driver.navigate().refresh();
        driverWaitElement(ExpectedConditions.visibilityOfElementLocated(inventoryCartQtyBadge));
        return this;
    }

    /**
     * Checks whether the cart quantity badge is displayed
     * @return boolean true for displayed, false for not displayed
     */
    public Boolean cartQtyBadgeIsDisplayed() {
        return isElementDisplayed(inventoryCartQtyBadge, false);
    }
}
