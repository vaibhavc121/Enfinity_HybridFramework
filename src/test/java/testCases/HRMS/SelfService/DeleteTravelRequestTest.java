package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pageObjects.HRMS.SelfService.SelfServicePage;
import pageObjects.HRMS.SelfService.TravelRequestPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class DeleteTravelRequestTest extends BaseTest
{
	public void DeleteTravelRequest()
	{
		// Self service page
		SelfServicePage ss = new SelfServicePage(driver);
		ss.clickSelfService();
		ss.clickTransactions();

		// TravelRequestPage
		TravelRequestPage tr = new TravelRequestPage(driver);
		tr.clickTravelRequest();

		BasePage.deleteTxn(6, "active");
		Assert.assertFalse(BasePage.validateListing("active", 6, 6));
	}

}
