package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LogInPage;
import elementRepository.ManageNews;
import elementRepository.SubCategory;
import utilities.ExcelUtility;

public class ManageNewsTest extends BaseClass {
	LogInPage lp; // Constructor calling
	HomePage hp;
	ManageNews mn;

	@Test
	// Add News
	public void verifyAddNewsFunctionality() throws IOException {
		lp = new LogInPage(driver);
		String username=ExcelUtility.getStringData(1, 0);
		String password=ExcelUtility.getStringData(1, 1);
		hp=lp.sendLoginDetails(username, password);
		mn=hp.clickOnManageNewsButton();
		mn.addNews();
		boolean actualNewsAlert = mn.getNewsAlert().contains("News Created Successfully");
		boolean expectedNewsAlert = true;
		Assert.assertEquals(actualNewsAlert, expectedNewsAlert, Constant.mn_verifyAddNewsFunctionality);
	}
	
	@Test
	// Edit News
	public void verifyEditNewsFunctionality() throws IOException {
		lp = new LogInPage(driver);		
		String username=ExcelUtility.getStringData(1, 0);
		String password=ExcelUtility.getStringData(1, 1);
		hp=lp.sendLoginDetails(username, password);
		mn=hp.clickOnManageNewsButton();
		mn.editNews(2, 2);
		boolean actualUpdateAlert = mn.getNewsUpdateAlert().contains("News Updated Successfully");
		boolean expectedUpdateAlert = true;
		Assert.assertEquals(actualUpdateAlert, expectedUpdateAlert, Constant.mn_verifyEditNewsFunctionality);		
	}
	
	@Test
	// Delete News
	public void verifyDeleteNewsFunctionality() throws IOException {
		lp = new LogInPage(driver);		
		String username=ExcelUtility.getStringData(1, 0);
		String password=ExcelUtility.getStringData(1, 1);
		hp=lp.sendLoginDetails(username, password);
		mn=hp.clickOnManageNewsButton();
		mn.deleteNews(4, 2);
		boolean actualDeleteAlert = mn.getNewsDeleteAlert().contains("News Deleted Successfully");
		boolean expectedDeleteAlert = true;
		Assert.assertEquals(actualDeleteAlert, expectedDeleteAlert, Constant.mn_verifyDeleteNewsFunctionality);
	}	
	
}
