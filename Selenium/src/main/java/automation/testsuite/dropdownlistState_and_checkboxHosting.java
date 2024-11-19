package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageYURL;

public class dropdownlistState_and_checkboxHosting extends CommonBase {

    @BeforeMethod
    public void openWebPage() {
        driver = initChromeDriver(CT_PageYURL.demoselenium);
    }

    @Test
    public void selectStateAndHostingOption() throws InterruptedException {
        
        Select stateDropdown = new Select(driver.findElement(By.name("state")));
        stateDropdown.selectByVisibleText("California");
        String selectedState = stateDropdown.getFirstSelectedOption().getText();
        System.out.println("State selected by visible text: " + selectedState);

        
        stateDropdown.selectByValue("Texas");
        String selectedStateByValue = stateDropdown.getFirstSelectedOption().getText();
        System.out.println("State selected by value: " + selectedStateByValue);

        
        stateDropdown.selectByIndex(3);
        String selectedStateByIndex = stateDropdown.getFirstSelectedOption().getText();
        System.out.println("State selected by index: " + selectedStateByIndex);

        
        WebElement hostingOption = driver.findElement(By.xpath("//input[@value='yes']"));
        hostingOption.click();
        System.out.println("Checkbox 'Do you have hosting?' selected: Yes");

        Thread.sleep(2000);
    }
}
