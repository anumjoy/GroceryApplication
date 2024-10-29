package elementRepository;

import org.openqa.selenium.By;
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
	//lock
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement userStatusAlert;
	
	//
	
	//ADD User
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
	
	//Lock User
	public void changeUserStatus(int row,int column) {
		String lockPath="//tbody//tr[" + row + "]//td[" + column + "]//i[contains(@class,'fa fa-unlock')]";
		WebElement lockUserButton=driver.findElement(By.xpath(lockPath));
		lockUserButton.click();		
	}
	public String getStatusAlert() {
		return userStatusAlert.getText();
	}
	//check all inactive users and make them active

}
