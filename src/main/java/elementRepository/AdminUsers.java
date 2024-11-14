package elementRepository;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtility;
import utilities.WaitUtilities;

public class AdminUsers {
WebDriver driver;
	
	GeneralUtility gu=new GeneralUtility();
	WaitUtilities wu=new WaitUtilities();
	
	public AdminUsers(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id="username")
	WebElement userNameField;
	@FindBy(id="password")
	WebElement passwordField;
	@FindBy(id="user_type")
	WebElement userTypeDropDown;
	@FindBy(xpath="//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement userAddedAlert;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement userStatusAlert;
	
	
	public void addNewUser() {		
		newButton.click();
		String enterCredentials = "New" + gu.generateCurrentDateAndTime();
		userNameField.sendKeys(enterCredentials);
		passwordField.sendKeys(enterCredentials);
		gu.selectDropdownWithVisibleText(userTypeDropDown, "Admin");
		saveButton.click();		
	}
	public String getAlert(){
		return userAddedAlert.getText();
	}
	
	public void changeUserStatus(int row,int column) {		
		String lockPath="//tbody//tr[" + row + "]//td[" + column + "]//i[contains(@class,'fa fa-unlock')]";	
		wu.waitForElementToBeVisibleByXpath(driver, lockPath);
		WebElement lockUserButton=driver.findElement(By.xpath(lockPath));
		gu.scrollToElement(driver, lockUserButton);
		wu.waitForElementToBeVisible(driver, lockUserButton);
		wu.waitForElementToBeClickable(driver, lockUserButton);
		wu.waitForLoadingToComplete(driver); 
		lockUserButton.click();
		wu.waitForLoadingToComplete(driver); 
	}	
	public String getStatusAlert() {
		return userStatusAlert.getText();
	}	

}
