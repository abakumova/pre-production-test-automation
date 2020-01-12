package com.automation.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = ".//*[@id='column-center']//a")
    private WebElement computerCategory;

    @FindBy(xpath = "//*[@id='column-center']/section/div[5]/a")
    private WebElement sofaCategory;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public ComputerPage choiceComputerCategory() {
        computerCategory.click();
        return new ComputerPage(webDriver);
    }

    public SofaPage choiceSofaCategory() {
        sofaCategory.click();
        return new SofaPage(webDriver);
    }
}
