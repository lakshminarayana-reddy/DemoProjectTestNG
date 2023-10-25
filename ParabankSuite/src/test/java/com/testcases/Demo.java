package com.testcases;

import org.testng.annotations.Test;

import com.driverscript.TestBase;

public class Demo extends TestBase {
  @Test(groups= {"Smoke"})
  public void testOne() {
	  System.out.println("TC1"+Thread.currentThread().getId());
  }
  @Test(groups= {"Smoke"})
  public void testTwo() {
	  System.out.println("TC2"+Thread.currentThread().getId());
  }
  @Test(groups= {"Smoke"})
  public void testThree() {
	  System.out.println("TC3"+Thread.currentThread().getId());
  }
  @Test(groups= {"Smoke"})
  public void testFour() {
	  System.out.println("TC4"+Thread.currentThread().getId());
  }
  @Test(groups= {"Smoke"})
  public void testFive() {
	  System.out.println("TC5"+Thread.currentThread().getId());
  }
  @Test(groups= {"Smoke"})
  public void testSix() {
	  System.out.println("TC6"+Thread.currentThread().getId());
  }
  @Test(groups= {"Smoke"})
  public void testSeven() {
	  System.out.println("TC7"+Thread.currentThread().getId());
  }
  @Test(groups= {"Smoke"})
  public void testEight() {
	  System.out.println("TC8"+Thread.currentThread().getId());
  }
  @Test(groups= {"Smoke"})
  public void testNine() {
	  System.out.println("TC9"+Thread.currentThread().getId());
  }
  @Test(groups= {"Smoke"})
  public void testTen() {
	  System.out.println("TC10"+Thread.currentThread().getId());
  }
  
  
}
