package com.techproed;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HomeWork2 {
    WebDriver driver;
    Faker faker;
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(500);
    }
    @Test
    public void SignIn() throws InterruptedException {
        Faker faker = new Faker();
        WebElement signIn = driver.findElement(By.xpath("//a[@class='login']"));
        signIn.click();
        ///////////////////////////////////////////////////////////////////
        //Create a account
        WebElement createAccount = driver.findElement(By.id("email_create"));
        createAccount.sendKeys(faker.name().firstName()+ "@gggg.com");
        createAccount.submit();
        /////////////////////////////////////////////////////////////////
        // Gender option
        //**driver.findElement(By.id("id_gender1")).click();
        Thread.sleep(2000);
        WebElement yourTitle = driver.findElement(By.xpath("(//input[@value='1'])"));
        yourTitle.click();
        //////////////////////////////////////////////////////////////////
        //First Name
        Thread.sleep(500);
        driver.findElement(By.id("customer_firstname")).sendKeys(faker.name().firstName());
        //Last Name
        Thread.sleep(500);
        driver.findElement(By.id("customer_lastname")).sendKeys(faker.name().lastName());
        //Password
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(faker.phoneNumber().cellPhone());
        //Day
        Thread.sleep(500);
        WebElement days = driver.findElement(By.id("days"));
        Select day = new Select(days);
        day.selectByValue("10");
        //Month
        Thread.sleep(500);
        WebElement months = driver.findElement(By.id("months"));
        Select month = new Select(months);
        month.selectByValue("10");
        //Year
        Thread.sleep(500);
        WebElement years = driver.findElement(By.name("years"));
        Select year = new Select(years);
        year.selectByValue("1995");
        //First NAME
        driver.findElement(By.id("firstname")).sendKeys(faker.name().firstName());
        //Last Name
        driver.findElement(By.id("lastname")).sendKeys(faker.name().lastName());
        //Adress
        driver.findElement(By.name("address1")).sendKeys(faker.address().fullAddress());
        //City
        driver.findElement(By.name("city")).sendKeys(faker.address().city());
        //State
        WebElement states = driver.findElement(By.id("id_state"));
        Select state = new Select(states);
        state.selectByValue("30");
        //Zip Code
        driver.findElement(By.name("postcode")).sendKeys("08536");
        //mobile Phone
        driver.findElement(By.name("phone_mobile")).sendKeys(faker.phoneNumber().cellPhone());
        //Register
        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
        ////////////////////////////////////////////////////////////////////////////////////////////
        WebElement myaccount = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(myaccount.getText().contains("MY ACCOUNT"));
        System.out.println("We are all good");



    }



}
