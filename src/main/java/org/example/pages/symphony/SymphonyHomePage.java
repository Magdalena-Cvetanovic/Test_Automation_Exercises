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

    public void navigateTo(String link) {
        for (int i = 0; i < navigationLinks.size(); i++) {
            String linkName = navigationLinks.get(i).getText();
            if (linkName.equalsIgnoreCase(link)) {
                moveToElement(navigationLinks.get(i));
            }
        }
    }
    private WebElement getCareerLink() {
            WebElement carrerLink = null;
            for (int i = 0; i < navigationLinks.size(); i++) {
                String linkName = navigationLinks.get(i).getText();
                if (linkName.contains("Careers")) {
                    carrerLink = navigationLinks.get(i);
                    break;
                }
            }
            return carrerLink;
        }

    private List<WebElement> getCareerSubNav(){
        List<WebElement> careerSubNav = getCareerLink().findElements(By.xpath("./div/ul/li"));
        return careerSubNav;
    }
    public void chooseCareerSubNavLink(String link){
        List<WebElement> links = getCareerSubNav();
        for (int i = 0; i<links.size(); i++){
            String linkName = links.get(i).getText();
            if(linkName.equalsIgnoreCase(link)){
                click(links.get(i));
                break;
            }
        }
        checkIfPageIsReady();
    }

}
