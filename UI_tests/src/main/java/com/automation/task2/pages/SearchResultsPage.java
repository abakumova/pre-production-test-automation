package com.automation.task2.pages;


import com.automation.task2.fragments.SearchResultItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @Timeout(5)
    @FindBy(className = "catalog")
    private HtmlElement catalogSection;

    private List<SearchResultItem> searchResultItemList;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PAGE_URL += "search/";
    }

    public List<String> getSearchResultItemsNames() {
        List<String> names = new ArrayList<>();
        searchResultItemList.forEach(item -> names.add(item.getItemName()));
        return names;
    }

    public WebElement getLoadableElement() {
        return catalogSection;
    }
}
