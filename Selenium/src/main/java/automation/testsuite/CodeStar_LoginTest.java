package automation.testsuite;


import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageYURL;
import automation.page.CodeStar_LoginPage;

public class CodeStar_LoginTest extends CommonBase {
	@BeforeMethod
	public void openFirFoxBrowser()
	{
		driver = initFireFoxDriver(CT_PageYURL.CRMcodeStar);		
	}
	
	@Test(priority = 1)
	public void loginSuccessfully()
	{
		CodeStar_LoginPage login = new CodeStar_LoginPage(driver);
		login.LoginFunction("admin@gmail.com","12345678");
		assertTrue(isElementPresent(By.xpath("//div[text()='Thêm mới khu vực làm việc thành công']")));
	}

}
