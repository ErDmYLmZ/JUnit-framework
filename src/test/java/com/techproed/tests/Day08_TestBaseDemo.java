package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Day08_TestBaseDemo extends TestBase {
    //Since i have before after methods in the TestBase, don't use them in here
    //This is a TEST CLASS and will have only @Test Method

    @Test
    public void test1(){
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("(//div[@class='jyfHyd'])[2]")).click();
        driver.findElement(By.name("q")).sendKeys("porcelain teapot" + Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));

    }
    @Test
    public void test2(){
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot" + Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }
}
