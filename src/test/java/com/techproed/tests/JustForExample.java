package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class JustForExample extends TestBase {

    @Test
    public void deneme(){
        driver.get("https://the-internet.herokuapp.com/windows");
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        Assert.assertEquals(driver.getTitle(), "The Internet");

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println(driver.getCurrentUrl());

        String windown1Hnadle = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String eachWindow : allWindows){
            if (!eachWindow.equals(windown1Hnadle)){
                driver.switchTo().window(eachWindow);
                System.out.println(driver.getCurrentUrl());
            }

        }
        Assert.assertEquals(driver.getTitle(), "New Window");

        System.out.println(driver.findElement(By.xpath("//h3")));

        String window2 = driver.getWindowHandle();
        for (String eachWindow : allWindows){
            if (!eachWindow.equals(window2)){
                driver.switchTo().window(eachWindow);
                System.out.println(driver.getCurrentUrl());
            }

        }
        Assert.assertEquals(driver.getTitle(), "The Internet");

    }



}
