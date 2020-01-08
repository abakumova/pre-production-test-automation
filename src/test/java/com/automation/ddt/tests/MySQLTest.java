package com.automation.ddt.tests;

import com.automation.ddt.utils.MySQLConnection;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class MySQLTest extends BasicTest {

    @Test
    public void registrationData() throws SQLException {
        String text = MySQLConnection.connectToDB();
        loginPage.enterLogin(text);
        loginPage.enterPassword(text);
        loginPage.submitEntering();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://github.com/session");
        Assert.assertEquals("Incorrect username or password.", loginPage.getTextErrorMessage());
    }
}
