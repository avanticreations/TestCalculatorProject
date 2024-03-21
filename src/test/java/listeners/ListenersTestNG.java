package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTestNG implements ITestListener
{
    public void onStart(ITestContext context) {
        System.out.println("onStart method started");
    }
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess Method" +result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure Method" +result.getName());
    }
}
