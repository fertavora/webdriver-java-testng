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
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "LogInDataProvider")
    public void loginValidTest(String username, String password) {
        LoginPage logInPage = new LoginPage(this.driver);
        InventoryPage inventoryPage = logInPage
                .goToPage()
                .setInputUsername(username)
                .setInputPassword(password)
                .clickLoginButton();

        inventoryPage.isReady();
        Assert.assertEquals(inventoryPage.getInventoryPageTitle(), "Products", "The Inventory page title is not correct!");
    }

    @Test
    public void loginInvalidTest(){
        LoginPage logInPage = new LoginPage(this.driver);
        String error = logInPage
            .goToPage()
            .setInputUsername("locked_out_user")
            .setInputPassword("secret_sauce")
            .clickLoginButtonError()
            .getErrorMessage();

        Assert.assertEquals(error, "Epic sadface: Sorry, this user has been locked out.");
    }
}
