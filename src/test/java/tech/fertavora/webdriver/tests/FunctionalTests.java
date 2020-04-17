package tech.fertavora.webdriver.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FunctionalTests extends BaseTest{

    @Test
    public void firstTest() throws InterruptedException {
        todoMVCPage.setTodo("sarasa");
        Thread.sleep(5000);
        Assert.assertTrue(true);
    }
}
