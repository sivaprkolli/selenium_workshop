package com.sw.examples.cpm.sw.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ExplicitWaits {
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

    }

    @Test
    public void webDriverWait(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("secret_sauce");
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".submit-button.btn_action"))).click();

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        System.out.println(passwordInputBox);
        passwordInputBox.sendKeys("secret_sauce");
        WebElement submitButton = driver.findElement(By.cssSelector(".submit-button.btn_action"));

        boolean b = wait.until(ExpectedConditions.attributeContains(By.id("login-button"), "data-test", "button"));
        System.out.println(b);
        Assert.assertTrue(b);

        List<WebElement> inputBoxes = wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".input_error.form_input"), 2));
        System.out.println(inputBoxes.size());

        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    @Test
    public void fluentWait(){
        FluentWait fluentWait = new FluentWait(driver)
                .pollingEvery(Duration.ofSeconds(3))
                .withTimeout(Duration.ofSeconds(10))
                .withMessage("Please check the webElement locator")
                .ignoring(NoSuchElementException.class);


        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
