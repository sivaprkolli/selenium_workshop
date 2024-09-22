package com.sw.examples.com.sw.jsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class GetTextUsingJS {

    WebDriver driver;

    @Test
    public void getTextValue(){
        driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.get("https://play1.automationcamp.ir/advanced.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement starRating = driver.findElement(By.cssSelector(".star-rating"));
        System.out.println("starRating :: " +  starRating.getText());
        String starRating1 = jse.executeScript("return document.querySelector('.star-rating').innerText").toString();
        System.out.println("starRating with js :: " + starRating1);

        String message = jse.executeScript("return document.querySelector('#check_rating').innerText").toString();
        System.out.println("check rating :: " + message);
        System.out.println("Test");
    }

    @Test
    public void getTextFromPseudoElement(){
        driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.get("https://play1.automationcamp.ir/advanced.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement starRating = driver.findElement(By.cssSelector(".star-rating"));

        String stars = jse.executeScript("return window.getComputedStyle(document.querySelector('.star-rating'),'::after').getPropertyValue('content')").toString();
        System.out.println(stars);
    }

    @AfterTest
    public void killSession(){
        driver.quit();
    }
}
