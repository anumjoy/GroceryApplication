package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminUsers;
import elementRepository.HomePage;
import elementRepository.LogInPage;
import elementRepository.ManageContact;
import utilities.ExcelUtility;

public class AdminUsersTest extends BaseClass {
	LogInPage lp;
	HomePage hp;
	AdminUsers au;

	@Test(groups="smoke")
	// Add
	public void verifyAddAdminUsers() throws IOException {
		lp = new LogInPage(driver);
		String username = ExcelUtility.getStringData(1, 0);
		String password = ExcelUtility.getStringData(1, 1);
		hp = lp.sendLoginDetails(username, password);
		au = hp.clickOnAdminUsersButton();
		au.addNewUser();
		boolean actualUserAddedAlert = au.getAlert().contains("User Created Successfully");
		boolean expectedUserAddedAlert = true;
		Assert.assertEquals(actualUserAddedAlert, expectedUserAddedAlert, Constant.au_verifyAddAdminUsers);
	}
	
	@Test
	//Status
	public void verifyUserStatus() throws IOException {
		lp = new LogInPage(driver);
		String username = ExcelUtility.getStringData(1, 0);
		String password = ExcelUtility.getStringData(1, 1);
		hp = lp.sendLoginDetails(username, password);
		au = hp.clickOnAdminUsersButton();
		au.changeUserStatus(3, 5);
		boolean actualStatusAlert = au.getStatusAlert().contains("User Status Changed Successfully");
		boolean expectedStatusAlert = true;
		Assert.assertEquals(actualStatusAlert, expectedStatusAlert, Constant.au_verifyUserStatus);
	}
	
	

}
