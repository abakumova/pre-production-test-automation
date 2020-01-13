package com.automation.ui.task1.pages.selenide;

import com.automation.ui.task1.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelenidePage extends BasePage {

    private static final By CONTENT = By.xpath("//*[contains(@class,'wrapper-color-content')]");

    public SelenidePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getContent() {
        return webDriver.findElement(CONTENT).getText();
    }
}
