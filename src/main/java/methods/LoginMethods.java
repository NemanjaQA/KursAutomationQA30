package methods;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginMethods extends LoginPage {
    public LoginMethods(WebDriver driver) {
        super(driver);
    }
    public void loginMethod(String email, String password){
        clickOnSignInButton();
        writeLoginEmail(email);
        writePassword(password);
        clickOnLoginButton();
    }

    public void navigateToAccountCreation(String email){
        clickOnSignInButton();
        writeCreateEmail(email);
        clickOnCreateButton();
    }
}
