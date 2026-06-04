package SeleniumClass;
import SeleniumClass.pages.BaseTest;
import SeleniumClass.pages.PromotionPage;
import SeleniumClass.pages.RegisterPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import SeleniumClass.pages.LoginPage;

public class validations extends BaseTest {
    private LoginPage loginpage;
    private RegisterPage registerpage;
    private PromotionPage promotionpage;

    @Test
    public void loginValidationSuccess() throws InterruptedException {
        loginpage = new LoginPage(driver);
        loginpage.login("admin","123456");

        Assert.assertTrue(driver.findElement(By.id("user-status")).isDisplayed());
        String message = driver.findElement(By.xpath("//*[@id=\"user-status\"]")).getText();
        Assert.assertEquals("✅ Admin logado", message);
    };

    @Test
    public void loginValidationError() throws InterruptedException {
        loginpage = new LoginPage(driver);
        loginpage.login("teste","erro");

        Assert.assertTrue(driver.findElement(By.id("login-error")).isDisplayed());
        String message = driver.findElement(By.xpath("//*[@id=\"login-error\"]")).getText();
        Assert.assertEquals("❌ Usuário ou senha inválidos. Use admin / 123456", message);
    };

    @Test
    public void logoutSuccess() throws InterruptedException {
        loginpage = new LoginPage(driver);
        loginpage.login("admin","123456");
        loginpage.logout();

        Assert.assertTrue(driver.findElement(By.id("user-status")).isDisplayed());
        String message = driver.findElement(By.xpath("//*[@id=\"user-status\"]")).getText();
        Assert.assertEquals("\uD83D\uDD12 Deslogado", message);
    };

    @Test
    public void promotionSuccess() throws InterruptedException {
        loginpage = new LoginPage(driver);
        promotionpage = new PromotionPage(driver);

        loginpage.login("admin","123456");

        promotionpage.promotionSuccess();

        Assert.assertTrue(driver.findElement(By.id("promotion-message")).isDisplayed());
        String message = driver.findElement(By.xpath("//*[@id=\"promotion-message\"]")).getText();
        Assert.assertEquals("\uD83C\uDF89 Promoção especial: banho completo com 20% OFF + brinde!", message);
    }

    @Test
    public void registerPetSuccess() throws InterruptedException {
        loginpage = new LoginPage(driver);
        registerpage = new RegisterPage(driver);

        loginpage.login("admin","123456");

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
