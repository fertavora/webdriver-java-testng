package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private By productCards = By.cssSelector("div.card");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public List<WebElement> productCardsList () {
        return this.driver.findElements(productCards);
    }

    public ProductPage clickProductCardByIndex(int index){
        waitForVisible(this.productCards);
        this.productCardsList().get(index).findElement(By.cssSelector("a.hrefch")).click();
        return new ProductPage(this.driver);
    }
}