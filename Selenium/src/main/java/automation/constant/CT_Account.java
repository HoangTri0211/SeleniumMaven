package automation.constant;

import org.openqa.selenium.By;

public class CT_Account {
	// Chức các locator của element trên toàn bộ các case cần test
	// nếu locator bị thay đổi, tester vào class để thay đổi giá trị xpath
	
	public static By TEXT_EMAIL = By.id("txtLoginUsername");
	public static By TEXT_PASSWORD = By.id("txtLoginPassword");
	public static By BUTTON_LOGIN = By.xpath("//button[text()='ĐĂNG NHẬP' and contains(@class,'btn_submit')]");
	public static By BUTTON_THOAT = By.xpath("//*[@id=\"subulmenu\"]/li[2]/ul/li[7]/div/a");
	public static By CRMCodestar = By.xpath("//*[@id=\"subulmenu\"]/li[2]/ul/li[7]/div/a");

}

