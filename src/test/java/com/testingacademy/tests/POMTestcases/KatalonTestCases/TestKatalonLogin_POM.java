package com.testingacademy.tests.POMTestcases.KatalonTestCases;

import com.testingacademy.pages.pageObjectModel.katalonCura.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestKatalonLogin_POM {

    @Owner("SHOBHA")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeKatalon(){
        WebDriver driver = new EdgeDriver();

        LoginPage login = new LoginPage(driver);
        String error_message_text = login.loginToKatalonInvalidCreds("admin","ThisIsNotAPassword");

        //Login failed! Please ensure the username and password are valid.

        Assert.assertEquals(error_message_text,"Login failed! Please ensure the username and password are valid.");
        System.out.print(error_message_text);

    }
    @Owner("SHOBHA")
    @Description("Verify that valid creds and  Make Appointment page is loaded")
    @Test
    public void testLoginPositiveKatalon(){

        WebDriver driver = new EdgeDriver();

        LoginPage login = new LoginPage(driver);
        String error_message_text1 = login.loginToKatalonValidCreds("John Doe","ThisIsNotAPassword");

        Assert.assertEquals(error_message_text1,"Make Appointment");
        System.out.println(error_message_text1);

    }
}
