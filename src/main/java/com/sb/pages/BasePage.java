package com.sb.pages;

import com.sb.driver.DriverManager;
import com.sb.enums.WaitStrategy;
import com.sb.factories.ExplicitWaitFactory;
import com.sb.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy, String elementName){
        WebElement element =ExplicitWaitFactory.performExplicitWait(waitStrategy,by);
        element.click();
        try {
            ExtentLogger.pass(elementName+ " was Clicked",true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName){
        WebElement element =ExplicitWaitFactory.performExplicitWait(waitStrategy,by);
        element.sendKeys(value);
        try {
            ExtentLogger.pass(value +" is entered successfully in the " +elementName+" field",true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
