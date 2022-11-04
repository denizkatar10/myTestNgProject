package com.techproed.tests;
import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.security.Key;
import java.util.concurrent.TimeUnit;

public class Day07_TestBaseDemo {
    //    We are using TestBase
//    BeforeMethod and AfterMethod automatically runs
//    This test class is now cleaner
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
//        Create a class:TestBaseDemo
//        Create two methods: test1, test2
//        test1 search “porcelain teapot” on google
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("porcelain teapot"+ Keys.ENTER);
//        Then verify page contains “porcelain teapot”
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }
    //        test2 search “porcelain teapot” on amazon
//        Then verify page contains “porcelain teapot”
    @Test
    public void test2(){
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot"+Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }
}