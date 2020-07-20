package tech.fertavora.webdriver.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tech.fertavora.pageobjects.InventoryPage;
import tech.fertavora.pageobjects.LoginPage;

public class LogInTests extends BaseTest {
    @DataProvider(name = "LogInDataProvider")
    public Object[][] peopleData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
//                {"locked_out_user", "secret_sauce"},
//                {"problem_user", "secret_sauce"},
//                {"performance_glitch_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "LogInDataProvider")
    public void firstTest(String username, String password) {
        LoginPage logInPage = new LoginPage(driver);
        InventoryPage inventoryPage = logInPage
                .goToPage()
                .setInputUsername(username)
                .setInputPassword(password)
                .clickLoginButton();

        inventoryPage.isReady();
        Assert.assertEquals(inventoryPage.getInventoryPageTitle(), "Products", "The Inventory page title is not correct!");
    }
}
