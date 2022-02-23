package org.example.pages.symphony;

import org.example.helpers.WebElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SymphonyCareersPage extends WebElementUtils {

    @FindBy(xpath = "//ul[@class = 'currentOpenings--jobs']/li")
    private List<WebElement> listOfJobOpenings;

    public SymphonyCareersPage(WebDriver driver) {
        super(driver);
    }

    public int numberOfOpenJobs(String jobName){
        int counter = 0;
        for(WebElement job : listOfJobOpenings){
            if(job.getText().contains(jobName)){
                counter++;
            }
        }
        return counter;
    }
}
