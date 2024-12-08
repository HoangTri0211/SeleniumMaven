package automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class CodeStar_LoginPage extends CommonBase{
	
	
	public CodeStar_LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void LoginFunction(String email,String password)
	{
		type(By.id("email"),email);
		type(By.id("password"), password);
		click(By.name("signin"));
				
	}

}
