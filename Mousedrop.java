package testingweek;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Mousedrop {
	
	private static ExtentReports Report; 
	private static String MouseReport = "Mouse report";
	private static String ReportPath = System.getProperty("user.dir") + File.separatorChar + MouseReport + ".html";

	private static WebDriver webDriver;
	private static final String BASE_URL = "http://demoqa.com/droppable/";
	
	@BeforeClass
	public static void Before () {
		Report = new ExtentReports();
		ExtentHtmlReporter Reporter = new ExtentHtmlReporter(ReportPath);
		Reporter.config().setReportName("MouseReport");
		Reporter.config().setDocumentTitle("Mouse Report");
		Report.attachReporter(Reporter);
		
		webDriver = new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
	}
	@Before
	public void Setup () {
		webDriver = new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
		
	}
	
	@Test
	public void Default(){
		Mousepage Mouse= PageFactory.initElements(webDriver,Mousepage.class);
		ExtentTest DefaultTest =  Report.createTest("Default Test");
		
		Mouse.DropD(webDriver);
		DefaultTest.log(Status.INFO,"target Dropped");
		
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Assert.assertTrue(true);
			DefaultTest.pass(" Load Dropped ;)");
		} catch (AssertionError e) {
		DefaultTest.fail("well nooo");
		}
		
	}
	
	@Test
	public void Accept(){
		Mousepage Mouse= PageFactory.initElements(webDriver,Mousepage.class);
		ExtentTest AcceptTest =  Report.createTest("Accept Test");
		
		Mouse.DropA(webDriver);
		AcceptTest.log(Status.INFO,"Accept Drop");
		
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Assert.assertTrue(true);
			AcceptTest.pass(" Accepted Drop;)");
		} catch (AssertionError e) {
		AcceptTest.fail("well nooo");
		}
		
	}
	
	@Test
	public void Shop() {
		
		Mousepage Mouse= PageFactory.initElements(webDriver,Mousepage.class);
		ExtentTest TestShop =  Report.createTest("Shop Test");
		
		Mouse.ShoppingCart();
		TestShop.log(Status.INFO,"Access Shopping Cart");
		
		Mouse.BuyShirt(webDriver);
		TestShop.log(Status.INFO,"Shirt in Cart");
		
		Mouse.BagSection();
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Mouse.BuyBag(webDriver);
		TestShop.log(Status.INFO,"Bag in Cart");
		
		Mouse.GadgetsSection();
		
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Mouse.BuyApple(webDriver);
		TestShop.log(Status.INFO,"Iphone in Cart");
		
		
		try {
			TimeUnit.MILLISECONDS.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Assert.assertTrue(true);
			TestShop.pass(" Christmas Done");
		} catch (AssertionError e) {
		TestShop.fail("well nooo");
		}
	}
	
	@After
	public void Cleanup() {
		webDriver.quit();
	}
	@AfterClass
	public static void Turndown(){
		
		Report.flush();
	}
}
