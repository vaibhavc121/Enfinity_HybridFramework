package testCases.HRMS.Payroll;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.VariableSalaryPage;
import testBase.BaseClass;

public class TC_VariableSalaryTest extends BaseClass
{
	@Test(groups = "regression")
	public void verifyVariableSalary()
	{
		try 
		{
			//payroll pg
			PayrollPage pp=new PayrollPage(driver);
			pp.clkPayroll();
			logger.info("clicked on payroll link");
			pp.clkTxn();
			logger.info("clicked on txn");
			
			//variable sal pg
			VariableSalaryPage vs=new VariableSalaryPage(driver);
			vs.clkVariableSal();
			logger.info("clicked on variable sal");
			vs.clkNewBtn();
			logger.info("clicked on new btn");
			vs.clkEmpDD();
			logger.info("clicked on emp dd");
			vs.slctEmp();
			logger.info("employee selected");
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
			vs.provideAmt();
			logger.info("amt provided");
			vs.clkViewBtn();
			logger.info("clicked on view btn");
			vs.clkApproveBtn();
			logger.info("clicked on approved button");
			vs.clkVariableSalLabel();
			logger.info("clicked on variable sal label");			
		} 
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
}