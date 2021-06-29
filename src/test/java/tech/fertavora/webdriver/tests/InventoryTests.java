package tech.fertavora.webdriver.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tech.fertavora.pageobjects.InventoryPage;

public class InventoryTests extends BaseTest {
    private InventoryPage inventoryPage;

    @BeforeClass
    public void setInventoryPageObject() {
        inventoryPage = new InventoryPage(this.driver);
    }

    @Test(priority = 1)
    public void addProductToCartTest() {
        int cartQty = inventoryPage
                                .goToPage()
                                .clickAddButtonByIndex(0)
                                .getCartQuantity();

        Assert.assertEquals(cartQty, 1);
    }

    @Test(priority = 2, enabled = false)
    public void removeProductFromCartTest(){
         inventoryPage
                .goToPage()
                .setCartState(1)
                .clickRemoveButtonByIndex(0);

        Assert.assertNotNull(inventoryPage.getCartQtyBadge());
    }

    @Test(priority = 3)
    public void goToCartTest(){
        WebElement checkoutButtonClickable = inventoryPage
                .goToPage()
                .clickGoToCartButton()
                .cartCheckoutButtonIsClickable();

        Assert.assertNotNull(checkoutButtonClickable);

    }

    @Test(priority = 4)
    public void goToProductDetailFromNameClick() throws InterruptedException {
        String itemName = inventoryPage
            .goToPage()
            .clickItemNameByIndex(0)
            .getItemDetailsName();
        
        Assert.assertNotNull(itemName);
        Assert.assertNotEquals(itemName, "");
    }

    @Test(priority = 5)
    public void goToProductDetailFromImageClick() throws InterruptedException {
        String itemName = inventoryPage
            .goToPage()
            .clickItemImageByIndex(0)
            .getItemDetailsName();

        Assert.assertNotNull(itemName);
        Assert.assertNotEquals(itemName, "");
    }

    @Test(enabled = false)
    public void sortingProductsTest(){
        // data provider four options
    }
}
