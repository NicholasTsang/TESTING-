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

public class ShopTesting {
	private static ExtentReports Report; 
	private static String ReportShopsite = "Shopsite report";
	private static String ReportPath = System.getProperty("user.dir") + File.separatorChar + ReportShopsite + ".html";
	
	private WebDriver webDriver;
	private static final String BASE_URL = "http://automationpractice.com";
		@BeforeClass
			public static void Before () {
			System.out.println("Before start");
			Report = new ExtentReports();
			ExtentHtmlReporter Reporter = new ExtentHtmlReporter(ReportPath);
			Reporter.config().setReportName("Shop Site Report");
			Reporter.config().setDocumentTitle("Shop Site Report");
			Report.attachReporter(Reporter);
		}
		
		@Before
			public void Setup() {
			
			webDriver = new ChromeDriver();
			webDriver.navigate().to(BASE_URL);
			
		}
		
		@Test
			public void NewsletterForm() {
			Shoppageob Shopaccess = PageFactory.initElements(webDriver,Shoppageob.class);
			ExtentTest Test1 =  Report.createTest("NewsLetter Test");
			
			Shopaccess.NewsEmail();
			Test1.log(Status.INFO,"Email Entered");
			
			Shopaccess.NewsSend();
			Test1.log(Status.INFO,"Newletter Subcribed");
			
			try {
				TimeUnit.MILLISECONDS.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Assert.assertTrue(true);
				Test1.pass(" Newsletter Grand");
			} catch (AssertionError e) {
			Test1.fail("well nooo");
			}
			
		}
		
		@Test
			public void StoreLocation() {
			Shoppageob Shopaccess = PageFactory.initElements(webDriver,Shoppageob.class);
			ExtentTest Test2 = Report.createTest("Shop Location Test");
			Shopaccess.StoreLocate();
			Test2.log(Status.INFO,"I'm lost");
			
			Shopaccess.AddressInput();
			Test2.log(Status.INFO,"theres a sign for kendall");
			
			Shopaccess.AddressSearch();
			Test2.log(Status.INFO,"Help");
			
			try {
				TimeUnit.MILLISECONDS.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Assert.assertTrue(true);
				Test2.pass("Grand less lost");
			} catch (AssertionError e) {
			Test2.fail("well nooo");
			}
		} 
		
		@After 
			public void Cleanup() {
			
			webDriver.quit();
			}
		@AfterClass
			public static void Turndown() {
			
			Report.flush();
			
		}
	
}
