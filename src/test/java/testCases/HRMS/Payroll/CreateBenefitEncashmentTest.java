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

public class CreateBenefitEncashmentTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createBenefitEncashment()
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

				be.clkNew();
				logger.info("clicked on new btn");

				be.provideEffectiveDate(benefitEncashment.effectiveDate);
				logger.info("slctd effective dt");

				be.provideEmp(benefitEncashment.employee);
				logger.info("employee slctd");

				be.provideBenefitScheme(benefitEncashment.employeeBenefitScheme);
				logger.info("benefit sceme slctd");

				be.provideReqAmt(benefitEncashment.requestedAmount);
				logger.info("req amt provided");

				be.provideApprovedAmt(benefitEncashment.approvedAmount);
				logger.info("approved amt provided");

				be.selectPaymentType(benefitEncashment.paymentType);

				be.provideRemarks(benefitEncashment.remarks);

				be.clkView();
				logger.info("clicked on view");

				be.clkApproveBack();
				logger.info("clicked on approve and came on listing");

				Assert.assertTrue(BasePage.validateListing2Fields(benefitEncashment.employee, 6, 6,
						benefitEncashment.approvedAmount, 9, 9));

			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
}
