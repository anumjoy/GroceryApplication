package elementRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtility;
import utilities.WaitUtilities;

public class LogInPage {
	WebDriver driver;
	GeneralUtility gu=new GeneralUtility();//calling a fn from generalutility
	WaitUtilities wu=new WaitUtilities();

	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']")
	WebElement userNameField;
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signInButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")//incorrect username pwd-alert
	WebElement alertBox;
	
	public HomePage sendLoginDetails(String username, String password) {
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		signInButton.click();
		return new HomePage(driver);
	}
	
	//method to get the text of Alert
		public String getAlertText() {			
			return alertBox.getText().replace("×", "").trim(); 
			
		}
}






//webelement and funtionns only, we didnt instantiate webdriver here
