package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import automation.constant.CT_Account;


public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver ;
	}
	
	public void LoginFunction (String email, String pass ) throws InterruptedException  
	{
		WebElement textLogin = driver.findElement(CT_Account.TEXT_EMAIL);
		if(textLogin.isDisplayed()) 
		{
			textLogin.sendKeys(email);
		}
		
		WebElement textPass = driver.findElement(CT_Account.TEXT_PASSWORD);
		if(textPass.isDisplayed())
		{
			textPass.sendKeys(pass);
		} 
		Thread.sleep(5000);
		WebElement buttonDangNhap = driver.findElement(CT_Account.BUTTON_LOGIN);
		if(buttonDangNhap.isDisplayed())
		{
			buttonDangNhap.click();
		}
		
	}

	public static boolean isErrorMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}
	

