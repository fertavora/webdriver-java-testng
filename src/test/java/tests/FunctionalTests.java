package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.HeaderPage;

public class FunctionalTests extends BaseTest{

    private HomePage homePage;
    private HeaderPage headerPage;
    
    @Test
    public void firstTest() throws InterruptedException {
        homePage = new HomePage(this.driver);
        homePage
            .clickProductCardByIndex(0)
            .clickAddToCartButton()
            .acceptAlert();
        headerPage = new HeaderPage(this.driver);
        headerPage
            .clickCartLink()
            .clickPaceOrderButton();

        Thread.sleep(3000);
    }
}
