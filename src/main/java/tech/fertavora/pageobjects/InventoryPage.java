package tech.fertavora.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class InventoryPage extends BasePage implements IPage {

    private final By inventoryItems = By.className("inventory_item");
    private final By inventoryItemsNames = By.className("inventory_item_name");
    private final By inventoryPageTitle = By.className("product_label");

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    public List<WebElement> getInventoryItemsList() {
        return this.driver.findElements(inventoryItems);
    }

    public WebElement getInventoryItemByName(String name) {
        List<WebElement> inventoryItems = this.getInventoryItemsList();

        for(WebElement inventoryItem: inventoryItems){
            WebElement item = inventoryItem.findElement(inventoryItemsNames);
            if (item.getText().equals(name)){
                return item;
            }
        }

        return null;
    }

    @Override
    public InventoryPage isReady() {
        driverWait(15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItems));
        return this;
    }

    public String getInventoryPageTitle() {
        return driver.findElement(inventoryPageTitle).getText();
    }

    public InventoryPage goToPage() {
        driver.get(sauceDemoURL + "inventory.html");
        return this.isReady();
    }
}
