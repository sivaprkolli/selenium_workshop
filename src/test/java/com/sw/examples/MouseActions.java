package com.sw.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MouseActions {
    WebDriver driver;

    //setTimeout(()=>{debugger}, 3000) for pausing the browser
    @Test
    public void handleDynamicDropdowns(){
        driver = new ChromeDriver();

        driver.get("https://www.next.co.uk/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[.='Accept All Cookies']")).click();
        WebElement mainMenu = driver.findElement(By.xpath("//div[text()='men']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(mainMenu).perform();
        WebElement submenu = driver.findElement(By.xpath("//span[text()='Christmas Shop Is Open!']"));
        actions.moveToElement(submenu).click().perform();


        //examples:
        // actions.doubleClick(mainMenu);// double click
        // actions.clickAndHold(mainMenu).moveToElement(submenu); // swipe
        // actions.dragAndDrop(mainMenu, submenu) // drag and drop
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
