package com.sb.pages;

import com.sb.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class SauceDemoSuccessPage extends BasePage{
    private final By buttonBackHome = By.id("back-to-products");
    public SauceDemoProductsPage clickBackHomeButton() {
        click(buttonBackHome, WaitStrategy.CLICKABLE, "Back Home Button");
        return new SauceDemoProductsPage();
    }
}
