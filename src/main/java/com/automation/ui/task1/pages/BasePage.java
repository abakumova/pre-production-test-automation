package com.automation.ui.task1.pages;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
