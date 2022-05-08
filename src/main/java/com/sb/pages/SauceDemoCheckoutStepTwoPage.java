package com.sb.pages;

import com.sb.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class SauceDemoCheckoutStepTwoPage extends BasePage{
    private final By buttonFinish = By.id("finish");
    private final By buttonCancel = By.id("cancel");

    public SauceDemoSuccessPage clickFinishButton() {
        click(buttonFinish, WaitStrategy.PRESENCE, "Finish Button");
        return new SauceDemoSuccessPage();
    }

    public SauceDemoCheckoutStepOnePage clickCancelButton() {
        click(buttonCancel, WaitStrategy.PRESENCE, "Cancel Button");
        return new SauceDemoCheckoutStepOnePage();
    }
}
