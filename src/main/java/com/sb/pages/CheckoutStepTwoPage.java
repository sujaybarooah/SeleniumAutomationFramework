package com.sb.pages;

import com.sb.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class CheckoutStepTwoPage extends BasePage{
    private final By buttonFinish = By.id("finish");
    private final By buttonCancel = By.id("cancel");

    public SuccessPage clickFinishButton() {
        click(buttonFinish, WaitStrategy.PRESENCE, "Finish Button");
        return new SuccessPage();
    }

    public CheckoutStepOnePage clickCancelButton() {
        click(buttonCancel, WaitStrategy.PRESENCE, "Cancel Button");
        return new CheckoutStepOnePage();
    }
}
