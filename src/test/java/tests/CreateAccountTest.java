package tests;

import dataGenerator.DataCreation;
import dataGenerator.RegistrationData;
import methods.AccountMethod;
import methods.VerifierMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.UserLoggedInPage;
import utilities.PropertyManager;

public class CreateAccountTest extends BaseTest {

    @Test
    public void createAccontTest() throws Exception {

        String email = DataCreation.email();
        String password = DataCreation.password();
        AccountMethod createAccountPage = new AccountMethod(driver);
        VerifierMethods userLoggedInPage = new VerifierMethods(driver);
        createAccountPage.registration(email, password);
        try {
            userLoggedInPage.verifyUserIsLoggedIn("Sign out");
            PropertyManager.changeProperty("goodEmail", email);
            PropertyManager.changeProperty("goodPassword", password);
        } catch (AssertionError assertFail) {
            System.out.println("User not created, something went wrong");
            Assert.fail(assertFail.toString());
        } catch (Exception e){
            System.out.println("Something went wrong!");
           // Assert.fail();
            e.printStackTrace();
            throw new Exception();
        }
    }


    @Test
    public void createAccont() {

        RegistrationData registrationData = RegistrationData.generateRandomUser();
        //registrationData.setEmail("");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        UserLoggedInPage userLoggedInPage = new UserLoggedInPage(driver);
        createAccountPage.registerUser(registrationData);
        //If registration is valid:
        try {
            userLoggedInPage.verifyUserIsLoggedIn("Sign out");
            PropertyManager.changeProperty("goodEmail", registrationData.getEmail());
            PropertyManager.changeProperty("goodPassword", registrationData.getPassword());
        } catch (AssertionError assertFail) {
            System.out.println("User not created, something went wrong");
            Assert.fail(assertFail.toString());
        }
    }
}
