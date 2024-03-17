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
    WebDriver driver = new ChromeDriver(); // Move to driver manager class for re-use

    @BeforeTest
    public void setUp() {
        /*
            Move these config in web driver manager class for re-use
            Maximize window
            Set timeout for page loading
            Config url
        */
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://example.com/");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1, description = "Login with valid email and password")
    public void loginWithValidUser() {
        // Pre-con: Have a test account with email: long.nguyenvan@opti.com
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

