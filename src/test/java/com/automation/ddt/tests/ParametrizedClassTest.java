package com.automation.ddt.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParametrizedClassTest extends BasicTest {

    @DataProvider(name = "testData")
    public static Object[][] loginData() {
        return new Object[][]{
                {"example@gmail.com", "example"},
                {"example@gmail.com", ""},
                {"", "example"},
        };
    }

    @Test(dataProvider = "testData")
    public static void registrationData(String login, String password) {
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        loginPage.submitEntering();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://github.com/session");
        Assert.assertEquals("Incorrect username or password.", loginPage.getTextErrorMessage());
    }
}
