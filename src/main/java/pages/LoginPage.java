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


    public void verifyUserIsLoggedOut(String expectedText){
        assertStringEquals(readText(signInButtonBy), expectedText);
    }
    public void clickOnSignInButton(){
        click(signInButtonBy);
    }
    public void writeLoginEmail(String email){
        writeText(emailFieldBy, email);
    }

    public void writePassword(String password) {
        writeText(passwordFieldBy,password);
    }
    public void clickOnLoginButton(){
        click(loginButtonBy);
    }
    public void writeCreateEmail(String email){
        writeText(createEmailFieldBy,email);
    }
    public void clickOnCreateButton (){
        click(createButtonBy);
    }
    public void verifyFailedLoginText(String expectedText){
        assertStringEquals(readText(errorNotificationBy),expectedText);
    }
}
