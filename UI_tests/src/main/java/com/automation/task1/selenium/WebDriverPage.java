package com.automation.task1.selenium;

import com.automation.task1.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebDriverPage extends BasePage {

    private static final By CONTENT = By.xpath("//div[@id='mainContent']");

    public WebDriverPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getContent() {
        return webDriver.findElement(CONTENT).getText();
    }
}
