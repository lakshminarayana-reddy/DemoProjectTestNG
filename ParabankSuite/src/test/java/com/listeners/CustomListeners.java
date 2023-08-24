package com.listeners;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.driverscript.TestBase;
import com.utilites.TestUtil;

public class CustomListeners extends TestBase implements ITestListener{
	Date d = new Date();
	String fileName = "Results"+d.toString().replace(':','_').replace(' ', '_')+".html";
	ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\Reports\\"+fileName);
	ExtentReports extent = new ExtentReports();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		extent.attachReporter(htmlReport);
		Reporter.log("TestCase started is "+result.getName());
		test=extent.createTest(result.getTestClass().getName()+"@TestCase is"+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "TestCase :"+methodName.toUpperCase()+ "IS PASSED";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.log(Status.PASS, m);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		TestUtil.captureScreenshot();
		String methodName = result.getMethod().getMethodName();
		String logText ="TestCase :"+methodName.toUpperCase()+ "IS FAILED";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.log(Status.FAIL, m);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText ="TestCase :"+methodName.toUpperCase()+"IS SKIPPED";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.log(Status.SKIP, m);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		if(extent!=null)
			extent.flush();
	}
}
