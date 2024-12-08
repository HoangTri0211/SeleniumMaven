package automation.common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonBase {
	public static WebDriver driver;
	public int initWaitTime = 30;

	public WebDriver initChromeDriver(String URL) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		System.out.println("user.dir is: " + System.getProperty("user.dir"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(initWaitTime , TimeUnit.SECONDS);
		return driver;
	}
	public WebDriver initFireFoxDriver(String URL)
	{
		
		System.setProperty("webdriver.firefox.driver",System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(initWaitTime , TimeUnit.SECONDS);
		return driver;
			
	}
	public WebElement getElementPresentDOM(By locator) {
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		Wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}
	public void sleep(int milliseconds) {
	    try {
	        Thread.sleep(milliseconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	public boolean isElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(initWaitTime));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return getElementPresentDOM(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e )	{
			return false;
			
		} catch (org.openqa.selenium.TimeoutException e2 ) {
			return false;
		}
	
	}
	public void click(By locator) {
		WebElement element = getElementPresentDOM(locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	 public void type (By locator, String value) {
		 WebElement element = getElementPresentDOM(locator);
		 element.clear();
		 element.sendKeys(value);
	 }

	
}
