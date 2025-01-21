package com.testingacademy.pages.pageObjectModel.vmo01_normal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {    //parameterized constructor

        this.driver = driver;

    }

    //Step 1 - page locators

    private By userNameOnDashboard = By.cssSelector("[data-qa='lufexuloga']");


    //Step 2 - page actions

    public String loggedInUserName()
    {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(userNameOnDashboard).getText();
    }


}
