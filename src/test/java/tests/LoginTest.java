package tests;

import dataGenerator.DataCreation;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserLoggedInPage;
import utilities.PropertyManager;

public class LoginTest extends BaseTest{

    @Parameters("QA30")
    @Test
    public void login(String parameter) {
        LoginPage loginPage = new LoginPage(driver);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver);
        System.out.println(parameter);
        loginPage.login(PropertyManager.getInstance().getGoodEmail(), PropertyManager.getInstance().getGoodPassword());
        userLoggedInPage.verifyUserIsLoggedIn("Sign out");
    }
}
