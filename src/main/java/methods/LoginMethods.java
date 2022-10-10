package methods;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginMethods extends LoginPage {
    public LoginMethods(WebDriver driver) {
        super(driver);
    }
    public void loginMethod(){
        clickOnSignInButton();
    }
}
