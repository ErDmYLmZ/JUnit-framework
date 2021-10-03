package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day05_CheckBox {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void checkbox(){
//        Go to https://the-internet.herokuapp.com/checkboxes
//        Locate the elements of checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //        Then click on checkbox1 if box is NOT selected
        // isSelected() is used to check if checkbox or radio button is checked or unchecked
        // returns true if checkbox is already selected. Returns false if it is not selected
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }
        //        Then click on checkbox2 if box is not selected
        if(!checkbox2.isSelected()){
            checkbox2.click();
        }

        //        Then verify that checkbox1 and checkbox 2 is checked.
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());


    }
}
