package org.example.tests;

import org.example.BaseTest;
import org.example.pages.google.GoogleHomePage;
import org.example.pages.google.GoogleSearchResultsPage;
import org.example.pages.symphony.SymphonyCareersPage;
import org.example.pages.symphony.SymphonyHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SymphonyTests extends BaseTest {

    @Test(priority = 1)
    public void shouldNavigateToSymphony(){
        GoogleHomePage ghp = new GoogleHomePage(driver);
        String searchCriteria = "symphony";
        ghp.conductSearch(searchCriteria);
        GoogleSearchResultsPage gsrp = new GoogleSearchResultsPage(driver);
        gsrp.clickFirstLink();
        Assert.assertTrue(driver.getCurrentUrl().contains(searchCriteria));
    }
    @Test(priority = 2)
    public void shouldNavigateToCareers(){
        SymphonyHomePage shp = new SymphonyHomePage(driver);
        String navLink = "Careers";
        String subNavLink = "Current openings";
        shp.navigateTo(navLink);
        shp.chooseCareerSubNavLink(subNavLink);
        Assert.assertTrue(driver.getCurrentUrl().contains(navLink.toLowerCase()));
    }
    @Test(priority = 3)
    public void shouldDisplayNumberOfOpenQaJobs(){
        SymphonyCareersPage scp = new SymphonyCareersPage(driver);
        int jobs = scp.numberOfOpenJobs("QA");
        System.out.println("There are " + jobs + " open QA jobs.");
    }
}
