package com.sb.tests;

import com.sb.pages.AmazonHomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class AmazonDemoTest extends BaseTest{
    private AmazonDemoTest(){}

    @Test
    public void amazonTest(Map<String,String> data){
        String title = new AmazonHomePage().clickHamburger().clickMobilesAndComputers()
                .clickOnSubMenuItem(data.get("menutext")).getTitle();
        Assertions.assertThat(title).isNotNull().isNotBlank();

    }
}
