package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.io.File;
import java.util.Date;

public class Screenshot implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {

        try {
            Object currentClass = result.getInstance();
            WebDriver driver = ((BaseTest) currentClass).getDriver();
            takeSnapShot(driver,result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void takeSnapShot(WebDriver webdriver, ITestResult result) {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        Date d = new Date();
        String screenshotName = result.getName() + "_" + d.toString().replace(":", "_").replace(" ", "_");

        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, new File("./Screenshots/" + screenshotName + ".png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
