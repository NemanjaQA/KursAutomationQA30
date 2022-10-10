package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.PropertyManager;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", PropertyManager.getInstance().getDriverPath());

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications", "--start-maximized"));
        //driver.manage().window().maximize();
        driver.get("http://stagingautomationpractice.com/index.php");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
