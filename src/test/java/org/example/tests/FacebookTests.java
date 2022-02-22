package org.example.tests;

import org.example.BaseTest;
import org.example.pages.facebook.FacebookHomePage;
import org.example.pages.facebook.FacebookRegistrationModal;
import org.example.pages.google.GoogleHomePage;
import org.example.pages.google.GoogleSearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookTests extends BaseTest {


    @Test(priority = 1)
    public void shouldVisitFacebook(){
        GoogleHomePage ghp = new GoogleHomePage(driver);
        String searchCriteria = "facebook";
        ghp.conductSearch(searchCriteria);
        GoogleSearchResultsPage gsrp = new GoogleSearchResultsPage(driver);
        gsrp.clickFirstAlternativeLink();
        Assert.assertTrue(driver.getCurrentUrl().contains(searchCriteria));
    }
    @Test(priority = 2)
    public void shouldTryEmptySignUp(){
        FacebookHomePage fhp = new FacebookHomePage(driver);
        fhp.openRegistration();
        FacebookRegistrationModal frm = new FacebookRegistrationModal(driver);
        frm.clickSignUp();
        System.out.println("The number of required fileds is "+ frm.getNumberOfRequiredFields());

    }
    @Test(priority = 3)
    public void shouldFillOutTheSignUp(){
        FacebookRegistrationModal frm = new FacebookRegistrationModal(driver);
        frm.fillOutRegistrationForm("Test","User","381 61 793285","something",
                "1","7", "1980","male");
        Assert.assertTrue(frm.warningIconNotdisplayed());

    }
}
