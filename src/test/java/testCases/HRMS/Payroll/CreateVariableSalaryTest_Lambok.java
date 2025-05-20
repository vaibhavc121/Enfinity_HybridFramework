package testCases.HRMS.Payroll;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;

import models.Payroll.Payroll.PayrollModel.VariableSalModel;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.VariableSalaryPage;

import utilities.FileUtils;
import utilities.JsonUtils;

public class CreateVariableSalaryTest_Lambok extends BaseTest
{
	@Test(groups = "regression", priority = 1)
	public void verifyVariableSalary()
	{
		try
		{
			String variableSalFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
			List<VariableSalModel> leaveRequestData = JsonUtils.convertJsonListDataModel(variableSalFile,
					"createVariableSal", VariableSalModel.class);

			// payroll pg
			PayrollPage pp = new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");

			// variable sal pg
			VariableSalaryPage vs = new VariableSalaryPage(driver);

			for (VariableSalModel varSal : leaveRequestData)
			{
				vs.clkVariableSal();
				logger.info("clicked on variable sal");
				vs.clkNewBtn();
				logger.info("clicked on new btn");
				vs.provideEmp(varSal.employee);
				logger.info("employee selected");
				vs.provideEffectiveDate(varSal.effectiveDate);
				vs.provideRemarks(varSal.remarks);
				vs.clkSave();
				logger.info("clicked on save button");
				vs.clkNewline();
				logger.info("clicked on new line");
				vs.provideSalaryComp(varSal.salComponent);
				logger.info("selected sal component");
				vs.provideAmt(varSal.amt);
				logger.info("amt provided");
				vs.clkViewBtn();
				logger.info("clicked on view btn");
				vs.clkApproveBack();
				logger.info("clicked on approved button");

				Assert.assertTrue(BasePage.validateListing2Fields(varSal.employee, 6, 6, varSal.amt, 7, 7));

			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
