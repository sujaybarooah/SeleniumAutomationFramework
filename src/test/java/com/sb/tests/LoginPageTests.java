package com.sb.tests;

import com.sb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class LoginPageTests extends BaseTest{
    private LoginPageTests(){}

    @Test
    public void test(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
    }
}
