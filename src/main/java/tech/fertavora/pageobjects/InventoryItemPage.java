package tech.fertavora.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryItemPage extends BasePage implements IPage {

    private By itemDetailsName = By.className("inventory_details_name");
    private By itemDetailsImage = By.className("inventory_details_img");

    /***
     * The Inventory Page Object constructor
     * @param driver The webdriver for the base class constructor
     */
    public InventoryItemPage(WebDriver driver){
        super(driver);
    }

    /**
     * See the interface method
     * @return InventoryItemPage The inventory item page object in a ready state
     */
    @Override
    public BasePage isReady() {
        driverWaitElement(ExpectedConditions.visibilityOfAllElementsLocatedBy(this.itemDetailsName));
        driverWaitElement(ExpectedConditions.visibilityOfAllElementsLocatedBy(this.itemDetailsImage));
        return null;
    }

    /**
     * See the interface method
     * @return InventoryItemPage The inventory item page object in a ready state
     */
    @Override
    public BasePage goToPage() {
        driver.get(sauceDemoURL + "inventory-item.html?id=4");
        this.isReady();
        return null;
    }
}