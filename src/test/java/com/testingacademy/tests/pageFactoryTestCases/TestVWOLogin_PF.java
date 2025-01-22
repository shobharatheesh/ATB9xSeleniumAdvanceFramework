package com.testingacademy.tests.pageFactoryTestCases;

import com.testingacademy.base.CommonToAllTest;
import com.testingacademy.driver.DriverManager;
import com.testingacademy.pages.pageFactory.LoginPage_PF;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.testingacademy.utils.PropertiesReader;


public class TestVWOLogin_PF extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);

    @Test
    public void testLoginNegativeVWO_PF() {
        logger.info("Starting the Testcases Page Factory");
        WebDriver driver = DriverManager.getDriver();
        driver.get(PropertiesReader.readKey("url"));

        LoginPage_PF loginPage_PF = new LoginPage_PF(driver);
        String error_message = loginPage_PF.loginToVWOInvalidCreds();
        Assert.assertEquals(error_message, PropertiesReader.readKey("expected_error_message"));
    }




}