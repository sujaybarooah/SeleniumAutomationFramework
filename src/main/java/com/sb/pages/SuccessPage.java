package com.sb.pages;

import com.sb.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.testng.Assert;

public final class SuccessPage extends BasePage{
    private final By buttonBackHome = By.id("back-to-products");
    private final By textCompleteMessage = By.className("complete-text");

/*    public SuccessPage validateSuccessfulMessage(String completeMessage){
//        Assert.assertTrue(textCompleteMessage.contains(completeMessage)); //TODO: why getText of this element doesn't work
        return this;
    }*/

    public SauceDemoProductsPage clickBackHomeButton() {
        click(buttonBackHome, WaitStrategy.PRESENCE, "Back Home Button");
        return new SauceDemoProductsPage();
    }
}
