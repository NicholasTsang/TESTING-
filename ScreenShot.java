package testingweek;

 import org.apache.commons.io.FileUtils; 
 import org.openqa.selenium.OutputType; 
 import org.openqa.selenium.TakesScreenshot; 
 import org.openqa.selenium.WebDriver; 
 
 
 import java.io.File; 
 import java.io.IOException; 
 
 
 public class ScreenShot {  
	 	
     public static String take(WebDriver webDriver) throws IOException { 
         File DemoFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE); 
         String Sdemosite ="Demosite Screenshott";
         String pathDemo = System.getProperty("user.dir") + File.separatorChar + Sdemosite +".jpg"; 
         FileUtils.copyFile(DemoFile, new File(pathDemo)); 
         System.out.println("File Saved at: " + pathDemo); 
         return pathDemo; 
     } 
 } 
