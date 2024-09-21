package com.sw.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void launchApp() throws InterruptedException {

        ChromeDriver driver3 = new ChromeDriver();
        ChromiumDriver driver1 = new ChromeDriver();
        RemoteWebDriver driver2 = new ChromeDriver();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector(".submit-button.btn_action")).click();

        EdgeDriver edgeDriver = new EdgeDriver();
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        SafariDriver safariDriver = new SafariDriver();


        Thread.sleep(10000);
        driver.quit();
    }
}
