package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageYURL;

public class Dropdownlist extends CommonBase {

	@BeforeMethod
	public void openWebPage() {
		driver = initChromeDriver(CT_PageYURL.codeStarCourse);
	}
	
	@Test
	public void chooseVietNamOption() throws InterruptedException
	{
		Select courseDrowdown = new Select(driver.findElement(By.id("product_categories_filter")));
		courseDrowdown.selectByVisibleText("AWS");
		String text1 = courseDrowdown.getFirstSelectedOption().getText();
		System.out.println("courseDropdowm.getFirstSelectedOption: "+text1);
		
		courseDrowdown.selectByValue("https://codestar.vn/product-category/lap-trinh-web/");
		String text2 = courseDrowdown.getFirstSelectedOption().getText();
		System.out.println("courseDropdowm.getFirstSelectedOption: "+text2);
		
		courseDrowdown.selectByIndex(4);
		String text3 = courseDrowdown.getFirstSelectedOption().getText();
		System.out.println("courseDropdowm.getFirstSelectedOption: "+text3);
	}
	
	
}
