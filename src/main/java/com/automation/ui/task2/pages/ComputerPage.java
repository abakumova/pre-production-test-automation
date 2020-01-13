package com.automation.ui.task2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerPage extends BasePage {

    @FindBy(xpath = ".//*[@id='column-center']/section/div[5]/article[1]/div/div")
    private WebElement itService;

    public ComputerPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public String getTextITService(){ return itService.getText();}
}
