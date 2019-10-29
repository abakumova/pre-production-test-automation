package com.automation.task1.google;

import com.automation.task1.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final By SEARCH_FIELD_LOCATOR = By.xpath("//input[@name='q']");
    private static final By SEARCH_BUTTON_LOCATOR = By.xpath("//div[@class='VlcLAe']//input[@name='btnK']");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage open() {
        webDriver.get("https://www.google.com");
        return this;
    }

    public SearchPage search(String searchStr) {
        webDriver.findElement(SEARCH_FIELD_LOCATOR).sendKeys(searchStr);
        webDriver.findElement(SEARCH_BUTTON_LOCATOR).click();

        return new SearchPage(webDriver);
    }
}
