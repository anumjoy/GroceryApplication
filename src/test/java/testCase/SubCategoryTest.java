package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LogInPage;
import elementRepository.SubCategory;
import utilities.ExcelUtility;

public class SubCategoryTest extends BaseClass {
	LogInPage lp; // Constructor calling
	HomePage hp;
	SubCategory sc;

	@Test
	// Add
	public void verifyNewSubCategory() throws IOException {
		lp = new LogInPage(driver); // calling constructor of log in page from java class		
		String username = ExcelUtility.getStringData(1, 0);
		String password = ExcelUtility.getStringData(1, 1);
		hp = lp.sendLoginDetails(username, password);
		sc=hp.clickOnSubCategoryButton();
		sc.addNewSubCategory();
		//String actualSubCategoryCreatedAlert = sc.getAlertElementText();
		//String expectedSubCategoryCreatedAlert = "Alert!\nSub Category Created Successfully";
		//Assert.assertEquals(actualSubCategoryCreatedAlert, expectedSubCategoryCreatedAlert,"SubCategory Alert is not as expected");
		boolean actualSubCategoryCreatedAlert = sc.getAlertElementText().contains("Sub Category Created Successfully");
		boolean expectedUpdateAlert = true;
		Assert.assertEquals(actualSubCategoryCreatedAlert, expectedUpdateAlert, "Alert is not as expected");
		hp.clickOnSubCategoryButton();
		String actualSubCategoryName = sc.readSubCategoryTableElement(1, 1);
		String expectedSubCategoryName = sc.getSubCategoryName();
		Assert.assertEquals(actualSubCategoryName, expectedSubCategoryName, Constant.sc_verifyNewSubCategory);
	}

	@Test
	  // Delete
	  public void deleteSubCategory() throws IOException {
		lp=new LogInPage(driver);		
		String username = ExcelUtility.getStringData(1, 0);
		String password = ExcelUtility.getStringData(1, 1);
		hp = lp.sendLoginDetails(username, password);
		sc=hp.clickOnSubCategoryButton();
		String savedSubCategoryName=sc.storedSubCategory(2, 1); //stored	  
		String actualSubCategoryDeleteAlert=sc.deleteSubCategoryTableElement(2, 5);//deleted
		String expectedSubCategoryDeleteAlert="Do you want to delete this Sub Category?";
		Assert.assertEquals(actualSubCategoryDeleteAlert, expectedSubCategoryDeleteAlert,Constant.sc_deleteSubCategory);
		//Search
		hp.clickOnSubCategoryButton();
		sc.searchDeletedElement();
		String actualSearchCreatedAlert = sc.getSearchAlertText(); // Search Alert
		String expectedSearchCreatedAlert = ".........RESULT NOT FOUND.......";
		Assert.assertEquals(actualSearchCreatedAlert, expectedSearchCreatedAlert, Constant.sc_deleteSubCategory);
	}

	@Test
	// Edit SubCategory
	public void updateSubCategory() throws IOException {
		lp = new LogInPage(driver);		
		String username = ExcelUtility.getStringData(1, 0);
		String password = ExcelUtility.getStringData(1, 1);
		hp = lp.sendLoginDetails(username, password);
		sc=hp.clickOnSubCategoryButton();
		sc.clickEditSubCategory(5, 5);
		sc.editSubCategory();
		boolean actualUpdateAlert = sc.getUpdateAlert().contains("Sub Category Updated Successfully");
		boolean expectedUpdateAlert = true;
		Assert.assertEquals(actualUpdateAlert, expectedUpdateAlert, Constant.sc_updateSubCategory);
	}

}
