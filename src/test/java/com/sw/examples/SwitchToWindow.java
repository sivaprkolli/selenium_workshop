package com.sw.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchToWindow {

    WebDriver driver;

    @Test
    public void switchingWindows() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        String parentWindow = driver.getWindowHandle();
        System.out.println("parentWindow :: " + parentWindow);

        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        Set<String> windowIds = driver.getWindowHandles();
        System.out.println(windowIds);

        for (String window : windowIds) {
            //if(driver.getTitle().equals("New Window"))
            driver.switchTo().window(window);
        }

        WebElement heading = driver.findElement(By.tagName("h3"));
        String headingText = heading.getText();
        System.out.println(headingText);

        driver.close();

        driver.switchTo().window(parentWindow);

        WebElement heading1 = driver.findElement(By.tagName("h3"));
        String headingText1 = heading1.getText();
        System.out.println(headingText1);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
