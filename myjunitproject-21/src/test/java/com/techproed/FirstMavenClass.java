package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstMavenClass {
    public static void main(String[] args) {
        //NOTE: We no longer use System.setProperties for calling the driver
        //Step 1:
        WebDriverManager.chromedriver().setup();
        //initially, we see WebDriverNamager is red, because we need dependency
        //we use mvnrepository.com to get maven dem=pen

        //Step 2:
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.quit();
    }
}
