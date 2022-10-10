package tests_with_login;

import dataGenerator.DataCreation;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.UserLoggedInPage;
import utilities.PropertyManager;

public class ChangePersonalInformationTest extends BaseTestWithLogin{
    @Test
    public void changeInformation(){
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        userLoggedInPage.navigateToAccount();
        String firstName = DataCreation.firstName();
        String lastName = DataCreation.lastName();
        accountPage.changePersonalInformation(firstName, lastName, PropertyManager.getInstance().getGoodPassword());
        try{
            accountPage.verifySuccessfulInformationChange("Your personal information has been successfully updated.");
            PropertyManager.changeProperty("firstName", firstName);
            PropertyManager.changeProperty("lastName", lastName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
