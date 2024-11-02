package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtility;
import utilities.WaitUtilities;

public class ManageContact {
	WebDriver driver;
	
	GeneralUtility gu=new GeneralUtility();
	WaitUtilities wu=new WaitUtilities();
	
	public ManageContact(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		
	}	
	@FindBy(xpath="//div[@class='form-group']//textarea[@name='address']")
	WebElement addressField;
	@FindBy(xpath="//button[@name='Update']")
	WebElement updateButtonElement;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement updateAlertElement;
	
//Edit
	public void clickManageContactEditButton(int row, int column) {
		String editPath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ row + "]//td["+ column +"]//i[@class='fas fa-edit']";
		WebElement editContactElement=driver.findElement(By.xpath(editPath));
		editContactElement.click();
		String editContactAddress="TestAddress"+gu.generateCurrentDateAndTime();
		addressField.clear();
		addressField.sendKeys(editContactAddress);
		gu.scrollToElement(driver, updateButtonElement);
		wu.waitForElementToBeClickable(driver, updateButtonElement);
		//updateButtonElement.click();	
		try {
	        // Try to click the button normally
			updateButtonElement.click();
	    } catch (ElementClickInterceptedException e) {
	        // If click is intercepted, use JavaScript click as a fallback
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", updateButtonElement);
	    }
	}	
	public String getUpdateAlert() {
		return updateAlertElement.getText();
	}
}
