package org.example.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class WebElementUtils {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions action;
    public JavascriptExecutor js;

    public WebElementUtils(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);

    }

    public void waitUntilElementIsClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void click(WebElement element){
        waitUntilElementIsClickable(element);
        element.click();
    }public void moveToElement(WebElement element){
        action.moveToElement(element).perform();
    }
    public void checkIfPageIsReady(){
        for (int i=0; i<25; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (js.executeScript("return document.readyState").toString().equals("complete")){
                break;
            }
        }
    }
}
