package automation.testsuite;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageYURL;

public class Alert_selenium extends CommonBase{
	@BeforeMethod
	public void openFirFoxBrowser()
	{
		driver = initFireFoxDriver(CT_PageYURL.ALERTSELENIUM);		
	}
	
	@Test
	public void ThucHanh2()
	{
		click(By.xpath("//button[text()='Try it']"));
		driver.switchTo().alert().sendKeys("Welcome to Selenium WebDriver Tutorials");
		driver.switchTo().alert().accept();
		assertTrue(isElementPresent(By.xpath("//p[text()='Welcome to Selenium WebDriver Tutorials']")));
		
	}
}

