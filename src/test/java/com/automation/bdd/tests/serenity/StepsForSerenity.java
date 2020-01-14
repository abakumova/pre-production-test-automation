package com.automation.bdd.tests.serenity;

import com.automation.bdd.pages.ComputerPage;
import com.automation.bdd.pages.HomePage;
import com.automation.bdd.pages.SofaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class StepsForSerenity {

    private HomePage homePage;
    private WebDriver webDriver;
    private ComputerPage computerPage;
    private SofaPage sofaPage;

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @Step("Given the user visits a page {0}")
    public void userVisitsPage() {
        webDriver = new ChromeDriver();
        webDriver.get("https://pn.com.ua/");
        this.homePage = new HomePage(webDriver);
    }

    @Step("When the user chooses Computer category")
    public void userChoosesComputerCategory() {
        computerPage = homePage.choiceComputerCategory();
    }

    @Step("When the user chooses sofa category")
    public void userChoosesSofaCategory() {
        sofaPage = homePage.choiceSofaCategory();
    }

    @Step("Then the user sees  {0} subcategory")
    public void theUserCanSeeSubcategoryITService(String subCategory) {
        assertThat(computerPage.getTextITService()).overridingErrorMessage("testComputerCategory failed").contains(subCategory);
    }

    @Step("When the user chooses maker")
    public void theUserChoosesSofaMaker() {
        sofaPage.clickSofaButton();
    }

    @Step("Then the user sees  {1} sofas by the maker")
    public void theUserCanSeeChosenSofas(String subCategory) {
        assertThat(sofaPage.getTextSofaMaker()).overridingErrorMessage("testSofaCategory failed").contains(subCategory);
    }

    @Step("Close")
    public void webDriverClose() {
        webDriver.close();
    }
}

