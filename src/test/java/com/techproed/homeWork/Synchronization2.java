package com.techproed.homeWork;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization2 extends TestBase {

//        Create a class:Synchronization2.
//        Create a method: isEnabled
    @Test
    public void isEnabled(){
//        Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        Click enable Button
        driver.findElement(By.xpath("//*[.='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement enabledText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

//        And verify the message is equal to “It's enabled!”
        Assert.assertTrue(enabledText.getText().equals("It's enabled!"));

//        And verify the textbox is enabled (I can type in the box)
        WebElement textboxIsEnabled = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textboxIsEnabled.isEnabled());

//        And click on Disable button
        driver.findElement(By.xpath("//*[.='Disable']")).click();
        WebElement disabledText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

//        And verify the message is equal to “It's disabled!”
        Assert.assertTrue(disabledText.getText().equals("It's disabled!"));

//        And verify the textbox is disabled (I cannot type in the box)
        WebElement textboxIsDesabled = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textboxIsDesabled.isEnabled());
//
}
}
