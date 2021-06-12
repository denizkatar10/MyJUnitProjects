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

public class Day05_BeforeAfterMethods {
    /*
    Create a class: BeforeAfterMethods 
    Then create 3 different test methods using the following names. And Go to google. 
    titleTest =>Verify if google title = “Google” 
    imageTest => Verify if google image displays or not 
    gmailLinkTest => Verify if the Gmail link is displayed or not
    Close the browser after each test

    i need different test case so i will use 3 @Test annotation
     */

//      WHAT IS REPETING BEFORE EACH TEST CASE
//      @Before -> repeating parts

    WebDriver driver;
    @Before
    public void setUp(){
        //          Setting up chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//          putting 5 second wait on the driver. This will wait up to 5 seconds WHEN NEEDED
//          This will NOT wait IF NOT NEEDED
//          For example, if the page is slow, the driver will wait up to 5 seconds
//
//          IMPLICIT WAIT IS DYNAMIC WAIT AND WE SHOULD USE THIS.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//          Thread.sleep(5000); // This will wait 5 seconds even IF NOT NEEDED. It will always
//          put 5 seconds wait. THIS IS HARD WAIT THAT WE SHOULD NOT USE IN OUR CODE
        driver.get("https://www.google.com/");
    }

    @Test
    public void titleTest(){
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        driver.quit();
    }

    @Test
    public void imageTest(){
        WebElement googleImage = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
        Assert.assertTrue(googleImage.isDisplayed());

        driver.quit();
    }

    @Test
    public void gmailTest(){
        WebElement gmailLink = driver.findElement(By.xpath("(//*[@class='gb_f'])[1]"));
        Assert.assertTrue(gmailLink.isDisplayed());

        driver.quit();
    }

}
