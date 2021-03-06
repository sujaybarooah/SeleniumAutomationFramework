package com.sb.pages;

import com.sb.driver.DriverManager;
import com.sb.enums.WaitStrategy;
import com.sb.factories.ExplicitWaitFactory;
import com.sb.reports.ExtentLogger;
import com.sb.utils.DynamicXpathUtils;
import org.openqa.selenium.*;

public class BasePage {

    public static final String PAGELABEL = "//span[text()='%s']";

    protected void click(By by, WaitStrategy waitStrategy, String elementName){
        WebElement element =ExplicitWaitFactory.performExplicitWait(waitStrategy,by);
        highlightElement(element);
        element.click();
        try {
            ExtentLogger.pass(elementName+ " was Clicked",true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName){
        WebElement element =ExplicitWaitFactory.performExplicitWait(waitStrategy,by);
        highlightElement(element);
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
    public Boolean getPageName(String pageName){
        String labelXpath = DynamicXpathUtils.getXpath(PAGELABEL,pageName);
        return ifElementExist(By.xpath(labelXpath), WaitStrategy.PRESENCE,pageName);
    }

    public static void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "background: yellow; border: 2px solid yellow;");
    }
}
