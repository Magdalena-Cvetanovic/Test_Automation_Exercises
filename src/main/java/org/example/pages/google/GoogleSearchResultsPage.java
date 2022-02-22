package org.example.pages.google;

import org.example.helpers.WebElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class GoogleSearchResultsPage extends WebElementUtils {

    @FindBys({
            @FindBy(xpath = "//div[@class='NJo7tc Z26q7c jGGQ5e']"),
            @FindBy(xpath = "./div[@class = 'yuRUbf']/a")
    })
    private List<WebElement> googleSearchResultsList;
    @FindBy(xpath = "//div[@class = 'yuRUbf']/a")
    private List<WebElement> googleSearchResultsWithSubLinks;

    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickFirstLink(){
        click(googleSearchResultsList.get(0));
    }
    public void clickFirstAlternativeLink(){
        googleSearchResultsWithSubLinks.get(0).click();
    }
}
