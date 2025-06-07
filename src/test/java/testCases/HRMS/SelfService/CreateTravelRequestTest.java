package testCases.HRMS.SelfService;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.SelfService.SelfService.SelfServiceModel.TravelRequestModel;
import pageObjects.HRMS.SelfService.SelfServicePage;
import pageObjects.HRMS.SelfService.TravelRequestPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.lang.Character.Subset;
import java.util.List;

public class CreateTravelRequestTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createTravelRequest()
	{
		try
		{
			String selfServiceFile = FileUtils.getDataFile("SelfService", "SelfService", "SelfServiceData");
			List<TravelRequestModel> travelRequestData = JsonUtils.convertJsonListDataModel(selfServiceFile,
					"createTravelRequest", TravelRequestModel.class);

			// self service page
			SelfServicePage ss = new SelfServicePage(driver);
			ss.clickSelfService();
			ss.clickTransactions();

			// travel Request page
			TravelRequestPage tr = new TravelRequestPage(driver);
			for (TravelRequestModel travelRequest : travelRequestData)
			{
				// tr.scrollDownWebpage();
				tr.clickTravelRequest();
				tr.clickNew();
				tr.provideFromDate(travelRequest.fromDate);
				tr.provideUptoDate(travelRequest.uptoDate);
				// tr.clickCategoryDD();
				// tr.selectCategory(travelRequest.category);
				tr.provideCategory(travelRequest.category);
				tr.provideToCountry(travelRequest.country);
				tr.provideCity(travelRequest.city);
				tr.clickHotelBookedByEmpBtn();
				tr.provideTicketDestination(travelRequest.ticketDestination);
				// tr.provideTicketAmt(travelRequest.ticketAmt);
				tr.providePurpose(travelRequest.purpose);
				tr.providePaymentType(travelRequest.paymentType);
				tr.provideRemarks(travelRequest.remarks);
				tr.clickSave();

				Assert.assertTrue(tr.isTransactionCreated(travelRequest.empName, travelRequest.country));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
