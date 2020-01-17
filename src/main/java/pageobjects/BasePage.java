package java.pageobjects;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
}
