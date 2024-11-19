package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageYURL;

public class Checkbox  extends CommonBase{
	@BeforeMethod
	public void openWebPage()
	{
		driver = initChromeDriver(CT_PageYURL.demoQA);
	}
	@Test 
	public void clickOneCheckbox()
	{
	WebElement sportCheckbox =	driver.findElement(By.id("hobbies-checkbox-1"));
	try {
	if (sportCheckbox.isSelected()== false) {
		sportCheckbox.click();
		System.out.println("Đã chọn Sport");
	}
	else 
		System.out.println("Checkbox đã được chọn mặc định");
	}
	catch(Exception ex)
	{
		WebElement labelChb1 = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1'])"));
	}
}
	@Test
	public void clickOnRadioButton()
	{
		try {
		WebElement maleradio = driver.findElement(By.id("gender-radio-1"));
		maleradio.click();
		System.out.println("Đã chọn Male");
		}
		catch(Exception ex) {
			WebElement labelRadio = driver.findElement(By.xpath("label[@for='gender-radio-1']"));
		}
	}
	
	@Test
	public void checkDefaultRadioButton()
	{
		WebElement maleRadio = driver.findElement(By.id("gender-radio-1"));
		WebElement femalRadio = driver.findElement(By.id("gender-radio-2"));
		WebElement otherRadio = driver.findElement(By.id("gender-radio-3"));
		System.out.println("Male radio button selected:"+maleRadio.isSelected());
		System.out.println("Femal radio button selected:"+femalRadio.isSelected());
		System.out.println("Male radio button selected:"+otherRadio.isSelected());

	}
}


	

