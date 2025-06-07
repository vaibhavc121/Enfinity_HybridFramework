package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pageObjects.HRMS.SelfService.ResignationPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteResignationTest extends BaseTest
{
	public void deleteResignation()
	{
		// self service page
		SelfServicePage ss = new SelfServicePage(driver);
		ss.clickSelfService();
		ss.clickTransactions();

		// Resignation page
		ResignationPage rp = new ResignationPage(driver);
		rp.clickResignation();

		BasePage.deleteTxn(6, "active");
		Assert.assertFalse(BasePage.validateListing("active", 6, 6));
	}

}
