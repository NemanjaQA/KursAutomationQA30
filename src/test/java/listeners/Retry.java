package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int count = 0;
    private int maxTry = 2;
    @Override
    public boolean retry(ITestResult testResult){
        if(!testResult.isSuccess()){
            if(count < maxTry){
                count++;
                testResult.setStatus(ITestResult.FAILURE);
                return true;
            } else{
                testResult.setStatus(ITestResult.FAILURE);
            }
        }else{
            testResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
