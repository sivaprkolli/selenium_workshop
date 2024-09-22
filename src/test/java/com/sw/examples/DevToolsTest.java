package com.sw.examples;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DevToolsTest {

    @Test
    public void setToMobileView(){
        ChromeDriver chromeDriver = new ChromeDriver();
        DevTools devTools = chromeDriver.getDevTools();

        devTools.createSession();

        Map map = new HashMap()
        {
            {
                put("width", 500);
                put("height", 1000);
                put("mobile", true);
            }
        };

        chromeDriver.executeCdpCommand("Emulation.setDeviceMetricsOverride", map);
        chromeDriver.get("https://twitter.com/");

    }
}
