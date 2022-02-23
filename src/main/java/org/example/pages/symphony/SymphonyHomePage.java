package org.example.pages.symphony;

import org.example.helpers.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SymphonyHomePage extends WebElementUtils {

    @FindBy (xpath = "//ul[@class='header--nav-list']/li")
    private List<WebElement> navigationLinks;
    @FindBy(xpath = "//ul[@class = 'header--subNav-links']/li/a")
    private List<WebElement> careerLinks;

    public SymphonyHomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo(String link){
        for (WebElement links : navigationLinks){
            if(links.getText().equalsIgnoreCase(link)){
                moveToElement(links);
                break;
            }
        }
    }
    public WebElement getCareerLink(){
        WebElement careerLink = null;
        for(WebElement careerLinks : navigationLinks){
            if(careerLinks.getText().contains("Careers")){
                careerLink= careerLinks;
                break;
            }
        }
        return careerLink;
    }

    private List<WebElement> getCareerSubNav(){
        List<WebElement> careerSubNav = getCareerLink().findElements(By.xpath("./div/ul/li"));
        return careerSubNav;
    }

    public void chooseCareerSubNavLink(String careerLink){
        List<WebElement> links = getCareerSubNav();
        for (WebElement link: links){
            if(link.getText().equalsIgnoreCase(careerLink)){
                click(link);
            }
        }
        checkIfPageIsReady();
    }

}
