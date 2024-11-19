package automation.testsuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import automation.common.CommonBase;

public class LocatorPractice extends CommonBase{
	@BeforeMethod
	public void openChrome() 
	{
		driver = initChromeDriver("https://selectorshub.com/xpath-practice-page/");
		
	}
	@Test
	public void getLocator()
	{
		WebElement username = driver.findElement(By.name("email"));
		System.out.println("username is:"+username);
		
		WebElement password = driver.findElement(By.id("pass"));
		System.out.println("username is:"+password);
		
		WebElement mobileNumber = driver.findElement(By.name("mobile number"));
		System.out.println("username is:"+mobileNumber);
	}
	
}
