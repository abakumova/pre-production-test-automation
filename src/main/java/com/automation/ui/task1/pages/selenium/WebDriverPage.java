package com.automation.ui.task1.pages.selenium;

import com.automation.ui.task1.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebDriverPage extends BasePage {

    private static final By CONTENT = By.xpath("//div[@class='header-description']");

    public WebDriverPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getContent() {
        return webDriver.findElement(CONTENT).getText();
    }
}
