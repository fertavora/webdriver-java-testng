package tech.fertavora.webdriver.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tech.fertavora.pageobjects.InventoryPage;
import tech.fertavora.pageobjects.LoginPage;

public class LogInTests extends BaseTest {

    private LoginPage loginPage;

    @DataProvider(name = "LogInDataProvider")
    public Object[][] peopleData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }

    @BeforeClass
    public void setLoginPage() {
        loginPage = new LoginPage(this.driver);
    }

    @Test(dataProvider = "LogInDataProvider")
    public void loginValidTest(String username, String password) {
        InventoryPage inventoryPage = loginPage
                .goToPage()
                .setInputUsername(username)
                .setInputPassword(password)
                .clickLoginButton();

        inventoryPage.isReady();
        Assert.assertEquals(inventoryPage.getInventoryPageTitle(), "Products", "The Inventory page title is not correct!");
    }

    @Test
    public void loginInvalidTest(){
        String error = loginPage
            .goToPage()
            .setInputUsername("locked_out_user")
            .setInputPassword("secret_sauce")
            .clickLoginButtonError()
            .getErrorMessage();

        Assert.assertEquals(error, "Epic sadface: Sorry, this user has been locked out.");
    }
}
