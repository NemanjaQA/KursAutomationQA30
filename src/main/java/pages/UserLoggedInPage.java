package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserLoggedInPage extends BasePage{
    public UserLoggedInPage(WebDriver driver) {
        super(driver);
    }
    By signOutButtonBy = By.className("logout");
    By usernameButtonBy = By.className("account");

    public void logout(){
        click(signOutButtonBy);
    }
    public void navigateToAccount(){
        click(usernameButtonBy);
    }
    public void verifyUserIsLoggedIn(String expectedText){
        assertStringEquals(readText(signOutButtonBy), expectedText);

    }
}
