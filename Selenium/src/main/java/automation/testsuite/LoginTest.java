package automation.testsuite;

import static org.testng.Assert.*;
import org.testng.annotations.*;
import org.openqa.selenium.By;

import automation.common.CommonBase;
import automation.constant.CT_PageYURL;
import automation.page.LoginPage;



public class LoginTest extends CommonBase{
	@BeforeMethod
	public void openBrowser()
	{
		driver = initFireFoxDriver(CT_PageYURL.aladaURL);
	}
	
	@Test(priority = 1) 
	public void LoginSuccessFully() throws InterruptedException 
	{
		LoginPage Login = new LoginPage(driver);
		Login.LoginFunction("d.trihoang021102@gmail.com", "Boprodo123@");
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());
	}
	
	@Test(priority = 2) 
	public void loginFail_InvalidEmail()throws InterruptedException 
	{
		LoginPage Login = new LoginPage(driver);
		Login.LoginFunction("d.trihoang0211022@gmail.com", "Boprodo123@");
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());
	}
	
	@Test(priority = 3) 
	public void loginFail_InvalidPassword()throws InterruptedException 
	{
		LoginPage Login = new LoginPage(driver);
		Login.LoginFunction("d.trihoang021102@gmail.com", "BBBBoprodo123@");
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());
	}
	
	@Test(priority = 4) 
	public void loginFail_InvalidEmailAndPassword()throws InterruptedException 
	{
		LoginPage Login = new LoginPage(driver);
		Login.LoginFunction("d.trihoang0211022@gmail.com", "BBBBoprodo123@");
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());
	}
	


}
