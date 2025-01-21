package testCases.HRMS.Payroll;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HRMS.Payroll.BenefitEncashmentPage;
import pageObjects.HRMS.Payroll.PayrollPage;

public class TC_BenefitEncashmentTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyBenefitEncashment()
	{
		try
		{
			//payroll pg
			PayrollPage pp=new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");
			
			//Benefit Encashment pg
			BenefitEncashmentPage be=new BenefitEncashmentPage(driver);
			be.clkBenefitEncashment();
			logger.info("clicked on benefit encashment");
			be.clkNew();
			logger.info("clicked on new btn");
			be.clkEffectiveDateDD();
			logger.info("clicked on effective dt dd");
			be.slctEffectiveDate();
			logger.info("slctd effective dt");
			be.clkEmpDD();
			logger.info("clicked on emp dd");
			be.slctEmp();
			logger.info("employee slctd");
			be.clkBenefitScemeDD();
			logger.info("clicked on benefit sceme dd");
			be.slctBenefitSceme();
			logger.info("benefit sceme slctd");
			be.provideReqAmt();
			logger.info("req amt provided");
			be.provideApprovedAmt();
			logger.info("approved amt provided");
			be.clkView();
			logger.info("clicked on view");
			be.clkApprove();
			logger.info("clicked on approve");
			be.isTxnCreated();
			
			
		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
}
