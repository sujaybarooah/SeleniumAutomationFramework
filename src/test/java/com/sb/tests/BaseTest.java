package com.sb.tests;

import com.sb.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;


public class BaseTest {

    protected BaseTest(){}

    @SuppressWarnings("unchecked")
    @BeforeMethod
    protected void setUp(Object[] data) throws Exception { //MAP<String,String>
        Map<String,String>map =(Map<String,String>)data[0];
        Driver.initDriver(map.get("browser"));
    }

    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
    }
}
