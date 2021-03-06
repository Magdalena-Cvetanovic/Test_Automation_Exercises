package org.example.pages.facebook;

import org.example.helpers.WebElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FacebookRegistrationModal extends WebElementUtils {

    @FindBy(name = "firstname")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;
    @FindBy(name = "reg_email__")
    private WebElement mobileOrEmailInput;
    @FindBy(name = "reg_passwd__")
    private WebElement newPasswordInput;
    @FindBy(name = "birthday_day")
    private WebElement daySelect;
    @FindBy(name = "birthday_month")
    private WebElement monthSelect;
    @FindBy(name = "birthday_year")
    private WebElement yearSelect;
    @FindBy(xpath = "//span[@class='_5k_3']/span")
    private List<WebElement> genderRadioBtns;
    @FindBy(name = "websubmit")
    private WebElement signUpBtn;
    @FindBy(xpath = "//div[contains(@class, '_5dbb _5634')]")
    private List<WebElement> requiredFileds;

    private Select days = new Select(daySelect);
    private Select months = new Select(monthSelect);
    private Select years = new Select(yearSelect);

    public FacebookRegistrationModal(WebDriver driver) {
        super(driver);
    }
    private void enterFirstName(String name){
        firstNameInput.sendKeys(name);
    }
    private void enterLastName(String surname){
        lastNameInput.sendKeys(surname);
    }
    private void enterEmailOrMobile(String numberOrEmail){
        mobileOrEmailInput.sendKeys(numberOrEmail);
    }
    private void enterNewPassword(String password){
        newPasswordInput.sendKeys(password);
    }
    private void chooseDay(String day){
        days.selectByValue(day);
    }
    private void chooseMonth(String month){
        months.selectByValue(month);
    }
    private void chooseYear(String year){
        years.selectByValue(year);
    }

    public void chooseGender(String gender){
        for (WebElement genderBtn : genderRadioBtns){
            if(genderBtn.getText().equalsIgnoreCase(gender)){
                click(genderBtn);
            }
        }
    }
    public void clickSignUp(){
        click(signUpBtn);
    }
    public void fillOutRegistrationForm (String name, String surname, String mobileOrEmail, String newPassword,
                          String day, String month, String year, String gender){
        enterFirstName(name);
        enterLastName(surname);
        enterEmailOrMobile(mobileOrEmail);
        enterNewPassword(newPassword);
        chooseDay(day);
        chooseMonth(month);
        chooseYear(year);
        chooseGender(gender);

    }
    public int getNumberOfRequiredFields(){
        int number = requiredFileds.size();
        return number;
    }
    public boolean warningIconNotdisplayed(){
        boolean notDisplayed = false;
        if(getNumberOfRequiredFields()!=0){
            System.out.println("Please fill out the required fields");
        }else{
            notDisplayed=true;
        }
        return notDisplayed;
    }
}
