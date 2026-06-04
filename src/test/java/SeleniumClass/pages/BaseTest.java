package SeleniumClass.pages;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    private final String URL = "C:///Users/ISABEL/Documents/indra/selenium-curso/selenium-desafio/desafio_final_selenium_java.html";
    protected WebDriver driver;

    @Before
    public final void init() {
        driver = new ChromeDriver();
        driver.get(URL);
        Assert.assertTrue(driver.findElement(By.id("login-page")).isDisplayed());
    }

    @After
    public void end() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
