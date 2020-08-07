package tech.fertavora.webdriver.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import tech.fertavora.pageobjects.LoginPage;
import tech.fertavora.webdriver.utils.PropertiesHelper;


import static tech.fertavora.webdriver.utils.WebdriverSetup.setWebdriver;
import static tech.fertavora.webdriver.utils.PropertiesHelper.arePropertiesDefined;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void start() throws Exception{
        if(arePropertiesDefined()) {
            driver = setWebdriver(PropertiesHelper.browserName, PropertiesHelper.webdriverLocation);
            driver.manage().window().maximize();
        } else {
            throw new Exception("There are system properties not defined. Check configuration or missing command line parameters.");
        }
    }

    @AfterClass
    public void stop() {
        driver.quit();
    }


}
