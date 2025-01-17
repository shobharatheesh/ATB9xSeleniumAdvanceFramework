package com.testingacademy.pages.pageObjectModel.katalonCura;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;


    //step1 - Page locators

    private By make_appointment = By.linkText("Make Appointment");
    private By username = By.id("txt-username");
    private By password = By.id("txt-password");
    private By login = By.id("btn-login");
    private By error_message = By.className("text-danger");
    private By textdata = By.cssSelector("h2");

    public LoginPage(WebDriver driver) {

        this.driver =driver;
    }


    //step 2 -- Page actions
    public String loginToKatalonInvalidCreds(String user, String pass) {
        //Function or method

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(make_appointment).click();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(login).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String error_message_text = driver.findElement(error_message).getText();
        return error_message_text;
    }

    public String loginToKatalonValidCreds(String user, String pass) {
        //Function or method

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(make_appointment).click();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(login).click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
        String error_message_text1 = driver.findElement(textdata).getText();
        return error_message_text1;

    }


    }






