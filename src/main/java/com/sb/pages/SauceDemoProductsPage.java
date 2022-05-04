package com.sb.pages;

import com.sb.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class SauceDemoProductsPage extends BasePage{

    private final By labelProduct = By.xpath("//span[text()='Products']");

    public String getTitle() {
        return getPageTitle();
    }

    public Boolean productLabelExists(){
        return ifElementExist(labelProduct, WaitStrategy.PRESENCE,"Product Label");
    }
}
