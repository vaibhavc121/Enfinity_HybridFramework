package testCases.HRMS.Payroll;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.BenefitSchemeEncashmentModel;
import pageObjects.HRMS.Payroll.BenefitEncashmentPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

public class DeleteBenefitEncashmentTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void deleteBenefitEncashment()
	{
		try
		{
			String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
			List<BenefitSchemeEncashmentModel> benefitSchemeEncashmentData = JsonUtils.convertJsonListDataModel(
					payrollFile, "createBenefitSchemeEncashment", BenefitSchemeEncashmentModel.class);

			// payroll pg
			PayrollPage pp = new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");

			// Benefit Encashment pg
			BenefitEncashmentPage be = new BenefitEncashmentPage(driver);

			for (BenefitSchemeEncashmentModel benefitEncashment : benefitSchemeEncashmentData)
			{

				be.clkBenefitEncashment();
				logger.info("clicked on benefit encashment");

				BasePage.performAction(6, benefitEncashment.employee, "Amend");
				Assert.assertFalse(BasePage.validateListing(benefitEncashment.employee, 6, 6));

			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}

}
