package com.sw.examples;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleDropdown {
    WebDriver driver;

    @Test
    public void selectValueFromList(){
        driver = new ChromeDriver();
        driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");


        WebElement countyDropDown = driver.findElement(By.name("CompanyCountry"));
        Select select = new Select(countyDropDown);

        select.selectByValue("PE");
        select.selectByIndex(5);
        select.selectByVisibleText("Northern Mariana Is");

        String firstOption = select.getFirstSelectedOption().getText();
        System.out.println(firstOption);

        int number = select.getOptions().size();
        System.out.println(number);

    }
}
