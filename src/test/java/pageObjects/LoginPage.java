package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BaseClass {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how =How.NAME, using="email") WebElement txt_email;
	@FindBy(how =How.NAME, using="password") WebElement txt_pwd;
	@FindBy(how = How.XPATH,using="(//button[@type='submit'])[2]") WebElement btn_login;
	@FindBy(how = How.XPATH,using="//div[@class='container']/p") WebElement login_verify;
	
	
	
	public void email(String val) {
		txt_email.sendKeys(val);
	}
	
	public void password(String val) {
		txt_pwd.sendKeys(val);
	}
	public void login() {
		btn_login.click();
	}
	
	//
	public boolean isElementVisible() {
		
		if(login_verify.isDisplayed()) {
			return (true);
		}
		else {
			return false;
		}
		
	}
	
	
	

}
