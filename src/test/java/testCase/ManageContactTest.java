package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LogInPage;
import elementRepository.ManageContact;
import utilities.ExcelUtility;

public class ManageContactTest extends BaseClass {
	LogInPage lp;
	HomePage hp;
	ManageContact mc;

	@Test(groups="smoke")
	// Edit Contact
	public void editContact() throws IOException {
		lp = new LogInPage(driver);
		String username = ExcelUtility.getStringData(1, 0);
		String password = ExcelUtility.getStringData(1, 1);
		hp = lp.sendLoginDetails(username, password);
		mc = hp.clickOnManageContactButton();
		mc.clickManageContactEditButton(1, 6);
		boolean actualUpdateAlert = mc.getUpdateAlert().contains("Contact Updated Successfully");
		boolean expectedUpdateAlert = true;
		Assert.assertEquals(actualUpdateAlert, expectedUpdateAlert, Constant.mc_editContact);
	}

}
