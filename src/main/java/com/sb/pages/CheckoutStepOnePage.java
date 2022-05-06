package com.sb.pages;

import com.sb.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class CheckoutStepOnePage extends BasePage{
    private final By textboxDeliveryAddFirstName = By.id("first-name");
    private final By textboxDeliveryAddLastName = By.id("last-name");
    private final By textboxDeliveryAddZipCode = By.id("postal-code");
    private final By buttonContinue = By.id("continue");
    private final By buttonCancel = By.id("cancel");

    public CheckoutStepOnePage enterDeliveryAddressFirstName(String deliveryAddFirstName) {
        sendKeys(textboxDeliveryAddFirstName, deliveryAddFirstName, WaitStrategy.PRESENCE, "Delivery Address First Name");
        return this;
    }

    public CheckoutStepOnePage enterDeliveryAddressLastName(String deliveryAddLastName) {
        sendKeys(textboxDeliveryAddLastName, deliveryAddLastName, WaitStrategy.PRESENCE, "Delivery Address Last Name");
        return  this;
    }

    public CheckoutStepOnePage enterDeliveryAddressZipCode(String deliveryAddZipCode) {
        sendKeys(textboxDeliveryAddZipCode, deliveryAddZipCode, WaitStrategy.PRESENCE, "Delivery Address Zip Code");
        return this;
    }

    public CheckoutStepTwoPage clickContinueButton() {
        click(buttonContinue, WaitStrategy.PRESENCE, "Continue Button");
        return new CheckoutStepTwoPage();
    }

//    public CheckoutStepOnePage clickCancelButton() {
//        click(buttonCancel, WaitStrategy.PRESENCE, "Cancel Button");
//        //TODO: need to return to Cart page
//    }
}
