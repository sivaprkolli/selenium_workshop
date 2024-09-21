package com.sw.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class MultipleElements {
    WebDriver driver;
    @Test
    public void handleMultipleElements(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.cssSelector("[onclick*='addElement']"));
        System.out.println(addButton);
        for(int i=0; i<5; i++){
            addButton.click();
        }

        List<WebElement> deleteButton = driver.findElements(By.cssSelector("[nclick*='deleteElement']"));
        System.out.println(deleteButton);
        System.out.println(deleteButton.size());
        System.out.println("**********************************");

        List<WebElement> deleteButton1 = driver.findElements(By.cssSelector("[onclick*='deleteElement']"));
        System.out.println(deleteButton1);
        System.out.println(deleteButton1.size());

        Assert.assertEquals(deleteButton1.size() , 5);
    }

    public WebElement test1(){
        return driver.findElement(By.cssSelector(""));
    }

    public List<WebElement> test2(){
        return driver.findElements(By.cssSelector(""));
    }


    @AfterTest
    public void killSession(){
        driver.quit();
    }
}
