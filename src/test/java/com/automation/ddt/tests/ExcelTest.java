package com.automation.ddt.tests;

import com.automation.ddt.utils.ExcelUtils;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTest extends BasicTest {

    @DataProvider
    public Object[][] authentication() {
        return (ExcelUtils.getTableArray("src/test/resources/TestData.xlsx", "Sheet1"));
    }

    @Test(dataProvider = "authentication")
    public void registrationData(String login, String password) {
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        loginPage.submitEntering();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://github.com/session");
        Assert.assertEquals("Incorrect username or password.", loginPage.getTextErrorMessage());
    }
}
