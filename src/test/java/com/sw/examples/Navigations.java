package com.sw.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Navigations {

    WebDriver driver;

    @Test
    public void verifyNavigation(){
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        WebElement addRemoveLink = driver.findElement(By.linkText("Add/Remove Elements"));
        addRemoveLink.click();

        driver.navigate().back();
        WebElement abTestingLink = driver.findElement(By.partialLinkText("Testing"));
        Assert.assertTrue(abTestingLink.isDisplayed());

        driver.navigate().forward();

        WebElement addButton = driver.findElement(By.cssSelector("[onclick*='addElement']"));
        Assert.assertTrue(addButton.isDisplayed());

        WebElement heading = driver.findElement(By.xpath("//h3[text()='Add/Remove Elements']"));
        Assert.assertTrue(heading.isDisplayed());
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
