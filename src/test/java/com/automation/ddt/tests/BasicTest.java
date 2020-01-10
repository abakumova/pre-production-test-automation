package com.automation.ddt.tests;

import com.automation.ddt.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicTest {

    protected static WebDriver webDriver;
    protected static LoginPage loginPage;

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeClass
    public static void initialize() {
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
    }

    @AfterClass
    public static void stopDriver() {
        webDriver.close();
    }
}
