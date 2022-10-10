package methods;

import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.CreateAccountPage;

public class AccountClass extends CreateAccountPage {
    public AccountClass(WebDriver driver) {
        super(driver);
    }
    public void registration(String email, String password) {
        clickOnSignInButton();
        writeEmailField(email);
        clickOnCreateButton();
        writeFirstName();
        writeLastName();
        writePassword(password);
        writeAddress();
        writeCity();
        selectState();
        writePostalCode();
        writeMobilePhone();
        clickOnRegisterButton();
    }

}
