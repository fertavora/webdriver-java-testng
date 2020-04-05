package tech.fertavora.webdriver.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TodoMVCPage extends BasePage {
    
    private By inputField = By.cssSelector("input[class='new-todo']");
    
    public TodoMVCPage(WebDriver driver) {
        super(driver);
        WebDriverWait driverWait = new WebDriverWait(driver, 15);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(inputField));
    }
    
    public void setTodo(String keyword) {    
        this.driver.findElement(inputField).sendKeys(keyword + Keys.ENTER);
    }
}