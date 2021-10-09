package com.techproed.homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDropdown {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }
    @Test
    public void dropdownTest() throws InterruptedException {
    WebElement amazonDropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(amazonDropdown);
        String firstOption =select.getFirstSelectedOption().getText();
        Assert.assertEquals("First option does not match!","All Departments", firstOption);
        Thread.sleep(2000);


        select.selectByIndex(6);
        String sixtOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Computers",sixtOption);

        List<WebElement> allOptions = select.getOptions();
        for (WebElement printAllOptions: allOptions) {
            System.out.println(printAllOptions.getText());
        }System.out.println("Total number of the options: "+ allOptions.size());


        select.selectByVisibleText("Automotive");
        String isAutomotive = select.getFirstSelectedOption().getText();
        Assert.assertTrue(isAutomotive.contains("Automotive"));

        if(isAutomotive.contains("Automotive")){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
/*
 List<String> sortedOptionsString = options.stream().map(WebElement::getText).sorted().collect(Collectors.toList());

        if(optionsString.equals(sortedOptionsString)){
            System.out.println("Dropdown is in alphabetical order");
        }else{
            System.out.println("Dropdown is NOT in alphabetical order");
        }
    }
 */
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
