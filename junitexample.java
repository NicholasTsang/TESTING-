package testingweek;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class junitexample {
	
	private WebDriver webDriver;
	private static final String BASE_URL = "https://www.qa.com";

	@BeforeClass
	
	public static void init() {
		
		System.out.println("Before Class");
	}
	
	@Before
	public void Setup() {
		System.out.println("Before");
		webDriver = new ChromeDriver();
		webDriver.navigate().to(BASE_URL);
	
	}
	
	@Test
	
	public void Internet(){
		
		try {
			TimeUnit.MILLISECONDS.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Running Test");
		WebElement searchbar = webDriver.findElement(By.cssSelector("#select2-chosen-2"));
		searchbar.sendKeys("the Shafeeq");
	
	}
	
	@After
	
	public void Cleanup(){
		System.out.println("After");
		webDriver.quit();
	}
	
	@AfterClass
	
	public static void turndown(){
		System.out.println("Good Ending");
	
	}
	
}

