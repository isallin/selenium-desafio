package SeleniumClass;
import SeleniumClass.pages.BaseTest;
import SeleniumClass.pages.RegisterPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import SeleniumClass.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class validations extends BaseTest {
    private LoginPage loginpage;
    private RegisterPage registerpage;

    @Test
    public void loginValidationSuccess() {
        loginpage = new LoginPage(driver);
        loginpage.login("admin","123456");

        Assert.assertTrue(driver.findElement(By.id("login-success")).isDisplayed());
        String message = driver.findElement(By.xpath("//*[@id=\"login-success\"]")).getText();
        Assert.assertEquals("✅ Login realizado! Redirecionando...", message);
    };

    @Test
    public void registerPetSuccess() throws InterruptedException {
        loginpage = new LoginPage(driver);
        registerpage = new RegisterPage(driver);

        loginpage.login("admin","123456");
        Thread.sleep(2000);

        registerpage.registerPetSuccess(
                "Oreo",
                "Isabel",
                "Cachorro \uD83D\uDC15",
                "1 ano e 8 meses",
                "Bagunceiro",
                "C:///Users/ISABEL/Documents/indra/selenium-curso/selenium-desafio/oreo.png"
        );

        Assert.assertTrue(driver.findElement(By.id("pet-success")).isDisplayed());
        String message = driver.findElement(By.xpath("//*[@id=\"pet-success\"]")).getText();
        Assert.assertEquals("✅ Pet cadastrado com sucesso!", message);
    }
}
