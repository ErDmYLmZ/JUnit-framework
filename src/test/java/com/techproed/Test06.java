package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test06 {
    /*
    Create a class: IFrameTest
    Create a method: iframeTest
    Go to https://the-internet.herokuapp.com/iframe
    Verify the Bolded text contains “Editor”
    Locate the text box
    Delete the text in the text box
    Type “This text box is inside the iframe”
    Verify the text Elemental Selenium text is displayed on the page
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void test06(){
       // Verify the Bolded text contains “Editor”
    String editorCheck =driver.findElement(By.xpath("//h3")).getText();
    Assert.assertTrue(editorCheck.contains("Editor"));

    // driver.switchTo().frame(0);
    //driver.switchTo().frame("mce_0_ifr");
      WebElement testt = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(testt);



    //WebElement textFinder =driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        WebElement textbox=driver.findElement(By.xpath("//p"));
    textbox.clear();
    textbox.sendKeys("This text box is inside the iframe");

    driver.switchTo().parentFrame();
    Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());

    }

    @After
    public void tearDown(){
        driver.close();
    }
}
