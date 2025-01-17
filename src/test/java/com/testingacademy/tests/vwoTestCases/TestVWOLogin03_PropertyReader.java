package com.testingacademy.tests.vwoTestCases;

import com.testingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLogin03_PropertyReader {

    @Description("Verify the error message for invalid username, pass for vwo.com")
    @Test

    public void test_negative_login() throws Exception
    {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start maximized");


        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get(PropertiesReader.readKey("url"));
        //driver.manage().window().maximize();

        Thread.sleep(3000);

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys(PropertiesReader.readKey("invalid_username"));

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys(PropertiesReader.readKey("invalid_password"));

        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        Thread.sleep(3000);

        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(error_message.getText(),PropertiesReader.readKey("expected_error_message"));
        System.out.println(error_message.getText());

        Thread.sleep(5000);
        driver.quit();










    }

}
