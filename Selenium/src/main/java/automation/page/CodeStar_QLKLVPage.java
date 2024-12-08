package automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;

public class CodeStar_QLKLVPage extends CommonBase{
	
	public CodeStar_QLKLVPage(WebDriver _driver)
	{
		this.driver = _driver;
	}
	
	public void ThemKLV(String maKLV, String tenKLV)
	{
		click(By.xpath("//a[normalize-space()='Quản lý khu làm việc']"));
		click(By.xpath("//button[text()='Thêm mới']"));
		type(By.name("work_areas_code"), maKLV);
		type(By.name("name"), tenKLV);
		click(By.xpath("//button[text()='Lưu']"));
		click(By.xpath("//button[text()='Thêm']"));

	}
	public void TimkiemKhuLV(String tenKLV)
	{
		type(By.xpath("//input[@placeholder='Nhập từ khóa cần tìm kiếm']"),tenKLV);
		click(By.xpath("//button[text()='Tìm kiếm']"));
	}
	
	public void xoaKLV()
	{
		click(By.xpath("//a[normalize-space()='Xóa']"));

	}
}
