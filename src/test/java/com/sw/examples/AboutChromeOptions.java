package com.sw.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class AboutChromeOptions {
    WebDriver driver;
    @Test
    public void useChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("121");
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.addArguments("--headless");
        chromeOptions.enableBiDi();
        Map map = new HashMap();
        map.put("deviceName", "iPhone SE");
        chromeOptions.setExperimentalOption("mobileEmulation",map);
        driver = new ChromeDriver(chromeOptions);
         driver.get("https://cacert.org/");
        driver.get("https://www.saucedemo.com/");
        driver.quit();
    }
}
