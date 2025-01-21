package com.testingacademy.pages.pageObjectModel.vmo01_normal;

import com.testingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //page class
    //page locators

    WebDriver driver;

    public LoginPage(WebDriver driver) //parameterized constructor
    {
        this.driver = driver;
    }

    //step1 - page locators

    private By username = By.id("login-username");   //private cause encapsulation, no data is shared to other page
    private By password = By.name("password");
    private By submit = By.id("js-login-btn");
    private By error_message = By.className("notification-box-description");


    //step2 - Page actions
    public String loginToVWOInvalidCreds(String user, String pass) //Function or method
    {

        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submit).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String error_message_text = driver.findElement((error_message)).getText();
        return error_message_text;

    }

    public void loginToVWOvalidCreds(String user, String pass) {

        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submit).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
