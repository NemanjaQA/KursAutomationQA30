package tests_with_login;

import methods.LoginMethods;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import tests.BaseTest;
import utilities.PropertyManager;

public class BaseTestWithLogin extends BaseTest {

    @Override
    @BeforeMethod
    public void setup() {
        super.setup();

        LoginMethods loginPage = new LoginMethods(driver);
        loginPage.loginMethod(PropertyManager.getInstance().getGoodEmail(), PropertyManager.getInstance().getGoodPassword());
    }
}
