package com.sw.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class colorValidation {

    @Test
    public void verifyColourOfElement(){
        WebDriver driver;

        driver = new ChromeDriver();
        driver.get("https://www.yatra.com/?utm_source=google&utm_medium=search&utm_campaign=brand&_gcl&utm_source=google&utm_medium=cpc&utm_campaign=&gad_source=1&gclid=Cj0KCQjwgL-3BhDnARIsAL6KZ6-piA99JzXQKFiqxpqUjiGEv73RX-vKM5eMf2Hkrvq3oy5Rf7kdTSIaAspjEALw_wcB");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement agreeButton = driver.findElement(By.xpath("//button[text()='Ok,I Agree']"));
        System.out.println(agreeButton.getCssValue("background-color"));
        String rgbaColor = agreeButton.getCssValue("background-color");

        String colour = Color.fromString(rgbaColor).asHex();
        System.out.println("colour :: " + colour);
        Assert.assertEquals(colour, "#f34f4f");

        driver.quit();
    }

    @AfterTest
    public void endSession(){
    }
}


