package com.sb.constants;

import com.sb.enums.ConfigProperties;
import com.sb.utils.PropertyUtils;

public final class FrameworkConstants {

    private FrameworkConstants(){}

    private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
    private static final String CHROMEDRIVERPATH = RESOURCESPATH+"/executables/chromedriver.exe";
    private static final String GECKODRIVERPATH = RESOURCESPATH+"/executables/geckodriver.exe";
    private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output";
    private static String extentReportFilePath = "";
    private static final String EXCELTESTDATAPATH = RESOURCESPATH+"/excel/testdata.xlsx";
    private static final String RUNMANAGERSHEET = "RUNMANAGER";
    private static final String ITERATIONDATASHEET = "DATA";
    private static final int EXPLICITWAIT = 10;
    private static final int RETRYFAILEDTESTS = 1;
    private static final int SLOWDOWNTESTEXECUTION = 1000;


    public static String getExtentReportFilePath() throws Exception {
        if (extentReportFilePath.isEmpty()){
            extentReportFilePath = createReportPath();
        }
            return extentReportFilePath;
    }
    private static String createReportPath() throws Exception {
        if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
            return EXTENTREPORTFOLDERPATH +"/"+System.currentTimeMillis()+"/index.html";
        }
        else {
            return EXTENTREPORTFOLDERPATH +"/index.html";
        }
    }
    public static String getChromeDriverPath(){
        return CHROMEDRIVERPATH;
    }
    public static String getGeckoDriverPath(){
        return GECKODRIVERPATH;
    }
    public static String getConfigFilePath(){
        return CONFIGFILEPATH;
    }
    public static int getExplicitWait(){
        return EXPLICITWAIT;
    }
    public static String getExcelTestdataPath(){return EXCELTESTDATAPATH;}
    public static String getRunManagerSheet(){
        return RUNMANAGERSHEET;
    }
    public static String getIterationDataSheet(){
        return ITERATIONDATASHEET;
    }
    public static int getRetryFailedTests() {
        return RETRYFAILEDTESTS;
    }
    public static int getSlowdownTestExecution() {
        return SLOWDOWNTESTEXECUTION;
    }

}

