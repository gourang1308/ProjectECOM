package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestcase.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC_02_LoginTest extends BaseTest{
	
	@Test
	public void login() throws InterruptedException {
		
		logger.info("*********** application is launched ********");
		HomePage hp = new HomePage(driver);
		Thread.sleep(5000);
		hp.login();
		try {
		logger.info("*********** enter login  details********");
		LoginPage lp = new LoginPage(driver);
		lp.email(rb.getString("email"));
		
		lp.password("pwd");
		Thread.sleep(7000);
		lp.login();
		
		
		Assert.assertEquals(lp.isElementVisible(), true,"login not succesful ");
		}
		catch(Exception e) {
			logger.error("test failed due to"+e);
			Assert.fail();
		}
	}

}
