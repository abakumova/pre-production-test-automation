package com.automation.ui.task2.pages;

import com.automation.ui.task2.fragments.SearchForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class HomePage extends BasePage {

    @Timeout(5)
    @FindBy(className = ".page-cloud-row")
    private HtmlElement categoriesSection;

    @FindBy(xpath = "//*[@id='column-center']/section/div[5]/ul/li[1]/a")
    private WebElement couchCategory;

    private SearchForm searchForm;

    @FindBy(xpath = ".//*[@id='column-center']/section/div[1]/a")
    private WebElement computerCategory;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void search(String text) {
        searchForm.inputTextToSearchField(text);
        searchForm.clickSearchButton();
    }

    public WebElement getLoadableElement() {
        return (WebElement) categoriesSection;
    }

    public ComputerPage choiceComputerCategory() {
        computerCategory.click();
        return new ComputerPage(webDriver);
    }

    public CouchPage choiceCouchCategory() {
        couchCategory.click();
        return new CouchPage(webDriver);
    }
}
