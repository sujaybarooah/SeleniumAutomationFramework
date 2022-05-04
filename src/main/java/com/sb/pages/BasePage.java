package com.sb.pages;

import com.sb.driver.DriverManager;
import com.sb.enums.WaitStrategy;
import com.sb.factories.ExplicitWaitFactory;
import com.sb.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        element.clear();
        element.sendKeys(value);
        try {
            ExtentLogger.pass(value +" is entered successfully in the " +elementName+" field",true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected Boolean ifElementExist(By by, WaitStrategy waitStrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        Boolean isElementDisplayed = element.isDisplayed();
        if (Boolean.TRUE.equals(isElementDisplayed)) {
            try {
                ExtentLogger.pass(elementName + " is Displayed", true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                ExtentLogger.pass(elementName + " is Not Displayed", true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isElementDisplayed;
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
