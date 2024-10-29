package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtility;
import utilities.WaitUtilities;

public class ManageNews {
	WebDriver driver;
	GeneralUtility gu = new GeneralUtility();
	WaitUtilities wu = new WaitUtilities();

	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newManageNewsButton;
	@FindBy(xpath = "//div[@class='form-group']//textarea[@id='news']")
	WebElement enterNewsField;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissible\"]")
	WebElement alertElement;
	// edit
	@FindBy(xpath = "//button[@name='update']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updateAlertElement;
	// Delete
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteAlertElement;

	// Add
	public void addNews() {
		newManageNewsButton.click();
		String enterNews = "Added TestNews" + gu.generateCurrentDateAndTime();
		enterNewsField.clear();
		enterNewsField.sendKeys(enterNews);
		saveButton.click();
	}

	public String getNewsAlert() {
		return alertElement.getText();
	}

	// Edit
	public void editNews(int row, int column) {
		String editPath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + row + "]//td["+ column + "]//i[@class='fas fa-edit']";
		WebElement editNewsElement = driver.findElement(By.xpath(editPath));
		editNewsElement.click();
		String enterEditNews = "Edited" + gu.generateCurrentDateAndTime();
		enterNewsField.clear();
		enterNewsField.sendKeys(enterEditNews);
		updateButton.click();
	}

	public String getNewsUpdateAlert() {
		return updateAlertElement.getText();
	}

	// Delete
	public void deleteNews(int row, int column) {
		String deletePath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + row + "]//td["+ column + "]//i[@class='fas fa-trash-alt']";
		WebElement deleteElement = driver.findElement(By.xpath(deletePath));
		deleteElement.click();
		gu.acceptAlert(driver);
	}

	public String getNewsDeleteAlert() {
		return deleteAlertElement.getText();
	}

}
