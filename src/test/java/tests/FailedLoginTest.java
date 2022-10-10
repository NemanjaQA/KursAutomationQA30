package tests;

import dataGenerator.DataCreation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.PropertyManager;

public class FailedLoginTest extends BaseTest{


    @Test(dataProvider = "failedLogin")
    public void failedLogin(String email, String password, String error) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(email, password);
        try {
            loginPage.verifyFailedLogin(error);
            System.out.println("Test passed: user is not logged in");
        } catch (Exception e) {
            Assert.fail("Something went wrong");
        }
    }
    @DataProvider(name = "failedLogin")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]
                {
                        {"", "","There is 1 error\nAn email address required."},
                        {DataCreation.email(),PropertyManager.getInstance().getBadPassword(),"There is 1 error\nAuthentication failed."},
                        {PropertyManager.getInstance().getGoodEmail(),"","There is 1 error\nPassword is required."}
                };
    }



}
