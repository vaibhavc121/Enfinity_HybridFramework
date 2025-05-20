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

public class DeleteVariableSalaryTest extends BaseTest
{
	@Test(groups = "regression", priority = 2)
	public void deleteVariableSalary()
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

				BasePage.performAction(6, varSal.employee, "Amend");
				Assert.assertFalse(BasePage.validateListing("Approved", 11, 11));
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}

}
