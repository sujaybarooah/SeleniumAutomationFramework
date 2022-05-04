package com.sb.pages;

import com.sb.enums.WaitStrategy;
import org.openqa.selenium.By;


public final class OrangeHRMHomePage extends BasePage{

    private final By linkWelcome = By.id("welcome");
    private final By linkLogout = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome() {
        click(linkWelcome, WaitStrategy.PRESENCE, "Welcome Link");
        return this;
    }

    public OrangeHRMLoginPage clickLogout() {
        click(linkLogout,WaitStrategy.CLICKABLE, "Logout Link");
        return new OrangeHRMLoginPage();
    }

}
