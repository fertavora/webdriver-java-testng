package tech.fertavora.webdriver.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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

    @Test(priority = 2)
    public void removeProductFromCartTest(){
         inventoryPage
                .goToPage()
                .setCartState(1)
                .clickRemoveButtonByIndex(0);

        boolean badgeDisplayed = inventoryPage.cartQtyBadgeIsDisplayed();
        Assert.assertFalse(badgeDisplayed);
    }

    @Test(priority = 3)
    public void goToCartTest(){
        boolean checkoutButtonClickable = inventoryPage
                .goToPage()
                .clickGoToCartButton()
                .cartCheckoutButtonIsClickable();

        Assert.assertTrue(checkoutButtonClickable);

    }

    @DataProvider(name = "GoToProductDetailDataProvider")
    public Object[][] peopleData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "GoToProductDetailDataProvider")
    public void goToProductDetail(){
        // data provider from title and image?
    }

    @Test(enabled = false)
    public void sortingProductsTest(){
        // data provider four options
    }
}
