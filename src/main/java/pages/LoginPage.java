package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By signInButtonBy = By.className("login");
    By emailFieldBy = By.id("email");
    By passwordFieldBy = By.id("passwd");
    By loginButtonBy = By.id("SubmitLogin");
    By errorNotificationBy = By.xpath("//*[@id=\"center_column\"]/div[1]");
    By createEmailFieldBy = By.id("email_create");
    By createButtonBy = By.xpath("//*[@id=\"SubmitCreate\"]/span");
    public void login(String email, String password){
        clickOnSignInButton();
        writeLoginEmail(email);
        writeLoginPassword(password);
        click(loginButtonBy);
    }
    public void navigateToAccountCreation(String email){
        click(signInButtonBy);
        writeText(createEmailFieldBy,email);
        click(createButtonBy);
    }
    public void verifyFailedLogin(String expectedText){
        String error = readText(errorNotificationBy);
        assertStringEquals(error, expectedText);
    }
    public void verifyUserIsLoggedOut(String expectedText){
        assertStringEquals(readText(signInButtonBy), expectedText);
    }
    public void clickOnSignInButton(){
        click(signInButtonBy);
    }
    public void writeLoginEmail(String email){
        writeText(emailFieldBy, email);
    }
    public void writeLoginPassword(String password){
        writeText(passwordFieldBy, password);
    }
}
