package org.example.pages.facebook;

import org.example.helpers.WebElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookHomePage extends WebElementUtils {

    @FindBy(xpath = "//div[@class ='_6ltg']/a")
    private WebElement createNewAccountBtn;

    public FacebookHomePage(WebDriver driver) {
        super(driver);
    }

    public void openRegistration(){
        click(createNewAccountBtn);
    }
}
