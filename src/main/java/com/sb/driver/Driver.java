package com.sb.driver;

import com.sb.constants.FrameworkConstants;
import com.sb.enums.ConfigProperties;
import com.sb.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public final class Driver {
    private Driver(){}

    public static void initDriver(String browser) throws Exception {
        if (Objects.isNull(DriverManager.getDriver())){
            if(browser.equalsIgnoreCase("chrome")){
                //System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());
                DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
            }
            else if(browser.equalsIgnoreCase("firefox")){
                //System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckoDriverPath());
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
                DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
            }
        }
    }

    public static void quitDriver(){
        if (Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
