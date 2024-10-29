package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) { // constructor, this will be called in TestNG class
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//span[text()='7rmart supermarket']")
	WebElement homePageText;
	@FindBy(xpath="//li//p[text()='Sub Category']")
	WebElement subCategoryButton;
	@FindBy(xpath="//li//p[text()='Category']")
	WebElement categoryButton;
	@FindBy(xpath="//li//p[text()='Manage Contact']")
	WebElement manageContactButton;
	@FindBy(xpath="//li//p[text()='Manage News']")
	WebElement manageNewsButton;
	//adminUsers
	@FindBy(xpath="//li//p[contains(text(), 'Admin Users')]")
	WebElement adminUsersButton;
	@FindBy(xpath="//li//p[text()='Manage Users']")
	WebElement manageUsersElement;
	
	//method to get a text of home page to validate login is success
	public String gethomePageText() {
		return homePageText.getText();		
	}
	//click on subcategory in the homepage to create new subcategory
	public SubCategory clickOnSubCategoryButton() {
		subCategoryButton.click();
		return new SubCategory(driver);
	}
	//click on Category button
	public CategoryPage clickOnCategoryButton() {
		categoryButton.click();
		return new CategoryPage(driver);
	}
	//Click on Manage Contact
	public ManageContact clickOnManageContactButton() {
		manageContactButton.click();
		return new ManageContact(driver);
	}
	//Click on Manage News
		public ManageNews clickOnManageNewsButton() {
			manageNewsButton.click();
			return new ManageNews(driver);
		}
	//Click on Admin Users
		public AdminUsers clickOnAdminUsersButton() {
			adminUsersButton.click();
			manageUsersElement.click();
			return new AdminUsers(driver);
		}

}
