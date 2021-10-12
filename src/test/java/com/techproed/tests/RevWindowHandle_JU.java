package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RevWindowHandle_JU {
    /*
        Create a new Class Tests package: Day08_WindowHandleExample Method name:windowHandle
        Given user is on the https://the-internet.herokuapp.com/windows Then user verifies the text : “Opening a new window”
        Then user verifies the title of the page is “The Internet”
        When user clicks on the “Click Here” button
        Then user verifies the new window title is “New Window” Then user verifies the text: “New Window”
        When user goes back to the previous window and then verifies the title : “The Internet”
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void windowHandle(){
    driver.get("https://the-internet.herokuapp.com/windows");
    WebElement window1Heading = driver.findElement(By.xpath("//*[.='Opening a new window']"));
    Assert.assertEquals("Opening a new window", window1Heading.getText());

    String Window1Title = driver.getTitle();
    Assert.assertEquals("The Internet",Window1Title);

    driver.findElement(By.linkText("Click Here")).click();

    String window1Handle =  driver.getWindowHandle();
        System.out.println(window1Handle);

        Set<String>allWindowHandles = driver.getWindowHandles();

        for (String element:allWindowHandles){
        if (!element.equals(window1Handle)){
            driver.switchTo().window(element);
            break;
        }}
        Assert.assertEquals("New Window", driver.getTitle());
        String window2handle = driver.getWindowHandle();
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet", driver.getTitle());

        }

    @After
    public void tearDown(){
        driver.close();
    }
}
