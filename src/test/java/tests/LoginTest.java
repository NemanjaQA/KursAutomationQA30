package tests;

import dataGenerator.DataCreation;
import methods.LoginMethods;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserLoggedInPage;
import utilities.PropertyManager;

public class LoginTest extends BaseTest{

    @Parameters("QA30")
    @Test
    public void login(String parameter) {
        LoginMethods loginPage = new LoginMethods(driver);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver);
        System.out.println(parameter);
        loginPage.loginMethod(PropertyManager.getInstance().getGoodEmail(), PropertyManager.getInstance().getGoodPassword());
        userLoggedInPage.verifyUserIsLoggedIn("Sign out");
    }
}
