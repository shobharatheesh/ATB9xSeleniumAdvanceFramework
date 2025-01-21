package com.testingacademy.pages.pageObjectModel.vmo02.improved.pom;

import com.testingacademy.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends CommonToAllPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {    //parameterized constructor

        this.driver = driver;

    }

    //Step 1 - page locators

    private By userNameOnDashboard = By.cssSelector("[data-qa='lufexuloga']");


    //Step 2 - page actions

    public String loggedInUserName()
    {
       visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }


}
