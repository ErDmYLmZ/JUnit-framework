package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RevNumberOfIframes {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }
    @Test
    public void Test07(){
//        List<WebElement> number = driver.findElements(By.tagName("iframe"));
//        int a = number.size();
//        System.out.println(a);
        System.out.println(driver.findElements(By.tagName("iframe")).size());
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
