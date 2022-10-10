package tests_with_login;

import org.testng.annotations.Test;
import pages.AccountPage;
import pages.UserLoggedInPage;
import utilities.PropertyManager;

public class CheckUsernameTest extends BaseTestWithLogin{
    @Test
    public void checkUsername(){
        AccountPage accountPage = new AccountPage(driver);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver);
        userLoggedInPage.navigateToAccount();
        accountPage.navigateToPersonalInformation();
        accountPage.checkUsername(PropertyManager.getInstance().getFirstName(), PropertyManager.getInstance().getLastName());
    }
}
