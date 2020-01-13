package com.automation.ui.task2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

public class CouchPage extends BasePage {

    @FindBy(xpath = "//*[@id='producers-filter-block']/div[2]/span[4]/a")
    private WebElement popularCouches;

    public CouchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTextPopular() {
        return popularCouches.getText();
    }
}
