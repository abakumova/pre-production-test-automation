package com.automation.task2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.concurrent.TimeUnit;

public abstract class BasePage implements Page {

    protected static String PAGE_URL = "http://pn.com.ua/";
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(this.webDriver)), this);
    }

    @Override
    public void openPage() {
        webDriver.get(PAGE_URL);
    }

    public boolean isPageLoaded() {
        return getLoadableElement().isDisplayed();
    }

    protected WebElement getLoadableElement(){
        return getLoadableElement();
    }
}
