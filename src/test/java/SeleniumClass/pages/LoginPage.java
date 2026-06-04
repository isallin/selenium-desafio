package SeleniumClass.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    @FindBy(id = "login-username")
    public WebElement usernameField;

    @FindBy(id = "login-password")
    public WebElement passwordField;
    
    @FindBy(id = "login-submit")
    public WebElement loginButton;

    @FindBy(id = "logout-button")
    public WebElement logoutButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) throws InterruptedException {
        usernameField.sendKeys(user);
        passwordField.sendKeys(pass);
        loginButton.click();
        Thread.sleep(2000);
    }

    public void logout() throws InterruptedException {
        logoutButton.click();
        Thread.sleep(2000);
    }

}