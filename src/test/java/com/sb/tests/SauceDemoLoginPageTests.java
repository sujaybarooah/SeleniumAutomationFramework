package com.sb.tests;


import com.sb.pages.SauceDemoCartPage;
import com.sb.pages.SauceDemoLoginPage;
import com.sb.pages.SauceDemoProductsPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class SauceDemoLoginPageTests extends BaseTest {
    private SauceDemoLoginPageTests() {
    }

    @Test
    public void loginLogoutTest(Map<String, String> data) {
        SauceDemoProductsPage productsPage = new SauceDemoLoginPage().enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
        Assertions.assertThat(productsPage.getPageName("Products")).isTrue();
    }

    @Test
    public void addItemsToCartTest(Map<String, String> data){
        SauceDemoProductsPage productsPage = new SauceDemoLoginPage().enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
        Assertions.assertThat(productsPage.getPageName("Products")).isTrue();
        SauceDemoCartPage cartPage = productsPage.addItemToCart("Sauce Labs Bike Light").addItemToCart("Sauce Labs Fleece Jacket").goToCart();
        Assertions.assertThat(cartPage.getPageName("Your Cart")).isTrue();
    }
}
