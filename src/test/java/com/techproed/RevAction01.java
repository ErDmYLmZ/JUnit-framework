package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class RevAction01 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void contextClickMethod(){
        /*
        Create a class: Actions1
        Create a test method : contextClickMethod() and test the following scenario:
        Given user is on the https://the-internet.herokuapp.com/context_menu When use Right clicks on the box
        Then verify the alert message is “You selected a context menu”
        Then accept the alert
         */
        Actions actions = new Actions(driver);
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement contextClick = driver.findElement(By.id("hot-spot"));
        actions.contextClick(contextClick).perform();

        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",alertText);

        driver.switchTo().alert().accept();
    }
}
