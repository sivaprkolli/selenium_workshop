package com.sw.examples;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class GetScreenshotOfPageAndElement {
    WebDriver driver;
    @Test
    public void getScreenShotOfPage() throws IOException {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir")+"/screenshots/page.png");
        FileUtils.copyFile(source, dest);
    }

    @Test
    public void getScreenShotOfWebElement() throws IOException {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        File source = loginButton.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir")+"/screenshots/button.png");
        FileUtils.copyFile(source, dest);
    }
}
