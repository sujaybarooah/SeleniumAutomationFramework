package com.sb.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sb.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {
    private ExtentReport(){}
    private static ExtentReports extentReports;
    public static void initReports() throws Exception {
        if(Objects.isNull(extentReports)){
            extentReports = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extentReports.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Selenium Tests");
        }

    }

    public static void flushReports() throws Exception {
        if (Objects.nonNull(extentReports)){
            extentReports.flush();
        }
        ExtentManager.unload();
        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
    }

    public static void createTest(String testCaseName){
        ExtentManager.setExtentTest(extentReports.createTest(testCaseName));
    }
}
