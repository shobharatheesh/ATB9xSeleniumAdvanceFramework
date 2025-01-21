package com.testingacademy.tests.POMTestcases.vwoTestCases;

import com.testingacademy.base.CommonToAllTest;
import com.testingacademy.driver.DriverManager;
import com.testingacademy.pages.pageObjectModel.vmo01_normal.LoginPage;
import com.testingacademy.pages.pageObjectModel.vmo02.improved.pom.DashboardPage;
import com.testingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TestVWOLogin07_Improved_log4j_POM_PropertyReader_DriverManager extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin07_Improved_log4j_POM_PropertyReader_DriverManager.class);

    @Owner("SHOBHA")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() {
        System.out.println("Start of test case");
        logger.info("Starting the Negative Testcases VWO | Verify that invalid creds give error message");

        LoginPage login = new LoginPage(DriverManager.getDriver());
        String error_message_text = login.loginToVWOInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        System.out.println("End of test case");
        logger.info("Ending and asserting the Negative Testcases VWO");

        Assert.assertEquals(error_message_text, "Your email, password, IP address or location did not match");
        System.out.print(error_message_text);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Owner("SHOBHA")
    @Description("Verify that valid creds and dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {
        System.out.println("Start of test case");
        logger.info("Starting the Positive Testcases VWO | Verify that valid creds and dashboard page is loaded");

        LoginPage login = new LoginPage(DriverManager.getDriver());
        login.loginToVWOvalidCreds(PropertiesReader.readKey("valid_username"), PropertiesReader.readKey("valid_password"));

        DashboardPage dashboard = new DashboardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashboard.loggedInUserName();

        System.out.println("End of test case");
        logger.info("Ending and asserting the Positive Testcases VWO");

        // assertj assertion
        assertThat(usernameLoggedIn).isNotBlank().isNotEmpty().isNotNull();

        // testng asserting
        Assert.assertEquals(usernameLoggedIn, PropertiesReader.readKey("expected_username"));
        System.out.println(usernameLoggedIn);
    }


}
