package epam.cdp.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestNgStepListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        log.info("<{}> suite is running...", suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        log.info("<{}> suite was finished", suite.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("<{}> test was started...", iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("<{}> test was finished with success", iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("<{}> test was finished with failure", iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("<{}> test was skiped", iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log.info("Log something for {}...", iTestResult.getName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info("<{}> test scope was started", iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log.info("<{}> test scope was finished", iTestContext.getName());
    }

}
