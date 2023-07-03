package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import baseTestcase.BaseTest;
import pageObjects.*;


public class TC01_Registratio extends BaseTest {
	
	
	@Test
	public void register() throws InterruptedException{
		
		//setup("https://demo.opencart.com/");
		logger.info("*********** application is launched ********");
		HomePage hp = new HomePage(driver);
		Thread.sleep(5000);
		hp.myAccount();
		logger.info("*********** navigate to registration page  ********");
		RegistrationPage rp = new RegistrationPage(driver);
		hp.register();
		logger.info("*********** enter registration details********");
		rp.firstName(randString(5));
		rp.lastName(randString(4));
		rp.email(randString(2)+"@gmail.com");
		rp.pwd("123admin");
		scrollDown();//scrollDown function 
		
		Thread.sleep(5000);
		rp.chkPrivatePolicy();//element intercepted  javaScript scroll function
		                      // use wait till the element is visible (explicit wait )
		                      //use actions class 
		
		rp.btnContinue();
		logger.info("*********** registration is successful  ********");
	
	}

}
