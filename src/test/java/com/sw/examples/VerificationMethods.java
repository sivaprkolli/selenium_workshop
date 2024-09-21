package com.sw.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class VerificationMethods {
    WebDriver driver;

    @Test
    public void usageOfVerificationIsDisplayed(){
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement abTestingLink = driver.findElement(By.partialLinkText("Testing"));
        Assert.assertTrue(abTestingLink.isDisplayed());

        WebElement addRemoveLink = driver.findElement(By.linkText("Add/Remove Elements"));
        addRemoveLink.click();

        WebElement heading = driver.findElement(By.cssSelector("#content h3"));
        String headingText = heading.getText();

        Assert.assertEquals(headingText, "Add/Remove Elements");
    }


    @Test
    public void usageVerificationOfIsChecked(){

        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox2 = driver.findElement(By.cssSelector("#checkboxes > input:last-of-type"));
        WebElement checkBox1 = driver.findElement(By.cssSelector("#checkboxes > input:first-of-type"));

        System.out.println(checkBox1.isSelected());
        System.out.println(checkBox2.isSelected());

        checkBox1.click();
        checkBox2.click();

        System.out.println("***********************************");
        System.out.println(checkBox1.isSelected());
        System.out.println(checkBox2.isSelected());
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
