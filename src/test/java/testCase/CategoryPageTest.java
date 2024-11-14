package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.CategoryPage;
import elementRepository.HomePage;
import elementRepository.LogInPage;
import elementRepository.SubCategory;
import utilities.ExcelUtility;

public class CategoryPageTest extends BaseClass {
	LogInPage lp;
	HomePage hp;
	CategoryPage cp;

	@Test
	// Edit Category
	public void verifyCategoryEditFunctionality() throws IOException {
		lp = new LogInPage(driver);
		String username = ExcelUtility.getStringData(1, 0);
		String password = ExcelUtility.getStringData(1, 1);
		hp = lp.sendLoginDetails(username, password);
		cp = hp.clickOnCategoryButton();	
		boolean actualTitle = cp.verifyCategoryTitle().contains("List Categories");
		boolean expectedTitle = true;
		Assert.assertEquals(actualTitle, expectedTitle, "Category page Title is not as expected");
		cp.editCategory(3, 4);
		boolean actualCategoryUpdateMsg = cp.getUpdateAlertMsg().contains("Category Updated Successfully");
		boolean expectedCategoryUpdateMsg = true;
		Assert.assertEquals(actualCategoryUpdateMsg, expectedCategoryUpdateMsg,"Update Category Alert is not as expected");		
		String actualUpdatedCategoryName = cp.getEditedCategory();
		String expectedUpdatedCategoryName = cp.getEditedCategoryFromTable(3, 1);
		Assert.assertEquals(actualUpdatedCategoryName, expectedUpdatedCategoryName, Constant.cp_verifyCategoryEditFunctionality);
	}

	@Test
	// Delete
	public void verifyDeleteCategoryFunctionality() throws IOException {
		lp = new LogInPage(driver);
		String username = ExcelUtility.getStringData(1, 0);
		String password = ExcelUtility.getStringData(1, 1);
		hp = lp.sendLoginDetails(username, password);
		cp = hp.clickOnCategoryButton();
		cp.deleteNews(4, 4);
		boolean actualCategoryDeleteMsg = cp.getDeleteAlert().contains("Category Deleted Successfully");
		boolean expectedCategoryDeleteMsg = true;
		Assert.assertEquals(actualCategoryDeleteMsg, expectedCategoryDeleteMsg, Constant.cp_verifyDeleteCategoryFunctionality);
	}
}
