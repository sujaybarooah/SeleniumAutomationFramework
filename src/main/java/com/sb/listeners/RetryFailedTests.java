package com.sb.listeners;

import com.sb.constants.FrameworkConstants;
import com.sb.enums.ConfigProperties;
import com.sb.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;

    @Override
    public boolean retry(ITestResult result) {
        try {
            if (PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes") &&
                    (count < FrameworkConstants.getRetryFailedTests())) {
                count++;
                return true;
            }
            /*
            boolean value = false;
            if (PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
                boolean value = count < retries;
                count++;
            }
            return value;
             */

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
