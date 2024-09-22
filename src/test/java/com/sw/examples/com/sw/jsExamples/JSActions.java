package com.sw.examples.com.sw.jsExamples;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class JSActions {

    WebDriver driver;

    @Test
    public void clickUsingJS(){
        driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");

        WebElement firstNameInputBox = driver.findElement(By.name("UserFirstName"));
        WebElement subCheckBox = driver.findElement(By.id("SubscriptionAgreement"));

        String firstName = "arguments[0].value='Selenium'";
        String click = "arguments[0].click()";
        firstNameInputBox.clear();
        firstNameInputBox.click();
        //jse.executeScript(click, firstName);
        jse.executeScript(firstName, firstNameInputBox);
        jse.executeScript(click, subCheckBox);
        System.out.println("Test");
    }

    @AfterTest
    public void killSession(){
        driver.quit();
    }
}
