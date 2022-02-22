package org.example.pages.google;

import org.example.helpers.WebElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends WebElementUtils {

    @FindBy(xpath = "//input[@class = 'gLFyf gsfi']")
    public WebElement searchBar;
    @FindBy(xpath = "//input[@name = 'btnK']")
    public WebElement googleSearchBtn;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }
    private void enterSearchCriteria(String searchCriteria){
        searchBar.sendKeys(searchCriteria);
    }
    private void clickSearchBtn(){
        click(googleSearchBtn);
    }
    public void conductSearch(String searchCriteria){
        enterSearchCriteria(searchCriteria);
        click(googleSearchBtn);
    }
}
