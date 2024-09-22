package com.sw.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccessShadowDomElement {

    @Test
    public void accessShadowRootElement(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.salesforce.com/in/?ir=1");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement mainRootElement = driver.findElement(By.cssSelector("hgf-c360nav[origin*='sfdcdigital']"));

        SearchContext mainShadowElement = mainRootElement.getShadowRoot();
        System.out.println("mainShadowElement :: " + mainShadowElement.toString());

        mainShadowElement.findElement(By.cssSelector("[data-tracking-type='cta-utility']")).click();
    }

    @Test
    public void secondExample(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://books-pwakit.appspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement mainRootElement = driver.findElement(By.cssSelector("[apptitle='BOOKS']"));
        SearchContext mainShadowElement = mainRootElement.getShadowRoot();
        mainShadowElement.findElement(By.cssSelector("[aria-label=\"Search Books\"]")).sendKeys("Selenium Workshop");

    }
}
