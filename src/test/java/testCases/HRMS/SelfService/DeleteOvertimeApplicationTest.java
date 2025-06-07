package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pageObjects.HRMS.SelfService.OvertimeRequestPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteOvertimeApplicationTest extends BaseTest
{
	public void deleteOvertimeApplication()
	{
		// self service page
		SelfServicePage ss = new SelfServicePage(driver);
		ss.clickSelfService();
		ss.clickTransactions();

		// OvertimeRequestPage
		OvertimeRequestPage ot = new OvertimeRequestPage(driver);
		ot.clickOvertimeRequest();

		BasePage.deleteTxn(6, "active");
		Assert.assertFalse(BasePage.validateListing("active", 6, 6));
	}

}
