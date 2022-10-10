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

    public void registration(String email, String password) {
        click(signInButtonBy);
        writeText(emailFieldBy,email);
        click(createButtonBy);
        writeText(firstNameBy, DataCreation.firstName());
        writeText(lastNameBy,DataCreation.lastName());
        writeText(passwordBy,password);
        writeText(addressBy,DataCreation.address());
        writeText(cityBy,DataCreation.cityName());
        selectRandomFromDropDown(stateBy, 1);
        writeText(postalCodeBy,DataCreation.postalCode());
        writeText(mobilePhoneBy,DataCreation.mobilePhone());
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
    public void writeFirstName(String fname){
        writeText(firstNameBy, fname);
    }
}
