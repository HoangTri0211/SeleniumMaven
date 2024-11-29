package automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilterPage {
    WebDriver driver;

    // Constructor
    public FilterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Bộ lọc theo danh mục
    public void selectCategory(String categoryName) {
        WebElement categoryFilter = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div[1]/div/div/div[2]/input"));
        categoryFilter.click();
    }

    // Lấy số lượng sản phẩm sau khi lọc
    public int getFilteredProductCount() {
        return driver.findElements(By.className("product-item")).size();
    }
}
