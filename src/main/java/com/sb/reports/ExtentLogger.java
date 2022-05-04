package com.sb.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.sb.driver.DriverManager;
import com.sb.enums.ConfigProperties;
import com.sb.utils.PropertyUtils;
import com.sb.utils.ScreenshotUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {
    private ExtentLogger(){}

    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }
    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message);
    }
    public static void skip(String message){
        ExtentManager.getExtentTest().skip(message);
    }
    public static void info(String message){
        ExtentManager.getExtentTest().info(message);
    }
    public static void pass(String message, boolean isScreenshotNeeded) throws Exception {
        if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded){
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else {
            pass(message);
        }
    }
    public static void fail(String message, boolean isScreenshotNeeded) throws Exception {
        if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded){
            ExtentManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else {
            fail(message);
        }
    }
    public static void skip(String message, boolean isScreenshotNeeded) throws Exception {
        if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotNeeded){
            ExtentManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }
        else {
            skip(message);
        }
    }

}
