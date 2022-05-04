package com.sb.pages;

import com.sb.enums.WaitStrategy;
import org.openqa.selenium.By;


public final class SauceDemoLoginPage extends BasePage{
    private final By textboxUsername = By.id("user-name");
    private final By textboxPassword = By.id("password");
    private final By buttonLogin = By.id("login-button");

    public SauceDemoLoginPage enterUserName(String username) {
        sendKeys(textboxUsername,username, WaitStrategy.PRESENCE, "Username");
        return this;
    }

    public SauceDemoLoginPage enterPassword(String password) {
        sendKeys(textboxPassword,password,WaitStrategy.PRESENCE, "Password");
        return this;
    }

    public SauceDemoProductsPage clickLogin() {
        click(buttonLogin, WaitStrategy.PRESENCE, "Login Button");
        return new SauceDemoProductsPage();
    }
    public String getTitle() {
        return getPageTitle();
    }

}
