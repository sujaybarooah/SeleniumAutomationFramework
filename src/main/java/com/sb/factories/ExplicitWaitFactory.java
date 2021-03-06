package com.sb.factories;

import com.sb.constants.FrameworkConstants;
import com.sb.driver.DriverManager;
import com.sb.enums.ConfigProperties;
import com.sb.enums.WaitStrategy;
import com.sb.utils.PropertyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ExplicitWaitFactory {
    private ExplicitWaitFactory(){}

    public static WebElement performExplicitWait(WaitStrategy wait, By by) {
        WebElement element = null;
        if (wait == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.elementToBeClickable(by)); //old way
        } else if (wait == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (wait == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (wait == WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(by);
        }
        try {
            slowExecution();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    private static void slowExecution() throws Exception {
        if (PropertyUtils.get(ConfigProperties.SLOWEXECUTION).equals("yes")) {
            Thread.sleep(FrameworkConstants.getSlowdownTestExecution());
        }
    }
}
