package automation.testsuite;


import static org.testng.Assert.assertTrue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import automation.common.CommonBase;
import automation.constant.CT_PageYURL;
import automation.page.Tedu_CapNhatMatKhauPage;

public class Tedu_CapNhatMatKhauTest extends CommonBase{
	public Tedu_CapNhatMatKhauPage teduPage;
	String currentPass = "Boprodo123@23";
	
	@BeforeMethod
	public void openChrome()
	{
		driver = initChromeDriver(CT_PageYURL.TEDUURL);
		teduPage = new Tedu_CapNhatMatKhauPage(driver);
	} 
	

	
	@Test(priority = 1)
	public void CapNhatMatKhauThanhCong() throws InterruptedException
	{
		Random rand = new Random();
		int value = rand.nextInt(50);
		String newPass = currentPass+value;
		System.out.println(newPass);
		driver.manage().timeouts()	.implicitlyWait(5, TimeUnit.SECONDS);
		DangNhapThanhCong();
		teduPage.CapNhatMatKhau(currentPass, newPass);
		
		assertTrue(driver.findElement(By.xpath("//div[text()='Đổi mật khẩu thành công. Mời bạn đăng nhập lại.']")).isDisplayed());
		currentPass = newPass;
	}
	
	@Test(priority = 2)
	public void DangNhapThanhCong() throws InterruptedException
	{
			
		Thread.sleep(3000);
		teduPage.CloseNotification();
		Thread.sleep(3000);
		teduPage.DangNhap("d.trihoang021102@gmail.com",currentPass);
		assertTrue(driver.findElement(By.xpath("//a[@title='Tài khoản' and @data-toggle='dropdown']")).isDisplayed());
	}
	@Test(priority = 3)
	public void testSearchCourse() throws InterruptedException
	{
		DangNhapThanhCong(); 

        // Thực hiện tìm kiếm khóa học "ASP Net"
		teduPage.searchCourse("ASP Net");
        Thread.sleep(3000);  // Đợi kết quả tải về

        // Kiểm tra kết quả tìm kiếm có hiển thị khóa học hay không
        assertTrue(driver.findElement(By.xpath("//*[@id=\"page-wrap\"]/section/div/div/div[2]/div/div[1]/div[2]/div[1]/h3/a")).isDisplayed());
        
	}

	
}
