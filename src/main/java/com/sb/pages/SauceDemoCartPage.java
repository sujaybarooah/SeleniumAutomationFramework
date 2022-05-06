package com.sb.pages;

import com.sb.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class SauceDemoCartPage extends BasePage{

    private final By buttonCheckout = By.id("checkout");
    private final By buttonContinueShopping = By.id("continue-shopping");
    public String errorMessageEmptyCart = "Unable to checkout!!!";
    SauceDemoHeaderPage header = new SauceDemoHeaderPage();
    public SauceDemoMenuPage expandMenu(){
        return header.clickMenu();
    }
    public SauceDemoCartPage goToCart(){
        return this;
    }

    public CheckoutStepOnePage clickCheckout(){
        click(buttonCheckout, WaitStrategy.CLICKABLE, "Checkout");
        return new CheckoutStepOnePage();
    }
    public SauceDemoProductsPage clickContinueShopping(){
        click(buttonContinueShopping, WaitStrategy.CLICKABLE, "Continue Shopping");
        return new SauceDemoProductsPage();
    }
}
