package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LogInPage;
import utilities.ExcelUtility;

public class LogInPageTest extends BaseClass {
	LogInPage lp; // create instance of Loginpage
	HomePage hp;

	@Test
	public void verifyLogInWithValidData() {
		lp = new LogInPage(driver);
		hp = lp.sendLoginDetails("admin", "admin");
		String actual = hp.gethomePageText(); // program readed value
		String expected = "7rmart supermarket"; // original value
		Assert.assertEquals(actual, expected, Constant.lp_verifyLogInWithValidData); // from Constant class, if assertion passed, this text will not be printed																						
	}

	@Test(dataProvider = "data-provider", enabled = false)
	public void verifyLogInWithInValidData(String username, String password) {
		lp = new LogInPage(driver);
		lp.sendLoginDetails("username", "password");
		String actualAlert = lp.getAlertText();
		String expectedAlert = "Alert!\nInvalid Username/Password";
		Assert.assertEquals(actualAlert, expectedAlert, "Alert is not as expected");
	}

	@DataProvider(name = "data-provider") // use data provider to give invalid data
	public Object[][] dpMethod() {
		return new Object[][] { { "admin", "Admin" }, { "test", "Admin" }, { "abc", "123" }, { "123", "123" } };
	}

	// EXCEL
	@Test(dataProvider = "excelDataProvider")
	public void verifyLogInWithExcelData(String username, String password) {
		lp = new LogInPage(driver);
		lp.sendLoginDetails(username, password);
		boolean actualAlert = lp.getAlertText().contains("Invalid Username/Password");
		boolean expectedAlert = true;
		Assert.assertEquals(actualAlert, expectedAlert, "Alert is not as expected");
	}

	@DataProvider(name = "excelDataProvider")
	public Object[][] excelDataProvider() throws IOException {
		return new Object[][] { { ExcelUtility.getInvalidStringData(2, 0), ExcelUtility.getInvalidStringData(2, 1) },
				{ ExcelUtility.getInvalidStringData(3, 0), ExcelUtility.getInvalidStringData(3, 1) } };
	}

}

//assertion-checks if actual=expected
//SoftAssert softAssert = new SoftAssert(); //next line will be executed even if its failed
//softAssert.assertEquals(actual, expected, Constant.lp_verifyLogInWithValidData);
