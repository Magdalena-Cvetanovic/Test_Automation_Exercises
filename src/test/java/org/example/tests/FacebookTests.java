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
        FacebookHomePage fhp = new FacebookHomePage(driver);
        fhp.openRegistration();
    }
    @Test(priority = 2)
    public void shouldTryEmptySignUp(){
        FacebookRegistrationModal frm = new FacebookRegistrationModal(driver);
        frm.clickSignUp();
        frm.fillOutRegistrationForm("Magi","Cat","magicat@mailinator.com","something",
                "10","7", "1995","female");

    }
    @Test(priority = 3)
    public void shouldFillOutTheSignUp(){

    }
}
