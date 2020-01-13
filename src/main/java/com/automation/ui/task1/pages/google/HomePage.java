package com.automation.ui.task1.pages.google;

import com.automation.ui.task1.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final By SEARCH_FIELD_LOCATOR = By.xpath("//input[@name='q']");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage open() {
        webDriver.get("https://www.google.com");
        return this;
    }

    public SearchPage search(String searchStr) {
        webDriver.findElement(SEARCH_FIELD_LOCATOR).sendKeys(searchStr);
        webDriver.findElement(SEARCH_FIELD_LOCATOR).sendKeys(Keys.ENTER);

        return new SearchPage(webDriver);
    }
}
