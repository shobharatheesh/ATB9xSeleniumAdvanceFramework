package com.testingacademy.base;

import com.testingacademy.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

        //driverManager code  is available here

        @BeforeMethod
        public void setUp(){
                DriverManager.init(); //when sriver starts initialize
        }

        @AfterMethod
        public void tearDown(){
                DriverManager.down(); //when driver ends its stops
        }


}