package com.testingacademy.tests.KatalonTestCases;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestKatalonLogin {

    @Description("Open the Katalon URL")
    @Test

    public void Katalon_login() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement make_appointment = driver.findElement(By.linkText("Make Appointment"));
        make_appointment.click();

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement login = driver.findElement(By.id("btn-login"));
        login.click();

        Thread.sleep(3000);

        //Verify the current URL is https://katalon-demo-cura.herokuapp.com/#appointment

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
        System.out.println(driver.getCurrentUrl());

        Assert.assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Make Appointment");
        System.out.println("Make Appointment is visible");

    }
}