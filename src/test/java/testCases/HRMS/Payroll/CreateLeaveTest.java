package testCases.HRMS.Payroll;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import models.Payroll.Payroll.PayrollModel.LeaveModel;
import models.Payroll.Payroll.PayrollModel.VariableSalModel;
import pageObjects.HRMS.Payroll.LeavePage;
import pageObjects.HRMS.Payroll.PayrollPage;
import utilities.FileUtils;
import utilities.JsonUtils;

public class CreateLeaveTest extends BaseTest
{
	@Test(groups = "regression")
	public void CreateLeave()
	{
		try
		{
			String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
			List<LeaveModel> leaveData = JsonUtils.convertJsonListDataModel(payrollFile, "createLeave",
					LeaveModel.class);

			// payroll pg
			PayrollPage pp = new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");

			// leave pg
			LeavePage lp = new LeavePage(driver);

			for (LeaveModel leave : leaveData)
			{
				lp.clkLeave();
				logger.info("clicked on leave");
				lp.clkNewBtn();
				logger.info("clicked on new btn");
				lp.provideEmp(leave.employee);
				logger.info("emp selected");
				lp.provideEffectiveDt(leave.effectiveDate);
				logger.info("provided effective date");
				lp.provideLeaveType(leave.leaveType);
				logger.info("leave type selected");
				lp.provideFromDt(leave.fromDate);
				logger.info("provided from date");
				lp.provideUpToDt(leave.uptoDate);
				logger.info("provided upto date");
				lp.providePaymentType(leave.paymentType);
				lp.clkView();
				logger.info("clicked on view btn");
				lp.clkApproveBack();
				logger.info("clicked on approve btn");

				Assert.assertTrue(lp.isLeaveCreated());

			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
