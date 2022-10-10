package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{
    public AccountPage(WebDriver driver) {
        super(driver);
    }
    By personalInformationButtonBy = By.xpath("//a[@title='Information']");
    By firstNameInputFieldBy = By.id("firstname");
    By lastNameInputFieldBy = By.id("lastname");
    By confirmPasswordInputFieldBy = By.id("old_passwd");
    By saveButtonBy = By.xpath("//button[@name='submitIdentity']");
    By successMessageBy = By.xpath("//p[contains(text(),'Your personal information has been successfully updated.')]");
    //*[@id="center_column"]/div/p

    public void changePersonalInformation(String fname, String lname, String password){
        click(personalInformationButtonBy);
        writeText(firstNameInputFieldBy, fname);
        writeText(lastNameInputFieldBy, lname);
        writeText(confirmPasswordInputFieldBy, password);
        click(saveButtonBy);
    }
    public void checkUsername(String fname, String lname){
        //System.out.println(readAttribute(firstNameInputFieldBy, "value"));
        assertStringEquals(readAttribute(firstNameInputFieldBy, "value"), fname);
        assertStringEquals(readAttribute(lastNameInputFieldBy, "value"), lname);
    }
    public void navigateToPersonalInformation(){
        click(personalInformationButtonBy);
    }
    public void verifySuccessfulInformationChange(String expectedText){
        assertStringEquals(readText(successMessageBy), expectedText);
    }
}
