package automation.testsuite;

import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import automation.common.CommonBase;
import automation.constant.CT_PageYURL;
import automation.page.LoginPage_day14;

public class LoginTest_d14 extends CommonBase{
	@BeforeMethod
	public void OpenFireFox()
	{
		driver = initFireFoxDriver(CT_PageYURL.CRMcodeStar);
	}
	@Test(priority=1)
	public void LoginSuccesfully()
	{
		LoginPage_day14 login = new LoginPage_day14(driver);
		login.LoginFunction("admin@gmail.com","12345678");
		assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Quản lý người dùng')].")).isDisplayed());
	}
	
}
