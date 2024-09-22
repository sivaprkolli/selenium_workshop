package com.sw.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {

    @Test
    public void usingRelativeLocators() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        String abTest = driver.findElement(with(By.tagName("a")).above(By.cssSelector("[href*='add_remove_elements']"))).getText();
        System.out.println(abTest);

        String basicAuth = driver.findElement(with(By.tagName("a")).below(By.cssSelector("[href*='add_remove_elements']"))).getText();
        System.out.println(basicAuth);

        String nearElement = driver.findElement(with(By.tagName("a")).near(By.cssSelector("[href*='add_remove_elements']"))).getText();
        System.out.println("nearElement :: " + nearElement);

        driver.quit();

    }
}
