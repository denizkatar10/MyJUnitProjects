package com.techproed;
import org.junit.*;

public class Day04_FirstJUnitClass {
    //    We no longer need MAIN METHOD
//    @Test creates a test case.
//    @Ignore skips test case
// setUp -> tearDown -> test1 -> test2(SKIPPED) -> test3
//    @After runs after EACH METHOD
//    @Before runs before EACH METHOD
    @Before
    public void setUp(){
        System.out.println("@Before runs before each @Test method");
    }
    @Test
    public void test1() {
        System.out.println("Test Case 1");
    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("Test Case 2");
    }
    @Test
    public void test3(){
        System.out.println("Test Case 3");
    }
    @After
    public void tearDown(){
        System.out.println("@After runs after each @Test method");
    }

    // ASSERTIONS: If ecpected = actual

    @Test
    public void assertion(){
        //1. Assert.assertTrue(boolean); if statemnt = True, it will be PASS, otherwise FAIL
        //2. Assert.assertFalse(); if statement = False = false, then PASS, otherwise FAIL
        Assert.assertTrue(3==3);
        Assert.assertFalse(3==4);
        Assert.assertTrue("junit".contains("j"));

        //3. Assert.assertEquals("expected", "actual"); if expected = actual, then PASS, otherwise FAIL
        Assert.assertEquals("junit", "j");


    }


}