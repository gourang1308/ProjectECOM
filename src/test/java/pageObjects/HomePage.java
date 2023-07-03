package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BaseClass{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	//@FindBy(how = How.XPATH,using="(//a[@class='dropdown-toggle'])[2]") WebElement btn_myAccount;
	@FindBy(xpath="(//a[@class='dropdown-toggle'])[2]") WebElement btn_myAccount;
	@FindBy(how = How.XPATH,using="(//a[text()='Register'])[1]") WebElement btn_register;
	@FindBy(xpath="//a[text()='Login']") WebElement btn_login;
	@FindBy(xpath="//button[@type='button']") WebElement btn_home;
	//
	
	
	public void myAccount() {
		btn_myAccount.click();
	}
	
	public void register() {
		btn_register.click();
	}
	
	public void login() {
		btn_home.click();
		btn_login.click();
	}
	
	
	
	

}
