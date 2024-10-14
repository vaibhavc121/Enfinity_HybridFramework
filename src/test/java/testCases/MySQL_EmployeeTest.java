package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRCorePage;
import pageObjects.MySQL_EmployeePage;
import pageObjects.SetupPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class MySQL_EmployeeTest extends BaseClass
{
	@Test(groups = "regression", dataProvider = "employeeinfo", dataProviderClass = DataProviders.class)
	public void verifyEmpCreation(String email, String name, String mobile, String DOJ, String dept, String designation,
			String grade, String gender, String religion, String maritalstatus)
	{
		try
		{
			// hr core
			HRCorePage hc = new HRCorePage(driver);
			hc.clkHRCore();
			logger.info("clicked on hr core link");
			hc.clkSetupForm();
			logger.info("clicked on setup form");

			// setup page
			SetupPage sp = new SetupPage(driver);
			sp.clkEmployee();
			Thread.sleep(2000);
			logger.info("clicked on employee");

			// employee pg
			MySQL_EmployeePage ep = new MySQL_EmployeePage(driver);
			ep.clkBtnNew();
			logger.info("clicked on new btn");
			ep.setWorkEmail(email);
			logger.info("email provided");
			ep.setName(name);
			logger.info("name provided");
			ep.setMblNum(mobile);
			logger.info("mbl no provided");
			ep.setDOJ(DOJ);
			logger.info("DOJ provided");
			ep.clkDept();
			logger.info("clicked on dept dd");
			ep.slctDept(dept);
			logger.info("dept selected");
			ep.clkDesig();
			logger.info("clicked on desg");
			ep.slctDesig(designation);
			logger.info("desg selected");
			ep.setGrade(grade);
			logger.info("grade selected");
			ep.setGender(gender);
			logger.info("gender selected");
			ep.setReligion(religion);
			logger.info("religion selected");
			ep.setMaritalStatus(maritalstatus);
			logger.info("marital sts selected");
			ep.clkSave();
			logger.info("clicked on save button");

			Assert.assertEquals(ep.isEmployeeCreated(name), true);
			// Assert.assertTrue(true);

		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}
}
