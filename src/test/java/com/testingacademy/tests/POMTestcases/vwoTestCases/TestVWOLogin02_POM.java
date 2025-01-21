package com.testingacademy.tests.POMTestcases.vwoTestCases;

import com.testingacademy.pages.pageObjectModel.vmo01_normal.LoginPage;
import com.testingacademy.pages.pageObjectModel.vmo02.improved.pom.DashboardPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin02_POM {

    @Owner("SHOBHA")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO(){
        WebDriver driver = new EdgeDriver();


        LoginPage login = new LoginPage(driver);
        String error_message_text = login.loginToVWOInvalidCreds("admin@gmail.com","123");


        Assert.assertEquals(error_message_text,"Your email, password, IP address or location did not match");
        System.out.print(error_message_text);


    }

    @Owner("SHOBHA")
    @Description("Verify that valid creds and  dashboard page is loaded")
    @Test

    public void testLoginPositiveVWO(){
        WebDriver driver = new EdgeDriver();


        LoginPage login = new LoginPage(driver);
        login.loginToVWOvalidCreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");

        DashboardPage dashboard = new DashboardPage(driver);
        String usernameLoggedIn = dashboard.loggedInUserName();

        //assertj assertion
        assertThat(usernameLoggedIn).isNotBlank().isNotEmpty().isNotNull();

        //testng asserting
        Assert.assertEquals(usernameLoggedIn,"Aman");
        System.out.println(usernameLoggedIn);


    }


}
