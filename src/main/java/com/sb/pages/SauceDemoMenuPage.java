package com.sb.pages;

import com.sb.enums.WaitStrategy;
import org.openqa.selenium.By;


public final class SauceDemoMenuPage extends BasePage {

    private final By linkAllItems = By.xpath("//*[@id='inventory_sidebar_link']");
    //private final By buttonCloseMenu = By.id ("react-burger-cross-btn");
    //private final By linkAbout = By.id("//*[@id='about_sidebar_link']");
    private final By linkLogout = By.xpath("//*[@id='logout_sidebar_link']");
    private final By linkResetApp = By.xpath("//*[@id='reset_sidebar_link']");

    public BasePage clickOnMenuItem(String menuText) {
        if (menuText.contains("Logout")) {
            click(linkLogout, WaitStrategy.CLICKABLE, menuText);
            return new SauceDemoLoginPage();
        } else if (menuText.contains("Reset")) {
            click(linkResetApp, WaitStrategy.CLICKABLE, menuText);
            return new SauceDemoMenuPage();
        } else if (menuText.contains("All")){
            click(linkAllItems, WaitStrategy.CLICKABLE, menuText);
            return new SauceDemoProductsPage();
        }
        else {
            return this;
        }
    }

}

