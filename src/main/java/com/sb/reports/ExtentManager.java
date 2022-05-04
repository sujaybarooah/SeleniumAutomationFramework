package com.sb.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
    private ExtentManager(){}
    private static ThreadLocal <ExtentTest> extentTest = new ThreadLocal<>();

    static ExtentTest getExtentTest(){ //default access--> it is accessible only in the package
        return extentTest.get();
    }

    static void setExtentTest(ExtentTest extentTestRef){
        extentTest.set(extentTestRef);
    }

    static void unload(){
        extentTest.remove();
    }

}
