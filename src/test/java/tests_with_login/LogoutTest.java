package tests_with_login;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserLoggedInPage;

public class LogoutTest extends BaseTestWithLogin{
    @Test
    public void logout(){
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver);
        userLoggedInPage.logout();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyUserIsLoggedOut("Sign in");
    }
}
