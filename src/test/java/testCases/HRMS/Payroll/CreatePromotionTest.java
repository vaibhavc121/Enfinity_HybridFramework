package testCases.HRMS.Payroll;

import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.PromotionPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class CreatePromotionTest extends BaseTest
{
	String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
	List<PayrollModel.PromotionModel> promotionData = JsonUtils.convertJsonListDataModel(payrollFile,
			"createPromotion", PayrollModel.PromotionModel.class);

	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createPromotion()
	{
		try
		{
			// payroll pg
			PayrollPage pp = new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");

			// promotion pg
			PromotionPage pr=new PromotionPage(driver);

			for(PayrollModel.PromotionModel proData : promotionData)
			{
				pr.clickPromotion();
				logger.info("clicked on promotion link");

				pr.clickNew();
				logger.info("clicked on new button");

				pr.provideEmployee(proData.employee);
				logger.info("provided employee");

				pr.provideEffectiveDate(proData.effectiveDate);
				logger.info("provided effective date");

				pr.selectPromotionType(proData.promotionType);
				logger.info("selected promotion type");

				pr.clickSave();
				logger.info("clicked on save button");

				pr.scrollToElement();
				logger.info("scrolled to element- salaries");

				pr.clickSalaries();
				logger.info("clicked on salaries");

				pr.clickNew1();
				logger.info("clicked on new button in salaries");

				pr.provideSalComp(proData.salComp);
				logger.info("provided salary component");

				pr.provideIncrementAmt(proData.incrementAmt);
				logger.info("provided increment amount");

				pr.provideEffectiveFromDate(proData.salCompEffectiveFromDate);
				logger.info("provided effective from date");

				pr.clickViewApproveBack();
				logger.info("clicked on view approve and navigate back");

				Assert.assertEquals(pr.getSalary(proData.employee), proData.expectedSal,
						"Salary after promotion is not as expected for employee: " + proData.employee);

			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
}