package com.sw.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

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

        WebElement footerLink = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));// dont follow this type of xpaths
        String attribute = footerLink.getAttribute("href");
        System.out.println("attribute :: " + attribute);
        Assert.assertTrue(attribute.contains("elemental"));

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

    @Test
    public void verifyCheckboxIsSelected() {

        driver = new ChromeDriver();
        driver.navigate().to("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement checkBox2 = driver.findElement(By.xpath("//div[starts-with(@id,'SubscriptionAgreement')]/preceding-sibling::div"));

        System.out.println(driver.findElement(By.cssSelector("#SubscriptionAgreement")).isSelected());
        checkBox2.click();
        System.out.println(driver.findElement(By.cssSelector("#SubscriptionAgreement")).isSelected());
    }

    @Test
    public void verifyButtonIsEnabled(){
        driver = new ChromeDriver();
        driver.get("https://www.prettylittlething.com/stone-oversized-square-quilted-maxi-puffer-coat.html");
        WebElement sizeButton = driver.findElement(By.cssSelector("#add-to-bag-button"));

        System.out.println(sizeButton.isEnabled());

        WebElement size = driver.findElement(By.xpath("//button/span[.='XS']"));
        size.click();

        System.out.println(sizeButton.isEnabled());

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
