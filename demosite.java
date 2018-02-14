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

public class demosite {
	private static ExtentReports report; 
	private ExtentTest test; 
	private String Reportdemosite = "demosite report";
	private String reportPath = System.getProperty("user.dir") + File.separatorChar + Reportdemosite + ".html";
	private String SpreadPath = System.getProperty("user.home") + File.separatorChar + "Desktop" + File.separatorChar + "spreadsheet" + File.separatorChar + "random.xlsx";
	private WebDriver webDriver;
	private static final String BASE_URL = "http://asp.thedemosite.co.uk/index.asp";

	@BeforeClass
	
	public static void init() {
		
		System.out.println("Before Class");
		System.out.println( System.getProperty("user.home") );
	}
	
	@Before
	public void Setup() {
		report = new ExtentReports();
		ExtentHtmlReporter Reporter = new ExtentHtmlReporter(reportPath);
		Reporter.config().setReportName("ReportDemosite");
		Reporter.config().setDocumentTitle("Demosite");
		report.attachReporter(Reporter);
		test = report.createTest("Demosite test");
		
		System.out.println("Before");
		webDriver = new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
		
	
	}
	
	@Test 
	public void navi() {	
		
		pageobject1 demosite = PageFactory.initElements(webDriver,pageobject1.class);
		SpreadSheetReader SpreadSheetReader= new SpreadSheetReader (SpreadPath);
		String row = (SpreadSheetReader.readRow(1,"Example1")).get(0);
		System.out.println(row);
	
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		demosite.add_user();
		test.log(Status.INFO,"demosite info");
		
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.INFO,"demosite info");
		
		demosite.addusername();
		demosite.addpassword();
		demosite.saving();
		
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.INFO,"demosite info");
		
		demosite.logingin();
		demosite.logingname();
		demosite.logingpass();
		demosite.Logingbutt();
		
		try {
			TimeUnit.MILLISECONDS.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.INFO,"demosite info");
		//test.fail("Nooooooooooo");
		
		try {
			Assert.assertTrue(true);
			test.pass("Yeessssssss");
		} catch (AssertionError e) {
		test.fail("well nooo");
		}
		
		
	}
	
	
	@After
	public void cleanup() {
		
		webDriver.quit();
		
	}

	@AfterClass
	public static void turndown() {
		report.flush();
	}
}
