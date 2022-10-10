package methods;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LoginPage;
import pages.UserLoggedInPage;

public class VerifierMethods extends BasePage {

    public VerifierMethods(WebDriver driver) {
        super(driver);
    }
    LoginPage loginPage = new LoginPage(driver);
    UserLoggedInPage loggedIn = new UserLoggedInPage(driver);

    public void verifyFailedLogin(String expectedText){
        assertStringEquals(loginPage.readingErrorMessage(), expectedText);
    }
    public void verifyUserIsLoggedIn (String expectedText){
        loggedIn.verifyUserIsLoggedIn(expectedText);
    }


}
