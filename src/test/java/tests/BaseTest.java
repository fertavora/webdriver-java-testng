package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageobjects.TodoMVCPage;
import utils.PropertiesHelper;

import static utils.WebdriverSetup.setWebdriver;
import static utils.PropertiesHelper.arePropertiesDefined;

public class BaseTest {
    private WebDriver driver;
    protected TodoMVCPage todoMVCPage;
    private static final String todoMVCUrl = "http://todomvc.com/examples/react/#/";

    @BeforeClass
    public void start() throws Exception{
        if(arePropertiesDefined()) {
            driver = setWebdriver(PropertiesHelper.browserName, PropertiesHelper.webdriverLocation);
            driver.manage().window().maximize();
            driver.get(todoMVCUrl);

            todoMVCPage = new TodoMVCPage(driver);
        } else {
            throw new Exception("There are system properties not defined. Check configuration or missing command line parameters.");
        }
    }

    @AfterClass
    public void stop() {
        driver.quit();
    }


}
