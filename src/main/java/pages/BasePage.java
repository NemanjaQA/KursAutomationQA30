package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void click(By elementBy) {
        waitVisibility(elementBy);
        //WebElement element = driver.findElement(elementBy);
        //element.click();
        driver.findElement(elementBy).click();
    }

    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        /*WebElement element = driver.findElement(elementBy);
        element.clear();
        element.sendKeys();*/
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public String readText(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public String readAttribute(By elementBy, String attribute) {
        return driver.findElement(elementBy).getAttribute(attribute);
    }

    public void assertStringEquals(String actualString, String expectedString) {
        Assert.assertEquals(actualString, expectedString);
    }

    public void selectRandomFromDropDown(By elementBy, int x) {

        WebElement dropDownElement = driver.findElement(elementBy);
        Select objSelect = new Select(dropDownElement);
        List<WebElement> weblist = objSelect.getOptions();
        int size = weblist.size();
        Random num = new Random();
        int iSelect = num.nextInt(x ,size-1);
        objSelect.selectByIndex(iSelect);

    }

    public void selectDropDownByTextValue(By elementBy, String textValue) {

        WebElement dropDownElement = driver.findElement(elementBy);
        Select objSelect = new Select(dropDownElement);
        objSelect.selectByVisibleText(textValue);

    }
}
