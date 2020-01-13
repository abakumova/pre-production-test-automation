package com.automation.ui.task1.tests;

import com.automation.ui.task1.pages.google.HomePage;
import com.automation.ui.task1.pages.google.SearchPage;
import com.automation.ui.task1.pages.selenide.SelenidePage;
import com.automation.ui.task1.pages.selenium.WebDriverPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchForSomethingTest {

    private final String SEARCH_TEXT_TASK1 = "Selenium WebDriver";
    private final String SEARCH_TEXT_TASK2 = "Selenide";

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @Test
    public void validateSeleniumWebPage() {
        SearchPage searchPage = new HomePage(new ChromeDriver()).open().search(SEARCH_TEXT_TASK1);
        WebDriverPage webDriverPage = (WebDriverPage) searchPage.goToPage("Selenium");
        String content = webDriverPage.getContent();
        Assert.assertTrue(content.contains("Selenium"));
    }

    @Test
    public void validateSelenideWebPage() {
        SearchPage searchPage = new HomePage(new ChromeDriver()).open().search(SEARCH_TEXT_TASK2);
        SelenidePage selenidePage = (SelenidePage) searchPage.goToPage("Selenide");
        String content = selenidePage.getContent();
        Assert.assertTrue(content.contains("Selenide"));
    }
}