package tech.fertavora.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage implements IPage {

    private final By inputUsername = By.id("user-name");
    private final By inputPassword = By.id("password");
    private final By buttonLogin = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test=\"error\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage isReady() {
        driverWaitElement(ExpectedConditions.visibilityOfElementLocated(inputUsername));
        driverWaitElement(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        return this;
    }

    public LoginPage setInputUsername(String username) {
        this.driver.findElement(inputUsername).sendKeys(username);
        return this;
    }

    public LoginPage setInputPassword(String password) {
        this.driver.findElement(inputPassword).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButtonError() {
        this.driver.findElement(buttonLogin).click();
        return this;
    }

    public InventoryPage clickLoginButton() {
        this.driver.findElement(buttonLogin).click();
        return new InventoryPage(this.driver);
    }

    public String getErrorMessage() {
        driverWaitElement(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }

    @Override
    public LoginPage goToPage(){
        driver.get(sauceDemoURL);
        return this.isReady();
    }
}
