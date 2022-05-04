package com.sb.pages;

import com.sb.driver.DriverManager;
import com.sb.enums.WaitStrategy;
import com.sb.utils.DynamicXpathUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class AmazonHamburgerMenuPage extends BasePage{

    @FindBy(xpath = "//div[text()='Mobiles, Computers']/parent::a")
    private WebElement linkMobileAndComputers;

    private String linkSubMenu = "//a[text()='%s']";
    public AmazonHamburgerMenuPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public AmazonHamburgerMenuPage clickMobilesAndComputers(){
        linkMobileAndComputers.click();
        return this;
    }
    public AmazonLaptopPage clickOnSubMenuItem (String menuText){
        String newXpath= DynamicXpathUtils.getXpath(linkSubMenu,menuText);
        click(By.xpath(newXpath), WaitStrategy.CLICKABLE,menuText);
        if(menuText.contains("Laptop")){
            return new AmazonLaptopPage();
        }
        return null;
    }
}
