package com.techproed;

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

public class Day06_DropDown {

    /*
    //Create a class name : DropDown
//Go to https://the-internet.herokuapp.com/dropdown
//1.Create method selectByIndexTest and Select and Print Option 1 using index
//2.Create method selectByValueTest and Select and Print Option 2 by value
//3.Create method selectByVisibleTextTest and Select and Print Option 1 value by visible text
//4.Create method printAllTest Print all dropdown value
//5.Create method printFirstSelectedOptionTest Print first selected option
//6.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 4 elements in the dropdown.

     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void selectByIndexTest() throws InterruptedException {
//        Step 1: Locating the dropdown element
        WebElement dropdownElement= driver.findElement(By.id("dropdown"));
//        Step 2: use Select class to control the dropdown object
        Select select = new Select(dropdownElement);
//        Step 3: I can now select any option by 3 different ways
//        selectByValue, selectByIndex, selectByVisibleText()
        //1.Select and Print Option 1 using index
        Thread.sleep(5000);
        select.selectByIndex(1);
        Thread.sleep(5000);
    }
    @Test
    public void selectByValueTest() throws InterruptedException {
        //2.Create method selectByValueTest Select and Print Option 2 by value
        WebElement dropdownElement= driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);
        Thread.sleep(5000);
        select.selectByValue("2");
        Thread.sleep(5000);
    }
    @Test
    public void selectByVisibleText(){
//3.Create method selectByVisibleTextTest and Select and Print Option 1 value by visible text
        WebElement dropdownElement= driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        select.selectByVisibleText("Option 1");

    }
    @Test
    public void printAll(){
//4.Create method printAllTest Print all dropdown value
        WebElement dropdownElement= driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> allOptions = select.getOptions();
        // getOptions() returns all options as List<WebElement>
        for (WebElement each : allOptions){
            System.out.println(each.getText());
        }
    }
    @Test
    public void printFirstSelecedOptionTest() {
//5.Create method printFirstSelectedOptionTest Print first selected option
        WebElement dropdownElement= driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);
        String selectedOption = select.getFirstSelectedOption().getText();
        //getFirstSelectedOption() returns selected option as WebElement
        System.out.println(selectedOption);
    }
    @Test
    public void dropdownSizeTest(){
//6.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 4 elements in the dropdown.
        WebElement dropdownElement= driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);
        int numberOfOptions = select.getOptions().size();
        Assert.assertEquals("Expected is Not Equal Actual",4, numberOfOptions);
    }
    @After
    public void tearDown(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }






}
