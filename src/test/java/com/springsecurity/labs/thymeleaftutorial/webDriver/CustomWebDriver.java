package com.springsecurity.labs.thymeleaftutorial.webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomWebDriver {
    static WebDriver driver;
    private CustomWebDriver() {}

    public static WebDriver getDriver() {
        if(driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
