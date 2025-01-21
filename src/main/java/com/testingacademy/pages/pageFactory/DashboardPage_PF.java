package com.testingacademy.pages.pageFactory;

import com.testingacademy.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage_PF extends CommonToAllPage {

    WebDriver driver;

    public DashboardPage_PF(WebDriver driver) {    //parameterized constructor

        this.driver = driver;

    }

    //Step 1 - page locators

     By userNameOnDashboard = By.cssSelector("[data-qa='lufexuloga']");


    //Step 2 - page actions

    public String loggedInUserName()
    {
       visibilityOfElement(userNameOnDashboard);
       return getText(userNameOnDashboard);
    }


}
