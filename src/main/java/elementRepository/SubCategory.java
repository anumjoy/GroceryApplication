package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtility;
import utilities.WaitUtilities;

public class SubCategory {
	WebDriver driver;
	String subCategoryName;
	String storedSubCategoryName;
	String editSubCategoryName;
	
	GeneralUtility gu=new GeneralUtility();//calling a fn from generalutility
	WaitUtilities wu=new WaitUtilities();

	public SubCategory(WebDriver driver) { // constructor, this will be called in TestNG class
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")//new button
	WebElement newSubCategoryButton;
	@FindBy(id="cat_id")//category dropdown
	WebElement categoryDropDown;
	
	@FindBy(id="subcategory")//Sub Category field
	WebElement subCategoryField;
	@FindBy(xpath="//button[text()='Save']") //Save button
	WebElement saveButton; 
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertElement;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr")
	List<WebElement> subCategoryTableSize;
	//Search 
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath="//select[@class='form-control selectpicker']")
	WebElement searchCategoryDropdown;
	@FindBy(xpath="//input[@class='form-control']")
	WebElement searchSubCategoryField;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement clickSearch;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[@colspan='5']//span[@id='res']//center[contains(text(),'RESULT NOT FOUND')]")
	WebElement searchAlert;	
	//Edit
	@FindBy(id="subcategory")
	WebElement editSubCategoryElement;
	@FindBy(xpath="//button[@name='update']")
	WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement updateAlert;
	
	public void addNewSubCategory() {
		String SubCategoryName="Apple"+gu.generateCurrentDateAndTime();
		this.subCategoryName=SubCategoryName;//copying to instance variable
		newSubCategoryButton.click(); 
		gu.selectDropdownWithVisibleText(categoryDropDown, "Apple");
		subCategoryField.sendKeys(subCategoryName);
		wu.explicitWaitForWebElementClick(driver, saveButton);
		saveButton.click();
	}
	public String getSubCategoryName() {//return instance variable so that it can be used in assertion
		return subCategoryName;
	}
	public String getAlertElementText() {
		return alertElement.getText().replace("�", "").trim(); 
		
	}
	//Read newly added subCategory from TABLE
	public String readSubCategoryTableElement(int row,int column) {
		String path="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td["+column+"]";
		WebElement element=driver.findElement(By.xpath(path));
		return element.getText();
	}
	//Store a SubCategory before deletion
	public String storedSubCategory(int row,int column) {
		String elementPath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td["+column+"]";
		WebElement subCategoryElement =driver.findElement(By.xpath(elementPath));
		this.storedSubCategoryName = subCategoryElement.getText();
		return storedSubCategoryName;
	}
	//delete a subcategory
	public String deleteSubCategoryTableElement(int row,int column) {
		String path="//tbody//tr[" + row + "]//td[" + column + "]//i[@class='fas fa-trash-alt']";
		WebElement deleteElement=driver.findElement(By.xpath(path));
		deleteElement.click();
		return gu.acceptAlert(driver);
	}
	//search the deleted subcategory
	public void searchDeletedElement() {
		wu.explicitWaitForWebElementClick(driver, searchButton);
		searchButton.click();
		wu.explicitWaitForWebElementVisibility(driver, searchCategoryDropdown);
		gu.selectDropdownWithVisibleText(searchCategoryDropdown, "Apple"); 
		wu.explicitWaitForWebElementVisibility(driver, searchSubCategoryField);
		searchSubCategoryField.sendKeys(storedSubCategoryName);
		wu.explicitWaitForWebElementClick(driver, clickSearch);
		clickSearch.click();
	}
	public String getSearchAlertText() {
		return searchAlert.getText();
	}
	//Click Edit SubCategory
	public void clickEditSubCategory(int row,int column) {
		String editPath="//tbody//tr[" + row + "]//td[" + column + "]//i[contains(@class, 'fa-edit')]";
		WebElement editButtont=driver.findElement(By.xpath(editPath));
		editButtont.click();
	}
	public void editSubCategory() {
		String editSubCategoryName="Edited"+gu.generateCurrentDateAndTime();
		this.editSubCategoryName=editSubCategoryName;
		editSubCategoryElement.sendKeys(editSubCategoryName);
		updateButton.click();		
		
	}
	public String getUpdateAlert() {
		//System.out.println(updateAlert.getText()); Sub Category Updated Successfully
		return updateAlert.getText();
	}
	
}
