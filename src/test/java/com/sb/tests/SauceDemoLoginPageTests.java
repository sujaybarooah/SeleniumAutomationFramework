package com.sb.tests;


import com.sb.pages.*;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public final class SauceDemoLoginPageTests extends BaseTest {
    private SauceDemoLoginPageTests() {
    }

    @Test
    public void invalidCredentialsTest(Map<String, String> data) {
        SauceDemoLoginPage loginPage = (SauceDemoLoginPage) new SauceDemoLoginPage().enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
        Assertions.assertThat(loginPage.isValidationErrorPresent()).isTrue();
    }

    @Test
    public void addItemsToCartTest(Map<String, String> data) {
        SauceDemoProductsPage productsPage = (SauceDemoProductsPage) new SauceDemoLoginPage().enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
        Assertions.assertThat(productsPage.getPageName("Products")).isTrue();
        SauceDemoCartPage cartPage = productsPage.addItemToCart(data.get("items")).goToCart();
        Assertions.assertThat(cartPage.getPageName("Your Cart")).isTrue();
    }

    @Test
    public void invalidDeliveryAddress(Map<String, String> data) {
        new SauceDemoLoginPage().enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
        new SauceDemoCartPage().clickCheckout();
        SauceDemoCartPage myCartPage = new SauceDemoCartPage();
        Assert.assertTrue(myCartPage.errorMessageEmptyCart.contains("Unable to checkout!!!"));
    }
}
