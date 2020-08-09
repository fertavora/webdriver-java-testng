package tech.fertavora.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage implements IPage {

    private final By inputUsername = By.id("user-name");
    private final By inputPassword = By.id("password");
    private final By buttonLogin = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test=\"error\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * See the interface method
     * @return LoginPage The login page object in a ready state
     */
    public LoginPage isReady() {
        driverWaitElement(ExpectedConditions.visibilityOfElementLocated(inputUsername));
        driverWaitElement(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        return this;
    }

    /**
     * See the interface method
     * @return LoginPage The login page object in a ready state
     */
    public LoginPage goToPage(){
        driver.get(sauceDemoURL);
        return this.isReady();
    }

    /**
     * Enters the username in the username field
     * @param username String the username string
     * @return LoginPage The login page object
     */
    public LoginPage setInputUsername(String username) {
        this.driver.findElement(inputUsername).sendKeys(username);
        return this;
    }

    /**
     * Enters the password in the password field
     * @param password String the password string
     * @return LoginPage The login page object
     */
    public LoginPage setInputPassword(String password) {
        this.driver.findElement(inputPassword).sendKeys(password);
        return this;
    }

    /**
     * Clicks the login button in the login form
     * @return LoginPage The login page object to verify an error message
     */
    public LoginPage clickLoginButtonError() {
        this.driver.findElement(buttonLogin).click();
        return this;
    }

    /**
     * Clicks the login button in the login form for a valid login
     * @return InventoryPage The inventory page object, landing page after log in
     */
    public InventoryPage clickLoginButton() {
        this.driver.findElement(buttonLogin).click();
        return new InventoryPage(this.driver);
    }

    /**
     * The error message displayed after an invalid login
     * @return String The error message string
     */
    public String getErrorMessage() {
        driverWaitElement(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }
}
