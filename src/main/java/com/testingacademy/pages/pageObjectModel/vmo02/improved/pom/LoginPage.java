package com.testingacademy.pages.pageObjectModel.vmo02.improved.pom;

import com.testingacademy.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonToAllPage {
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

        openVWOURL();
        enterInput(username , user);
        enterInput(password , pass);
        clickElement(submit);
        custom_wait();
        presenceOfElement(error_message);
        return getText(error_message);

    }

    public void loginToVWOvalidCreds(String user, String pass) {

        openVWOURL();
        enterInput(username , user);
        enterInput(password , pass);
        clickElement(submit);
        presenceOfElement(error_message);
        custom_wait();
    }
}
