package baseTestcase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

	

public class BaseTest {
	
	 protected static WebDriver driver;	
	JavascriptExecutor js;
	protected static Logger logger;
	protected static ResourceBundle rb;
	
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) {
		logger = LogManager.getLogger(this.getClass());
		rb = ResourceBundle.getBundle("config");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		//driver=WebDriverManager.chromedriver().capabilities(null).create();
		if(br.toLowerCase().trim().equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(br.toLowerCase().trim().equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			Assert.fail("provide the correct browser");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get(rb.getString("url"));
		driver.manage().window().maximize();
		
		
	}
	
	//@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String randString(int num) {
		return RandomStringUtils.randomAlphabetic(num);
		
	}
	
	public String randNum(int num) {//randNum
		
		return RandomStringUtils.randomNumeric(num);
	}
	
	
     public String randAlpaNumeric(int num1,int num2) {
		
		return (RandomStringUtils.randomNumeric(num1)+RandomStringUtils.randomAlphabetic(num2));
	}
     
     public void scrollDown() {
    	 js = (JavascriptExecutor)driver;
    	 js.executeScript("window.scrollBy(950, 800)");//859, 741
    	 
     }
     
     
     
     public String takeScreeshot(String tname) {
    	 SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
    	 Date dt = new Date();
    	 String timeStamp = df.format(dt);
    	// String timeStamp2 = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    	 
    	 TakesScreenshot ts = (TakesScreenshot)driver;
    	 File src=ts.getScreenshotAs(OutputType.FILE);
    	 String destination = "C:\\Users\\GourangVinodWeginwar\\eclipse-workspace\\ProjectECOM\\screenShots"+tname+"_"+timeStamp+".png";
    	 try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	 return destination;
    	 
     }
	
    
	
	


}
