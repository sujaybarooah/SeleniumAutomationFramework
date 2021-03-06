package com.sb.pages;

import com.sb.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class SauceDemoCheckoutStepOnePage extends BasePage {
    private final By textboxDeliveryAddFirstName = By.id("first-name");
    private final By textboxDeliveryAddLastName = By.id("last-name");
    private final By textboxDeliveryAddZipCode = By.id("postal-code");
    private final By buttonContinue = By.id("continue");
    private final By buttonCancel = By.id("cancel");

    private final By checkoutError = By.xpath("//button[@class='error-button']");

    public SauceDemoCheckoutStepOnePage enterDeliveryAddressFirstName(String deliveryAddFirstName) {
        sendKeys(textboxDeliveryAddFirstName, deliveryAddFirstName, WaitStrategy.PRESENCE, "Delivery Address First Name");
        return this;
    }

    public SauceDemoCheckoutStepOnePage enterDeliveryAddressLastName(String deliveryAddLastName) {
        sendKeys(textboxDeliveryAddLastName, deliveryAddLastName, WaitStrategy.PRESENCE, "Delivery Address Last Name");
        return this;
    }

    public SauceDemoCheckoutStepOnePage enterDeliveryAddressZipCode(String deliveryAddZipCode) {
        sendKeys(textboxDeliveryAddZipCode, deliveryAddZipCode, WaitStrategy.PRESENCE, "Delivery Address Zip Code");
        return this;
    }

    public void clickContinueButton() {
        click(buttonContinue, WaitStrategy.PRESENCE, "Continue Button");
        //return new CheckoutStepTwoPage();
    }

    public String getTitle() {
        return getPageTitle();
    }

    public SauceDemoCartPage clickCancelButton() {
        click(buttonCancel, WaitStrategy.PRESENCE, "Cancel Button");
        return new SauceDemoCartPage();
    }

    public Boolean isCheckoutErrorPresent(){
        return ifElementExist(checkoutError,WaitStrategy.VISIBLE,"mandatory first name");
    }

}
