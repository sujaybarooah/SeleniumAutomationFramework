package com.sb.pages;

import com.sb.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class SauceDemoHeaderPage extends BasePage{

    private final By buttonHamburger = By.id("react-burger-menu-btn");
    private final By linkShoppingCartLink = By.xpath("//*[@id='shopping_cart_container']/a");

    public String getTitle() {
        return getPageTitle();
    }

    public SauceDemoMenuPage clickMenu(){
        click(buttonHamburger, WaitStrategy.PRESENCE, "Hamburger Menu");
        return new SauceDemoMenuPage();
    }

    public SauceDemoCartPage clickCart(){
        click(linkShoppingCartLink, WaitStrategy.PRESENCE, "Shopping Cart Icon");
        return new SauceDemoCartPage();
    }
}
