package automation.page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class QuanLyNguoiDungPage {
	private WebDriver driver;
	@FindBy(xpath="//button[text()='Thêm mới']") WebElement btnThemMoi ;
	@FindBy(name="username") WebElement textHoVaTen;
	@FindBy(name="email") WebElement textEmail;
	@FindBy(name="phone_number") WebElement textSDT;
	@FindBy(name="department_id") WebElement dropdownPhongBan;
	@FindBy(name="role_id") WebElement dropdownChucDanh;
	@FindBy(name="workarea_id") WebElement dropdownKhuVucLamViec;
	@FindBy(name="code_user") WebElement maNguoiDung;
	@FindBy(xpath="//button[text()='Lưu']") WebElement btnLuu;
	@FindBy(xpath="//button[text()='Thêm']") WebElement btnThem;
	@FindBy(xpath="(//button[contains(@class, 'btn-danger')])[1]") WebElement btnHuy;

	public QuanLyNguoiDungPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void ThemNguoiDung(String hoten, String email, String sdt, String phongban, String chucDanh, String khuLV, String maND)
	{
		btnThemMoi.click();
		textHoVaTen.sendKeys(hoten);
		textEmail.sendKeys(email);
		textSDT.sendKeys(sdt);
		Select selectPhongBan = new Select (dropdownPhongBan);
		selectPhongBan.selectByValue(phongban);
		Select selectChucDanh = new Select (dropdownChucDanh);
		selectChucDanh.selectByValue(chucDanh);
		Select selectKhuLamViec = new Select (dropdownKhuVucLamViec);
		selectKhuLamViec.selectByValue(khuLV);
		maNguoiDung.sendKeys(maND);
		btnLuu.click();
		btnThem.click();

	}
	public void HuyNguoiDung(String hoten, String email, String sdt, String phongban, String chucDanh, String khuLV, String maND)
	{
		btnThemMoi.click();
		textHoVaTen.sendKeys(hoten);
		textEmail.sendKeys(email);
		textSDT.sendKeys(sdt);
		Select selectPhongBan = new Select (dropdownPhongBan);
		selectPhongBan.selectByValue(phongban);
		Select selectChucDanh = new Select (dropdownChucDanh);
		selectChucDanh.selectByValue(chucDanh);
		Select selectKhuLamViec = new Select (dropdownKhuVucLamViec);
		selectKhuLamViec.selectByValue(khuLV);
		maNguoiDung.sendKeys(maND);
		btnLuu.click();
		btnHuy.click();
		}
}
