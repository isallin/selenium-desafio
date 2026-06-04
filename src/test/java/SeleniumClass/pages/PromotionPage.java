package SeleniumClass.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PromotionPage {
    public WebDriver driver;

    @FindBy(id = "promotion-button")
    public WebElement promotionButton;

    public PromotionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void promotionSuccess() {
        promotionButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
