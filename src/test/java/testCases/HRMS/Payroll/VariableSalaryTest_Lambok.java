package testCases.HRMS.Payroll;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

import models.Payroll.Payroll.PayrollModel.VariableSalModel;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.VariableSalaryPage;

import utilities.FileUtils;
import utilities.JsonUtils;

public class VariableSalaryTest_Lambok extends BaseTest
{
	@Test(groups = "regression")
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
				vs.clkEmpDD();
				logger.info("clicked on emp dd");
				vs.slctEmp();
				logger.info("employee selected");
				vs.provideRemarks(varSal.remarks);
				vs.clkSave();
				logger.info("clicked on save button");
				vs.clkNewline();
				logger.info("clicked on new line");
				vs.clkSalaryCompDD();
				logger.info("clicked on sal component dd");
				vs.slctSalComp();
				logger.info("selected sal component");
				vs.clkAmt();
				logger.info("clicked on amt textbox");
				vs.provideAmt(varSal.amt);
				logger.info("amt provided");
				vs.clkViewBtn();
				logger.info("clicked on view btn");
				vs.clkApproveBtn();
				logger.info("clicked on approved button");
				vs.clkVariableSalLabel();
				logger.info("clicked on variable sal label");
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
