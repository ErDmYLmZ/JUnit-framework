
package com.techproed.tests;
        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.junit.After;
        import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class Test04_JU {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //ADDING IMPLICIT WAIT: Implicit wait is DYNAMIC WAIT.
        //WAIT UP TO 30 second WHEN NEEDED
        //This means, if driver needs 1 seconds wait, then wait will be ONLY 1 seconds
        //Why wait is needed?
        //page is slow due to lots of image, videos, iframe,...
        //internet is slow
        //database is slow
        //local computer is slow
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void cssTest() {
        driver.get("https://www.amazon.com");
        driver
                //.findElement(By.xpath("//input[@name='q']"))
                .findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("1234");
                //.findElement(By.cssSelector("css=input#Email").sendKeys("1234");

    }
    @After
    public void tearDown(){
        driver.close();

    }
}