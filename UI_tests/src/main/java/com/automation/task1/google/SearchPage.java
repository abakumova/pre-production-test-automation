package com.automation.task1.google;

import com.automation.task1.BasePage;
import com.automation.task1.selenide.SelenidePage;
import com.automation.task1.selenium.WebDriverPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    private static final By PICTURES = By.xpath("//div[@id='hdtb-msb']//div//div[2]//a[1]");
    private static final By WEBDRIVER_LOCATOR = By.xpath("//div[@id='search']//h3[.='Selenium WebDriver']");
    private static final By SELENIDE_LOCATOR = By.xpath("//div[@id='search']//h3[contains(.,'Selenide: лаконичные и стабильные UI тесты на Java')]");

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void goToPictures() {
        webDriver.findElement(PICTURES).click();
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
