package automation.testsuite;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageYURL;
import automation.page.CodeStar_LoginPage;
import automation.page.CodeStar_QLKLVPage;

public class CodeStar_QLKLVTest extends CommonBase{
	@BeforeMethod
	public void openFirFoxBrowser()
	{
		driver = initFireFoxDriver(CT_PageYURL.CRMcodeStar);		
	}
	
	@Test (priority=1)
	public void ThemKLV_ThanhCong()
	{
		CodeStar_LoginPage login = new CodeStar_LoginPage(driver);
		login.LoginFunction("admin@gmail.com","12345678");
		assertTrue(isElementPresent(By.id("dropdownMenuLink")));
		
		CodeStar_QLKLVPage qlklv = new CodeStar_QLKLVPage(driver);
		qlklv.ThemKLV("VVIP1","KHU VIP 1");
		qlklv.TimkiemKhuLV("KHU VIP 1");
		assertTrue(isElementPresent(By.xpath("//div[text()='Thêm mới khu vực làm việc thành công']")));
		
	}
	
	@Test (priority=2)
	public void XoaKLV()
	{
		CodeStar_LoginPage login = new CodeStar_LoginPage(driver);
		login.LoginFunction("admin@gmail.com","12345678");
		assertTrue(isElementPresent(By.id("dropdownMenuLink")));
		
		CodeStar_QLKLVPage qlklv = new CodeStar_QLKLVPage(driver);
		qlklv.ThemKLV("VVvIP1","KHU VIP 1v");
		qlklv.TimkiemKhuLV("KHU VIP 1v");
		qlklv.xoaKLV();
		assertTrue(isElementPresent(By.xpath("//div[text()='Thêm mới khu vực làm việc thành công']")));
	}
	
	@Test (priority=3)
	public void ThemKLV_ThatBai_makhuvucdatontai()
	{
		CodeStar_LoginPage login = new CodeStar_LoginPage(driver);
		login.LoginFunction("admin@gmail.com","12345678");
		assertTrue(isElementPresent(By.id("dropdownMenuLink")));
		
		CodeStar_QLKLVPage qlklv = new CodeStar_QLKLVPage(driver);
		qlklv.ThemKLV("VVIP1","KHU VIP 1");
		assertTrue(isElementPresent(By.xpath("//span[@class='text-error' and text()='Mã khu vực đã tồn tại']")));
		
	}
	
	@Test (priority=4)
	public void ThemKLV_ThatBai_dulieunhapsaidinhdang()
	{
		CodeStar_LoginPage login = new CodeStar_LoginPage(driver);
		login.LoginFunction("admin@gmail.com","12345678");
		assertTrue(isElementPresent(By.id("dropdownMenuLink")));
		
		CodeStar_QLKLVPage qlklv = new CodeStar_QLKLVPage(driver);
		qlklv.ThemKLV("Hoàng Đức TRíiiiii","KHU VIP 1");
		assertTrue(isElementPresent(By.id("name_validate")));
		
	}
}
