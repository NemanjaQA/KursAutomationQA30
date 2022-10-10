package tests_with_login;

import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import tests.BaseTest;
import utilities.PropertyManager;

public class BaseTestWithLogin extends BaseTest {

    @Override
    @BeforeMethod
    public void setup() {
        super.setup();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(PropertyManager.getInstance().getGoodEmail(), PropertyManager.getInstance().getGoodPassword());
    }
}
