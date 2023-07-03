package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage extends BaseClass{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//text fields 
	
	@FindBy(how =How.NAME, using="firstname") WebElement txt_firstName;
	@FindBy(how =How.NAME, using="lastname") WebElement txt_lastName;
	@FindBy(how =How.NAME, using="email") WebElement txt_email;
	@FindBy(how =How.NAME, using="password") WebElement txt_password;
	
	//check box   //input[@type='checkbox']
	@FindBy(xpath="(//input[@class='form-check-input'])[3]") WebElement Chk_PrvPolicy;
	
	//click on continue 
	@FindBy(how =How.XPATH, using="//button[@type='submit']") WebElement btn_continue;
	
	public void firstName(String val) {
		txt_firstName.sendKeys(val);
	}
	
	public void lastName(String val) {
		txt_lastName.sendKeys(val);
	}
	
	public void email(String val) {
		txt_email.sendKeys(val);
	}
	
	public void pwd(String val) {
		txt_password.sendKeys(val);
	}
	
	public void chkPrivatePolicy( ) {
		Chk_PrvPolicy.click();;
	}
	
	public void btnContinue( ) {
		btn_continue.click();;
	}
	
	

}
