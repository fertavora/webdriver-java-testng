package tech.fertavora.webdriver.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tech.fertavora.pageobjects.InventoryPage;

public class InventoryTests extends BaseTest {

    @Test
    public void addProductToCartTest() {
        InventoryPage inventoryPage = new InventoryPage(this.driver);

        int cartQty = inventoryPage
                                .goToPage()
                                .clickAddButtonByIndex(1)
                                .getCartQuantity();

        Assert.assertEquals(cartQty, 1);
    }

    @Test(enabled = false)
    public void removeProductFromCartTest(){}

    @Test(enabled = false)
    public void goToCartTest(){}

    @Test(enabled = false)
    public void goToProductDetail(){
        // data provider from title and image?
    }

    @Test(enabled = false)
    public void sortingProductsTest(){
        // data provider four options
    }
}
