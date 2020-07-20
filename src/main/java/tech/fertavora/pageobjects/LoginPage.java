package tech.fertavora.pageobjects;

import org.graalvm.compiler.nodes.InvokeWithExceptionNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage implements IPage {

    private final By inputUsername = By.id("user-name");
    private final By inputPassword = By.id("password");
    private final By buttonLogin = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage isReady() {
        driverWait(15).until(ExpectedConditions.visibilityOfElementLocated(inputUsername));
        driverWait(15).until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
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

    @Override
    public LoginPage goToPage(){
        driver.get(sauceDemoURL);
        return this.isReady();
    }
}
