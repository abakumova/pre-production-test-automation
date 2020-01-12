package com.automation.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SofaPage extends BasePage {

    @FindBy(xpath = "//*[@class=\"popular-category\"]/ul/li[1]")
    private WebElement sofaButton;

    @FindBy(xpath = ".//*[@id='producers-filter-block']/div[2]/span[4]/a")
    private WebElement sofaMaker;

    public SofaPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SofaPage clickSofaButton() {
        sofaButton.click();
        return new SofaPage(webDriver);
    }

    public String getTextSofaMaker() {
        return sofaMaker.getText();
    }
}
