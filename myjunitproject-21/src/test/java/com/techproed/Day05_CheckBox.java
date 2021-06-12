package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day05_CheckBox {

/*
Create a class : CheckBox
Create test method and complete the following task. 
Go to https://the-internet.herokuapp.com/checkboxes 
Locate the elements of checkboxes 
Then click on checkbox1 if box is not selected 
Then click on checkbox2 if box is not selected
Homework: Then verify that checkbox1 is checked.
 */

    //isSelected(); is used to check if a checkbox or radio button is CHECKED
    //if the button is checked,
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
    driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
    @Test
    public void checkBox(){
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        // Then clisck on checkbox if box is NOT selected
        if(!checkbox1.isSelected()){ //if checkbox1 is not selected
            checkbox1.click(); // Then click on it
        }

        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        if(!checkbox2.isSelected()){ //if checkbox1 is not selected
            checkbox2.click(); // Then click on it
        }
    }
    @After
    public void rearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
