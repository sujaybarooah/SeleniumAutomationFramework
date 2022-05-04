package com.sb.tests;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.sb.driver.DriverManager;

import java.util.List;


public final class HomePageTests extends BaseTest {
    private HomePageTests() {
    }

    @Test
    public void test2() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Sujay", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();

        assertThat(title)
                .isNotNull()
                .containsIgnoringCase("google search")
                .matches("\\w.*" + "Google Search")
                .hasSizeBetween(15, 100);

        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//a/h3"));
        assertThat(elements)
                .hasSizeGreaterThanOrEqualTo(9)
                .extracting(WebElement::getText)
                .contains("Sujay Barooah - Technical Test Lead - Infosys | LinkedIn");
    }
}
