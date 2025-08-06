package com.inetBanking.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver rdriver) {

		this.driver = rdriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "uid")
	WebElement txtUserName;

	@FindBy(xpath = "//td/input[@name='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='LOGIN']")
	WebElement btnlogin;
	
	
	public void setUserName(String uname) {
		
		txtUserName.sendKeys(uname);
		
		
		
	}
	
	
	public void setPassword(String password) {
		
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		
		btnlogin.click();
		
	}
	
	

}
