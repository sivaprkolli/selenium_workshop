package com.sw.examples;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SwitchingFrames {
    WebDriver driver;
    @Test
    public void switchToFrame(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://yopmail.com/en/wm");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.switchTo().frame("ifmail");

        WebElement element = driver.findElement(By.xpath("//p[contains(.,'2 advances created by you are unsubmitted.')]"));
        System.out.println(element.getText());
        driver.quit();
    }

    @Test
    public void multipleFrames(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.switchTo().frame(driver.findElement(By.cssSelector("[src*='frame_top']")));
        driver.switchTo().frame("frame-left");

        WebElement left = driver.findElement(By.xpath("//body[normalize-space()='LEFT']"));
        Assert.assertTrue(left.isDisplayed());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//div[normalize-space()='MIDDLE']"));
        Assert.assertTrue(middle.isDisplayed());


        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//body[normalize-space()='BOTTOM']"));
        Assert.assertTrue(bottom.isDisplayed());
    }

    @AfterTest
    public void teamDown(){
        driver.quit();
    }

}
