package com.automation.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputerPage extends BasePage {

    @FindBy(xpath = ".//div[@class='h3' and contains(text(),'IT услуги')]")
    private WebElement itService;

    @FindBy(xpath = "//ul[@class='breadcrumb']//li")
    private WebElement returnHomePage;

    public ComputerPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTextITService() {
        return itService.getText();
    }
}
