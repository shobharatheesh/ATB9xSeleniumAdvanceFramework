package com.testingacademy.tests.vwoTestCases;

import com.testingacademy.base.CommonToAllTest;
import com.testingacademy.driver.DriverManager;
import com.testingacademy.pages.pageObjectModel.Vwo.DashboardPage;
import com.testingacademy.pages.pageObjectModel.Vwo.LoginPage;
import com.testingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin05_POM_PropertyReader_DriverManager extends CommonToAllTest {

    @Owner("SHOBHA")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO(){


        LoginPage login = new LoginPage(DriverManager.getDriver());
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


        LoginPage login = new LoginPage(DriverManager.getDriver());
        login.loginToVWOvalidCreds(PropertiesReader.readKey("valid_username"),PropertiesReader.readKey("valid_password"));

        DashboardPage dashboard = new DashboardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashboard.loggedInUserName();

        //assertj assertion
        assertThat(usernameLoggedIn).isNotBlank().isNotEmpty().isNotNull();

        //testng asserting
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));
        System.out.println(usernameLoggedIn);


    }


}
