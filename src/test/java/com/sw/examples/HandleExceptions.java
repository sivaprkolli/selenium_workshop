package com.sw.examples;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class HandleExceptions {
    WebDriver driver;

    @Test
    public void handleElementClickInterceptedException(){
        driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String click = "arguments[0].click()";

        driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
        WebElement subCheckBox = driver.findElement(By.id("SubscriptionAgreement"));
        try {
            subCheckBox.click();
        }catch (ElementClickInterceptedException ecie){
            ecie.printStackTrace();
            jse.executeScript(click, subCheckBox);
        }

        Assert.assertTrue(subCheckBox.isSelected());
    }

    @Test
    public void handleStaleElementException(){
        driver = new ChromeDriver();
        driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
        WebElement firstNameInputBox = driver.findElement(By.name("UserFirstName"));
        firstNameInputBox.sendKeys("Siva");

        driver.navigate().refresh();
        try {
            firstNameInputBox.sendKeys("Siva");
        }catch (StaleElementReferenceException ste){
            ste.printStackTrace();
            driver.findElement(By.name("UserFirstName")).sendKeys("Selenium");
        }

    }
    @AfterTest
    public void killSession(){
        driver.quit();
    }
}
