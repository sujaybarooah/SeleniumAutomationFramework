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
        SauceDemoLoginPage loginPage = new SauceDemoLoginPage();
        loginPage.enterUserName(data.get("username"))
                .enterPassword(data.get("password"))
                .clickLogin();
        Assertions.assertThat(loginPage.isValidationErrorPresent()).isTrue();
    }
    @Test
    public void addItemsToCartTest(Map<String, String> data) {
        SauceDemoLoginPage loginPage = new SauceDemoLoginPage();
        loginPage.enterUserName(data.get("username"))
                .enterPassword(data.get("password"))
                .clickLogin();
        SauceDemoProductsPage productsPage = new SauceDemoProductsPage();
        Assertions.assertThat(productsPage.getPageName("Products")).isTrue();
        productsPage.addItemToCart(data.get("items"))
                .goToCart();
        SauceDemoCartPage cartPage = new SauceDemoCartPage();
        Assertions.assertThat(cartPage.getPageName("Your Cart")).isTrue();
        cartPage.clickCheckout();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage();
        Assertions.assertThat(checkoutStepOnePage.getPageName("Checkout: Your Information")).isTrue();
        checkoutStepOnePage.enterDeliveryAddressFirstName(data.get("firstname"))
                .enterDeliveryAddressLastName(data.get("lastname"))
                .enterDeliveryAddressZipCode(data.get("zip"))
                .clickContinueButton();
        CheckoutStepTwoPage checkoutStepTwoPagePage = new CheckoutStepTwoPage();
        Assertions.assertThat(checkoutStepTwoPagePage.getPageName("Checkout: Overview")).isTrue();
        checkoutStepTwoPagePage.clickFinishButton();
        SuccessPage successPage = new SuccessPage();
        Assertions.assertThat(successPage.getPageName("Checkout: Complete!")).isTrue();
        successPage.clickBackHomeButton().expandMenu().clickOnMenuItem("Logout");
    }

/*    @Test
    public void invalidDeliveryAddress(Map<String, String> data) {
        SauceDemoProductsPage productsPage = (SauceDemoProductsPage) new SauceDemoLoginPage().enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
        //CheckoutStepOnePage myCartPage = productsPage.goToCart().clickCheckout();
        Assert.assertTrue(productsPage.goToCart().clickCheckout().contains("Unable to checkout!!!"));
    }*/
}
