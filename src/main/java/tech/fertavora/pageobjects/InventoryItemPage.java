package tech.fertavora.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryItemPage extends BasePage implements IPage {

    private final By itemDetailsName = By.className("inventory_details_name");
    private final By itemDetailsImage = By.className("inventory_details_img");
    private final By itemDetailsBackButton = By.className("inventory_details_back_button");
    private final By itemDetailsAddButton = By.cssSelector(".btn_primary.btn_inventory");

    public InventoryItemPage(WebDriver driver){
        super(driver);
    }

    @Override
    public BasePage isReady() {
        waitForDisplayed(itemDetailsName);
        waitForDisplayed(itemDetailsImage);
        return this;
    }

    @Override
    public BasePage goToPage() {
        driver.get(sauceDemoURL + "inventory-item.html?id=4");
        this.isReady();
        return null;
    }

    public String getItemDetailsName() {
        return driver.findElement(this.itemDetailsName).getText();
    }
}