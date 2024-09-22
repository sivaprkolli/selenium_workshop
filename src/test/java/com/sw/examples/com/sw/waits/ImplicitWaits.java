package com.sw.examples.com.sw.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaits {
    WebDriver driver;

    @Test
    public void usingImplicitWait(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement userNameInputBox = driver.findElement(By.id("user-name"));
        userNameInputBox.sendKeys("standard_user");
        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("secret_sauce");
        WebElement submitButton = driver.findElement(By.cssSelector(".submit-button.btn_action"));
        submitButton.click();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
