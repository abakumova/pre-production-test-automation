package com.automation.tests.task1.tests;

import com.automation.task1.google.HomePage;
import com.automation.task1.google.SearchPage;
import com.automation.task1.selenide.SelenidePage;
import com.automation.task1.selenium.WebDriverPage;
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
        Assert.assertTrue(content.contains("Selenium WebDriver"));
    }

    @Test
    public void validateSelenideWebPage() {
        SearchPage searchPage = new HomePage(new ChromeDriver()).open().search(SEARCH_TEXT_TASK2);
        SelenidePage selenidePage = (SelenidePage) searchPage.goToPage("Selenide");
        String content = selenidePage.getContent();
        Assert.assertEquals(true, content.contains("Selenide"));
    }
}