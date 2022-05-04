package com.sb.tests;

import com.sb.listeners.RetryFailedTests;
import com.sb.pages.OrangeHRMLoginPage;
import com.sb.utils.DataProviderUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class OrangeHRMTests extends BaseTest{
    private OrangeHRMTests(){}

    @Test
    public void loginLogoutTest(Map<String,String> data) {
        String title= new OrangeHRMLoginPage()
        .enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
        .clickWelcome().clickLogout()
        .getTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @Test
    public void newTest(Map<String,String> data) {
        String title= new OrangeHRMLoginPage()
                .enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickWelcome().clickLogout()
                .getTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

        /*
        * if not using annotation transformer, the annotations of the test method can be provided as below:
        /*    @Test (dataProvider = "getData", dataProviderClass = DataProviderUtils.class, retryAnalyzer = RetryFailedTests.class)
               public void newTest(Map<String,String> data) {
                    String title= new OrangeHRMLoginPage()
                    .enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
                    .clickWelcome().clickLogout()
                    .getTitle();
                    Assertions.assertThat(title)
                    .isEqualTo("OrangeHRM");
        }*/
}
