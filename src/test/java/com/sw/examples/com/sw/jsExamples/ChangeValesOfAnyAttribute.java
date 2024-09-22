package com.sw.examples.com.sw.jsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ChangeValesOfAnyAttribute {

    WebDriver driver;

    @Test
    public void changeValuesOfAttribute(){
        driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement privacyLink = driver.findElement(By.cssSelector("[href='https://www.salesforce.com/company/privacy/']"));
        System.out.println(privacyLink.getAttribute("target"));
        String attribute = "arguments[0].setAttribute('target','_self')";
        jse.executeScript(attribute, privacyLink);
        privacyLink.click();
        System.out.println("Test");
    }

    @AfterTest
    public void killSession(){
        driver.quit();
    }
}
