package org.selenium.test;

import data.dynamic.RandomData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import textResources.TextResource;

import java.time.Duration;

public class LoginTest {
    @BeforeTest
    public void setUp() {
        /*
            Move these config in web driver manager class for re-use
            Maximize window
            Set timeout for page loading, explicitly wait
            Config url
        */
    }

    @AfterTest
    public void tearDown() {
        /*
        Quite driver, close file, close db connection...
         */
    }

    @Test(priority = 1, description = "Login with valid email and password")
    public void loginWithValidUser() {
        /*
            Pre-con: Create a new account or use a sharable account for whole test suite
            I'm assuming I already had an active account with email: long.nguyenvan@opti.com
        */
         */
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .loginValidUser("long.nguyenvan@opti.com", "@123456Long")
                .verifyLoginSuccessfully();
    }

    @Test(priority = 1, description = "Login with either invalid email or password")
    public void loginWithInvalidUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .loginInvalidUser(RandomData.randEmail(), "123456")
                .verifyLoginFailedByEmail(TextResource.invalidEmailOrPass);
    }
}

