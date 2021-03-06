import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener implements ITestListener {
    Logger log = extentController.log;
    ExtentTest test = extentController.test;
    @Override
    public void onTestStart(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " start");
        test.log(Status.INFO, result.getMethod().getMethodName() + " start");
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(result.getMethod().getMethodName() + " success");
        test.log(Status.PASS, result.getMethod().getMethodName() + " success");
        try {
            screenshot_handler.getScreenShotPass();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getMethod().getMethodName() + " test Fail");
        try {
            screenshot_handler.getScreenShotFail();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        extentController.extent.flush();
        extentController.log.traceExit();
        ITestListener.super.onFinish(context);
    }
}
