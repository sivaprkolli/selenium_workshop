package com.sw.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class KeyBoardKeys {

    @Test
    public void usingKeyBoardKeys(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement userNameInputBox = driver.findElement(By.id("user-name"));
        userNameInputBox.sendKeys("standard_user");
        userNameInputBox.sendKeys(Keys.TAB);
        userNameInputBox.sendKeys(Keys.ENTER);

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("secret_sauce");

        passwordInputBox.submit();
        driver.quit();
    }
}
