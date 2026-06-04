package SeleniumClass.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    public WebDriver driver;

    @FindBy(id = "open-register-page")
    public WebElement openRegister;

    @FindBy(id = "pet-name")
    public WebElement petName;

    @FindBy(id = "pet-owner")
    public WebElement petOwner;

    @FindBy(id = "pet-species")
    public WebElement petSpecies;

    @FindBy(id = "pet-age")
    public WebElement petAge;

    @FindBy(id = "pet-notes")
    public WebElement petNotes;

    @FindBy(id = "pet-vaccinated")
    public WebElement petVaccine;

    @FindBy(id = "pet-photo")
    public WebElement petPhoto;

    @FindBy(id = "save-pet-button")
    public WebElement petSave;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void registerPetSuccess(String pet, String owner, String specie, String age, String notes, String photo) {
        openRegister.click();
        petName.sendKeys(pet);
        petOwner.sendKeys(owner);

        Select selectspecie = new Select(petSpecies);
        selectspecie.selectByVisibleText(specie);

        petAge.sendKeys(age);
        petNotes.sendKeys(notes);
        petVaccine.click();
        petPhoto.sendKeys(photo);
        petSave.click();
    }

    
}
