package com.sb.pages;

import com.sb.enums.WaitStrategy;
import com.sb.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

public final class SauceDemoProductsPage extends BasePage{

    // dynamic strings for page elements
/*  private String linkInventoryItemDescription = "//*[@id='%s']/div/parent::a";
    private String labelInventoryItemPrice = "//div[@class='inventory_item_price']";*/
    private final String buttonAddToCart = "//*[@id='add-to-cart-%s']";
    SauceDemoHeaderPage header = new SauceDemoHeaderPage();
    public SauceDemoProductsPage addItemToCart(String itemName){
        String[] items = itemName.split(";");
        for (String item: items) {
            String itemNameFormatted = item.toLowerCase().replace(" ","-").trim();
            String xpathOfButton = DynamicXpathUtils.getXpath(buttonAddToCart,itemNameFormatted);
            click(By.xpath(xpathOfButton), WaitStrategy.CLICKABLE, itemNameFormatted);
        }
        return this;
    }

    public void goToCart(){
        header.clickCart();
    }
    public SauceDemoMenuPage expandMenu(){
        return header.clickMenu();
    }
}
