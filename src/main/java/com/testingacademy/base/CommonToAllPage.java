package com.testingacademy.base;

import com.testingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static com.testingacademy.driver.DriverManager.getDriver;

public class CommonToAllPage {

    // If you want to call something before every Page Object Class call, Put your Code here");
    // Open File, Open Data Base Connection You can write code here
    //it includes methods for clicking elements, entering text, retrieving text, and waiting for elements to be present or visible.

    public CommonToAllPage()
    {

        //default constructor - which is empty

    }

    public void openVWOURL(){

        getDriver().get(PropertiesReader.readKey("url"));
    }

    public void enterInput(By by, String key){

        getDriver().findElement(by).sendKeys(key);

    }

    public void enterInput (WebElement by, String key)
    {
        by.sendKeys(key);
    }

    //Method overloading for clicking elements , same class name

    public void  clickElement(By by)
    {
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by){

        by.click();
    }


    public String getText(By by)
    {
       return getDriver().findElement(by).getText();
    }

    public void custom_wait()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));

    }

    public WebElement visibilityOfElement(By elementLocation)
    {
        return new WebDriverWait(getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));

    }

    public WebElement getElement(By key)
    {
        return getDriver().findElement(key);
    }






}
