package pages;

import dataGenerator.DataCreation;
import dataGenerator.RegistrationData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver){
        super(driver);
    }

    By signInButtonBy = By.className("login");

    By emailFieldBy = By.id("email_create");

    By createButtonBy = By.xpath("//*[@id=\"SubmitCreate\"]/span");

    By firstNameBy = By.id("customer_firstname");

    By lastNameBy = By.id("customer_lastname");

    By passwordBy = By.id("passwd");

    By addressBy = By.id("address1");

    By cityBy = By.id("city");

    By stateBy = By.id("id_state");

    By postalCodeBy = By.id("postcode");

    By mobilePhoneBy = By.id("phone_mobile");

    By registerButtonBy = By.xpath("//*[@id=\"submitAccount\"]/span");


    public void clickOnSignInButton (){
        click(signInButtonBy);
    }
    public void writeEmailField (String email){
        writeText(emailFieldBy,email);
    }
    public void clickOnCreateButton () {
        click(createButtonBy);
    }
    public void writeFirstName(){
        writeText(firstNameBy,DataCreation.firstName());
    }
    public void writeLastName(){
        writeText(lastNameBy,DataCreation.lastName());
    }
    public void writePassword(String password){
        writeText(passwordBy,password);
    }
    public void writeAddress(){
        writeText(addressBy,DataCreation.address());
    }
    public void writeCity(){
        writeText(cityBy,DataCreation.cityName());
    }
    public void selectState(){
        selectRandomFromDropDown(stateBy, 1);
    }
    public void writePostalCode (){
        writeText(postalCodeBy,DataCreation.postalCode());
    }
    public void writeMobilePhone(){
        writeText(mobilePhoneBy,DataCreation.mobilePhone());
    }
    public void clickOnRegisterButton (){
        click(registerButtonBy);
    }

    public void registerUser(RegistrationData registrationData) {
        click(signInButtonBy);
        writeText(emailFieldBy, registrationData.getEmail());
        click(createButtonBy);
        writeText(firstNameBy, registrationData.getFirstName());
        writeText(lastNameBy,registrationData.getLastName());
        writeText(passwordBy,registrationData.getPassword());
        writeText(addressBy,registrationData.getAdress());
        writeText(cityBy,registrationData.getCityName());
        selectDropDownByTextValue(stateBy, registrationData.getState());
        writeText(postalCodeBy,registrationData.getPostalCode());
        writeText(mobilePhoneBy,registrationData.getMobilePhone());
        click(registerButtonBy);
    }
}
