package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseTestcase.BaseTest;

public class ExtentsReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	
	public void onStart(ITestContext context) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String repoName = "Reports"+timeStamp+".html";
		
		String filepath = "C:\\Users\\GourangVinodWeginwar\\eclipse-workspace\\ProjectECOM\\reports\\"+repoName;
		sparkReporter =new ExtentSparkReporter(filepath);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("testingDemo");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("computer", "Dell");
		extent.setSystemInfo("os", System.getProperty("os.name"));
		extent.setSystemInfo("user", System.getProperty("user.name"));
		extent.setSystemInfo("Application", "OpenCart");
		extent.setSystemInfo("ENV", "QA");
		
		
	}

	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "test got passed"+result.getName());
		
	
	}

	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "test got Failed"+result.getName());
		test.log(Status.FAIL, "test got Failed reason"+result.getThrowable().getMessage());
		try {
			
			String imgPath=new BaseTest().takeScreeshot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void onTestSkipped(ITestResult result) {
	
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "test got Skipped"+result.getName());
	}


	
	public void onFinish(ITestContext context) {
		extent.flush();
		
	
	}
	

}
