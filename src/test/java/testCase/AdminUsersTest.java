package testCase;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

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
	public void addNewAdminUsers() throws IOException {
		lp = new LogInPage(driver);
		String username = ExcelUtility.getStringData(1, 0);
		String password = ExcelUtility.getStringData(1, 1);
		hp = lp.sendLoginDetails(username, password);
		au = hp.clickOnAdminUsersButton();
		au.addNewUser();
		boolean actualUserAddedAlert = au.getAlert().contains("User Created Successfully");
		boolean expectedUserAddedAlert = true;
		Assert.assertEquals(actualUserAddedAlert, expectedUserAddedAlert, Constant.au_addNewAdminUsers);
	}
	
	@Test
	//Status
	public void changeUserStatus() throws IOException, TimeoutException{
		lp = new LogInPage(driver);
		String username = ExcelUtility.getStringData(1, 0);
		String password = ExcelUtility.getStringData(1, 1);
		hp = lp.sendLoginDetails(username, password);
		au = hp.clickOnAdminUsersButton();
		au.changeUserStatus(5, 5);
		boolean actualStatusAlert = au.getStatusAlert().contains("User Status Changed Successfully");
		boolean expectedStatusAlert = true;
		Assert.assertEquals(actualStatusAlert, expectedStatusAlert, Constant.au_changeUserStatus);
	}	
	

}
