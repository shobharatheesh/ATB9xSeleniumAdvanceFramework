package com.testingacademy.tests.POMTestcases.vwoTestCases;

import com.testingacademy.pages.pageObjectModel.vmo01_normal.LoginPage;
import com.testingacademy.pages.pageObjectModel.vmo02.improved.pom.DashboardPage;
import com.testingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin04_POM_PropertyReader {

    @Owner("SHOBHA")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO(){
        WebDriver driver = new EdgeDriver();


        LoginPage login = new LoginPage(driver);
        String error_message_text = login.loginToVWOInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));


        Assert.assertEquals(error_message_text,"Your email, password, IP address or location did not match");
        System.out.print(error_message_text);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @Owner("SHOBHA")
    @Description("Verify that valid creds and  dashboard page is loaded")
    @Test

    public void testLoginPositiveVWO(){
        WebDriver driver = new EdgeDriver();


        LoginPage login = new LoginPage(driver);
        login.loginToVWOvalidCreds(PropertiesReader.readKey("valid_username"),PropertiesReader.readKey("valid_password"));

        DashboardPage dashboard = new DashboardPage(driver);
        String usernameLoggedIn = dashboard.loggedInUserName();

        //assertj assertion
        assertThat(usernameLoggedIn).isNotBlank().isNotEmpty().isNotNull();

        //testng asserting
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));
        System.out.println(usernameLoggedIn);


    }


}
