package com.rameshsoft.automation.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.rameshsoft.automation.utilities.DriverVariables;
import com.rameshsoft.automation.utilities.ScreenshotUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

abstract public class BaseEngine {
	private static WebDriver driver;
	static private String curDir;
	static private String tcName;
	static private ExtentReports extentReports;
	static private ExtentTest extentTest;
	
	@Parameters("browser")
	@BeforeSuite
	static public void openBrowser(@Optional("chrome")String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			curDir = System.getProperty("user.dir");
			System.setProperty(DriverVariables.chromeKey, DriverVariables.chromeValue);
			driver = new ChromeDriver();
			init();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty(DriverVariables.firefoxKey, DriverVariables.firefoxValue);
			driver = new FirefoxDriver();
			init();
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty(DriverVariables.ieKey, DriverVariables.ieValue);
			driver = new FirefoxDriver();
			init();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.ie.driver", "");
			driver = new FirefoxDriver();
			init();
		}
		
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "");
			driver = new FirefoxDriver();
			init();
		}
		
		else if (browser.equalsIgnoreCase("chrome-headless")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			System.setProperty("webdriver.ie.driver", "");
			WebDriver driver = new ChromeDriver(chromeOptions);
			init();
		}
		else if (browser.equalsIgnoreCase("headless")) {
			//HtmlunitDriver driver = new HtmlunitDriver();
			init();
		}
		
	}
	static private void init() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	@AfterSuite
	public void closeBrowser() {
		driver.close();
		extentReports.flush();
		extentReports.close();
	}
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static String getCurDir() {
		return curDir;
	}
	public static String getTcName() {
		return tcName;
	}
	@BeforeMethod
	public void beforeTCExecution(Method method) {
		tcName = method.getName();
		System.out.println("CURRENTLY EXECUTING TC NAME IS :" +tcName);
		extentTest = extentReports.startTest(tcName);
	}
	
	@AfterMethod
	public void afterTCExecution(ITestResult result) throws IOException {
		String tcName = result.getName();
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("TC IS PASSED: " +tcName);
			extentTest.log(LogStatus.PASS, tcName+" : is PASSED");
		}
		else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("TC IS FAILED: " +tcName);
			ScreenshotUtility.screenShot();
			extentTest.log(LogStatus.FAIL, tcName+" : is FAILED");
			extentTest.log(LogStatus.FAIL, result.getThrowable());
			System.out.println("REASON for FAILURE: " +result.getThrowable());;
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("TC IS SKIPPED: " +tcName);
			ScreenshotUtility.screenShot();
			System.out.println("REASON for SKIP: " +result.getThrowable());;
			extentTest.log(LogStatus.SKIP, tcName+" : is SKIPPED");
			extentTest.log(LogStatus.SKIP, result.getThrowable());
		}
		extentReports.endTest(extentTest);
	}
	
	@BeforeTest
	public void initialiseTCReport() {
		extentReports = new ExtentReports(getCurDir()+"\\Reports\\report.html");
	}
	@AfterTest
	public void generateTCReport() {
		
	}
	
	static public ExtentTest getExtentTest() {
		return extentTest;
	}
}
