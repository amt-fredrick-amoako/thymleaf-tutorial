package com.springsecurity.labs.thymeleaftutorial.uiTest;

import com.springsecurity.labs.thymeleaftutorial.webDriver.CustomWebDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UIInteractionTest {
    private WebDriver driver;
    private final String baseUrl = "http://localhost:9000";

    public UIInteractionTest() {
        driver = CustomWebDriver.getDriver();
    }

    @BeforeAll
    static void setUp(){
        CustomWebDriver.getDriver().manage().window().maximize();
        CustomWebDriver.getDriver().get("http://localhost:9000");
    }

    @Test
    void testHomePage(){
        this.driver.get(baseUrl);
        WebElement jumbotronElement = driver.findElement(By.cssSelector(".display-3"));
    }

    @Test
    void testPlayersPage(){
        this.driver.get(baseUrl);
        WebElement linkElement = driver.findElement(By.xpath("//a[contains(@class, 'nav-link') and contains(text(), 'Players')]"));
        linkElement.click();
    }

    @AfterAll
    static void tearDown(){
        CustomWebDriver.getDriver().quit();
    }
}
