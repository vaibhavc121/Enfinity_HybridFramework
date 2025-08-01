package testCases.HRMS.Payroll;

import base.BasePage;
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
	List<PayrollModel.PromotionModel> promotionData = JsonUtils.convertJsonListDataModel1(payrollFile,
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
				log("clicked on promotion link");

				pr.clickNew();
				log("clicked on new button");

				pr.provideEmployee(proData.employee);
				log("provided employee");

				pr.provideEffectiveDate(proData.effectiveDate);
				log("provided effective date");

				pr.selectPromotionType(proData.promotionType);
				log("selected promotion type");

				pr.provideNewDesignation(proData.newDesignation);
				log("provided new designation");

//				pr.clickSave();
//				logger.info("clicked on save button");
//
//				pr.scrollToElement();
//				logger.info("scrolled to element- salaries");
//
//				pr.clickSalaries();
//				logger.info("clicked on salaries");
//
//				pr.clickNew1();
//				logger.info("clicked on new button in salaries");
//
//				pr.provideSalComp(proData.salComp);
//				logger.info("provided salary component");
//
//				pr.provideIncrementAmt(proData.incrementAmt);
//				logger.info("provided increment amount");
//
//				pr.provideEffectiveFromDate(proData.salCompEffectiveFromDate);
//				logger.info("provided effective from date");

				pr.clickViewApproveBack();
				log("clicked on view approve and navigate back");

				Assert.assertTrue(BasePage.validateListing(proData.employee, 6, 6),
						"Promotion for employee: " + proData.employee + " is not created successfully");

//				Assert.assertEquals(pr.getSalary(proData.employee), proData.expectedSal,
//						"Salary after promotion is not as expected for employee: " + proData.employee);

			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
}