package com.automation.ui.task1.pages.google;

import com.automation.ui.task1.pages.BasePage;
import com.automation.ui.task1.pages.selenide.SelenidePage;
import com.automation.ui.task1.pages.selenium.WebDriverPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    private static final By WEBDRIVER_LOCATOR = By.xpath("//div[@id='search']//h3[.='WebDriver - Selenium']");
    private static final By SELENIDE_LOCATOR = By.xpath("//div[@id='search']//h3[contains(.,'Selenide: лаконичные и стабильные UI тесты на Java')]");

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public BasePage goToPage(String pageName) {
        if (pageName.equals("Selenium")) {
            webDriver.findElement(WEBDRIVER_LOCATOR).click();
            return new WebDriverPage(webDriver);
        } else if (pageName.equals("Selenide")) {
            webDriver.findElement(SELENIDE_LOCATOR).click();
            return new SelenidePage(webDriver);
        }

        throw new IllegalArgumentException("No page found");
    }
}
