package automation.testsuite;


import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageYURL;
import automation.page.LoginPage_day14;
import automation.page.QuanLyNguoiDungPage;

public class QuanLyNguoiDung_test extends CommonBase{
	@BeforeMethod
	public void OpenFireFox()
	{
		driver = initFireFoxDriver(CT_PageYURL.CRMcodeStar);
		LoginPage_day14 login = new LoginPage_day14(driver);
		login.LoginFunction("admin@gmail.com","12345678");
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());		
	}
	@Test(priority=1)
	public void ThemNguoiDungThatBai_DuLieuSaiDinhDanh()
	{
		QuanLyNguoiDungPage quanlyND = new QuanLyNguoiDungPage(driver);
		quanlyND.ThemNguoiDung("autotest","test@gmail.com","12345678","4","1","2","NDTest1");
		assertTrue(driver.findElement(By.xpath("//div[text()='Dữ liệu nhập vào sai định dạng']")).isDisplayed());
	}
	@Test(priority=2)
	public void ThemNguoiDungThanhCong()
	{
		QuanLyNguoiDungPage quanlyND = new QuanLyNguoiDungPage(driver);
		quanlyND.ThemNguoiDung("HoangDucTri","d.trihoang0211022@gmail.com","905804112","4","1","2","9123456");
		assertTrue(driver.findElement(By.xpath("//div[text()='Dữ liệu nhập vào sai định dạng']")).isDisplayed());
	}
	@Test(priority=3)
	public void XoaNguoiDungKhiDaThemThanhCong()
	{
		QuanLyNguoiDungPage quanlyND = new QuanLyNguoiDungPage(driver);
		quanlyND.HuyNguoiDung("HoangDucTri","d.trihoang02110222@gmail.com","905804112","4","1","2","91234569899");
		assertTrue(driver.findElement(By.xpath("//div[text()='Dữ liệu nhập vào sai định dạng']")).isDisplayed());
	}
}
