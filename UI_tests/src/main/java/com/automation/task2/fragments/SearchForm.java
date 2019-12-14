package com.automation.task2.fragments;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(id = "search")
public class SearchForm extends HtmlElement {

    @FindBy(className = "search-text-input")
    private TextInput searchField;
    @FindBy(css = "input[type='submit']")
    private Button searchButton;

    public void inputTextToSearchField(String text) {
        searchField.clear();
        searchField.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
        searchButton.sendKeys("something");
    }
}
