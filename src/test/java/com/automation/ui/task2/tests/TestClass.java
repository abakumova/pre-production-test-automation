package com.automation.ui.task2.tests;

import com.automation.ui.task2.pages.ComputerPage;
import com.automation.ui.task2.pages.CouchPage;
import com.automation.ui.task2.pages.HomePage;
import com.automation.ui.task2.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class TestClass {

    private WebDriver webDriver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private ComputerPage computerPage;
    private CouchPage couchPage;

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeClass
    public void initialize() {
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        searchResultsPage = new SearchResultsPage(webDriver);
    }

    @Test
    public void checkSearchPageOpeningAfterSearchQuery() {
        homePage.openPage();
        homePage.search("PS4");
        assertThat(searchResultsPage.isPageLoaded())
                .as("Search results Page wasn't loaded")
                .isTrue();
    }

    @Test
    public void checkSearchOnHomePage() {
        homePage.openPage();
        homePage.search("Nintendo");
        assertTrue(searchResultsPage.isPageLoaded(), "Search results Page wasn't loaded");
        searchResultsPage.getSearchResultItemsNames()
                .forEach(itemName ->
                        assertThat(itemName.contains("Nintendo"))
                                .as("Found item, that shouldn't be is search results: %s", itemName)
                                .isTrue());
    }

    @Test
    public void checkIT() {
        homePage.openPage();
        computerPage = homePage.choiceComputerCategory();
        assertTrue(computerPage.getTextITService().contains("IT услуги"));
    }

    @Test
    public void checkCouch() {
        homePage.openPage();
        couchPage = homePage.choiceCouchCategory();
        assertTrue(couchPage.getTextPopular().contains("AMF"));
    }

    @AfterClass
    public void stopDriver() {
        webDriver.close();
    }
}