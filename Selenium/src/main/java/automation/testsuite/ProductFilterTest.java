package automation.testsuite;


import static org.testng.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import automation.common.CommonBase;
import automation.constant.CT_PageYURL;

public class ProductFilterTest extends CommonBase{
	@BeforeMethod
	public void openBrowser()
	{
		driver = initFireFoxDriver(CT_PageYURL.bepantoan);
		
	}

	@Test(priority = 1)
	public void filterProductsByPriceRange() throws InterruptedException {
	    // Step 1: Điều hướng đến trang lọc sản phẩm
	    driver.get("https://bepantoan.vn/san-pham");

	    // Step 2: Áp dụng bộ lọc (Ví dụ: lọc sản phẩm trong khoảng giá từ 1 triệu đến 5 triệu)
	    driver.findElement(By.id("price-range-min")).sendKeys("1000000"); // Nhập giá tối thiểu
	    driver.findElement(By.id("price-range-max")).sendKeys("5000000"); // Nhập giá tối đa
	    driver.findElement(By.xpath("//button[text()='Áp dụng']")).click(); // Click nút áp dụng bộ lọc

	    // Step 3: Chờ kết quả và kiểm tra sản phẩm hiển thị
	    Thread.sleep(2000); // Chờ một chút để kết quả load (nên dùng WebDriverWait thay cho sleep)
	    List<WebElement> productPrices = driver.findElements(By.className("product-price"));

	    for (WebElement priceElement : productPrices) {
	        String priceText = priceElement.getText().replace("₫", "").replace(",", "").trim();
	        int price = Integer.parseInt(priceText);

	        // Xác nhận giá sản phẩm nằm trong khoảng từ 1 triệu đến 5 triệu
	        assertTrue(price >= 1000000 && price <= 5000000, "Sản phẩm không nằm trong khoảng giá đã chọn!");
	    }
	}
	@Test(priority = 2)
	public void verifyPageNotFound() {
	    driver.get("https://bepantoan.vn/san-pham");
	    String pageTitle = driver.getTitle();

	    // Kiểm tra xem tiêu đề hoặc nội dung có chứa lỗi 404 không
	    assertTrue(pageTitle.contains("404") || 
	               driver.getPageSource().contains("Page not found"), 
	               "Trang không bị lỗi 404 như mong đợi");
	}


	@Test(priority = 3)
	public void filterProductsByCategory() throws InterruptedException {
	    // Step 1: Điều hướng đến trang lọc sản phẩm
	    driver.get("https://bepantoan.vn/san-pham");

	    // Step 2: Chọn danh mục sản phẩm (Ví dụ: "Bếp từ")
	    driver.findElement(By.xpath("//label[text()='Bếp từ']")).click(); // Chọn checkbox "Bếp từ"
	    driver.findElement(By.xpath("//button[text()='Áp dụng']")).click(); // Click nút áp dụng bộ lọc

	    // Step 3: Chờ kết quả và kiểm tra sản phẩm hiển thị
	    Thread.sleep(2000);
	    List<WebElement> productCategories = driver.findElements(By.className("product-category"));

	    for (WebElement categoryElement : productCategories) {
	        String categoryText = categoryElement.getText().trim();
	        
	        // Xác nhận sản phẩm thuộc danh mục "Bếp từ"
	        assertTrue(categoryText.contains("Bếp từ"), "Sản phẩm không thuộc danh mục 'Bếp từ'!");
	    }
	    
	}

}
