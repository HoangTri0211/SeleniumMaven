package automation.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class Tedu_CapNhatMatKhauPage {
	
	private WebDriver driver;
	@FindBy(xpath="//a[@title='Đăng nhập']") WebElement buttonDangNhap;
	@FindBy(id = "UserName") WebElement textUserName;
	@FindBy(id = "Password") WebElement textpassword;
	@FindBy(xpath ="//button[text()='Đăng nhập']") WebElement btnDangNhap;
	@FindBy(id ="onesignal-slidedown-cancel-button") WebElement btnLater;
	@FindBy(xpath ="//a[@title='Tài khoản' and @data-toggle='dropdown']") WebElement btnAvatar;
	@FindBy(xpath ="//a[@title='Đổi mật khẩu']") WebElement btnDoiMatKhau;
	@FindBy(id = "OldPassword") WebElement textOldPass;
	@FindBy(id = "NewPassword") WebElement textNewPass;
	@FindBy(id = "ConfirmNewPassword") WebElement textConfirmPass;
	@FindBy(xpath ="//input[@value='Cập nhật']") WebElement btnCapNhat;
	
	@FindBy(xpath = "//*[@id=\"search0\"]/input") WebElement searchBox;
	@FindBy(xpath ="//*[@id=\"search0\"]/span/button/i") WebElement searchButton;
	
	

	public Tedu_CapNhatMatKhauPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void DangNhap(String email, String password)
	{
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", buttonDangNhap);
		buttonDangNhap.click();
		textUserName.sendKeys(email);
		textpassword.sendKeys(password);
		btnDangNhap.click();
		
	}
	public void CloseNotification()
	{
		btnLater.click();
	}
	
	public void CapNhatMatKhau(String oldPass, String newPass)
	{
		btnAvatar.click();
		btnDoiMatKhau.click();
		textOldPass.sendKeys(oldPass);
		textNewPass.sendKeys(newPass);
		textConfirmPass.sendKeys(newPass);
		btnCapNhat.click();
		
	}
	
	public void searchCourse(String courseName) {
	    searchBox.sendKeys(courseName);
	    searchButton.click();
	}
	
	
}
