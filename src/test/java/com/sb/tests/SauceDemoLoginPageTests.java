package com.sb.tests;


import com.sb.pages.*;
import org.assertj.core.api.Assertions;
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
        SauceDemoCheckoutStepOnePage sauceDemoCheckoutStepOnePage = new SauceDemoCheckoutStepOnePage();
        Assertions.assertThat(sauceDemoCheckoutStepOnePage.getPageName("Checkout: Your Information")).isTrue();
        sauceDemoCheckoutStepOnePage.enterDeliveryAddressFirstName(data.get("firstname"))
                .enterDeliveryAddressLastName(data.get("lastname"))
                .enterDeliveryAddressZipCode(data.get("zip"))
                .clickContinueButton();
        SauceDemoCheckoutStepTwoPage sauceDemoCheckoutStepTwoPagePage = new SauceDemoCheckoutStepTwoPage();
        Assertions.assertThat(sauceDemoCheckoutStepTwoPagePage.getPageName("Checkout: Overview")).isTrue();
        sauceDemoCheckoutStepTwoPagePage.clickFinishButton();
        SauceDemoSuccessPage sauceDemoSuccessPage = new SauceDemoSuccessPage();
        Assertions.assertThat(sauceDemoSuccessPage.getPageName("Checkout: Complete!")).isTrue();
        sauceDemoSuccessPage.clickBackHomeButton().expandMenu().clickOnMenuItem("Logout");
    }

    @Test
    public void invalidDeliveryAddress(Map<String, String> data) {
        SauceDemoLoginPage loginPage = new SauceDemoLoginPage();
        SauceDemoProductsPage productsPage = new SauceDemoProductsPage();
        SauceDemoCartPage cartPage = new SauceDemoCartPage();
        SauceDemoCheckoutStepOnePage sauceDemoCheckoutStepOnePage = new SauceDemoCheckoutStepOnePage();

        loginPage.enterUserName(data.get("username"))
                .enterPassword(data.get("password"))
                .clickLogin();

        productsPage.addItemToCart(data.get("items"))
                .goToCart();

        cartPage.clickCheckout();
        sauceDemoCheckoutStepOnePage.enterDeliveryAddressFirstName(data.get("firstname"))
                .enterDeliveryAddressLastName(data.get("lastname"))
                .enterDeliveryAddressZipCode(data.get("zip"))
                .clickContinueButton();

        Assertions.assertThat(sauceDemoCheckoutStepOnePage.isCheckoutErrorPresent()).isTrue();
    }

    @Test
    public void checkoutWithEmptyCart(Map<String, String> data) {
        SauceDemoLoginPage loginPage = new SauceDemoLoginPage();
        SauceDemoProductsPage productsPage = new SauceDemoProductsPage();
        SauceDemoCartPage cartPage = new SauceDemoCartPage();
        SauceDemoCheckoutStepOnePage sauceDemoCheckoutStepOnePage = new SauceDemoCheckoutStepOnePage();

        loginPage.enterUserName(data.get("username"))
                .enterPassword(data.get("password"))
                .clickLogin();
        productsPage.goToCart();
        cartPage.clickCheckout();
        Assertions.assertThat(sauceDemoCheckoutStepOnePage.getPageName("Checkout: Your Information")).isFalse();
    }
}
