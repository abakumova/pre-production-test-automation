package com.automation.ddt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"js-flash-container\"]/div")
    private WebElement errorMessage;

    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.webDriver.get("https://github.com/login");
        PageFactory.initElements(webDriver, this);
    }

    public void enterLogin(String login) {
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        ;
        passwordField.sendKeys(password);
    }

    public void submitEntering() {
        signInButton.click();
    }

    public String getTextErrorMessage() {
        return errorMessage.getText();
    }
}
