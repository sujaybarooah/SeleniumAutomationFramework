package com.sb.listeners;

import com.sb.reports.ExtentLogger;
import com.sb.reports.ExtentReport;
import org.testng.*;

import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            ExtentLogger.pass(result.getMethod().getMethodName()+" has passed!", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentLogger.fail(result.getMethod().getMethodName()+" has failed!",true);
            ExtentLogger.info(result.getThrowable().toString());
            ExtentLogger.info(Arrays.toString(result.getThrowable().getStackTrace()));
        } catch (Exception e) {
           e.printStackTrace();
        }
        //attach screenshot
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            ExtentLogger.skip(result.getMethod().getMethodName()+" was skipped",true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        /*
        *Not using this for now
        *
         */
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        /*
         *Not using this for now
         *
         */
    }

    @Override
    public void onStart(ITestContext context) {
        /*
         *Just have one Test tag in our test suite. So don't have any special implementation for now
         *
         */
    }

    @Override
    public void onFinish(ITestContext context) {
        /*
        *Just have one Test tag in our test suite. So don't have any special implementation for now
        *
        */
        }
}
