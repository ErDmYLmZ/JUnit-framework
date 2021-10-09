package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day08_FileDownloadTest extends TestBase {
    @Test
    public void fileDownloadTest(){
        //Create a class:FileDownloadTest
        //downloadTest()
        //In the downloadTest() method, do the following test:
        //Go to https://the-internet.herokuapp.com/download

        driver.get("https://the-internet.herokuapp.com/download");
        //Download flower.png file

        driver.findElement(By.linkText("flower.jpeg")).click();
        //Then verify if the file downloaded successfully




    }
}
