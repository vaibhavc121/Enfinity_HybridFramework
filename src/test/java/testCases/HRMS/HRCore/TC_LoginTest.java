package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HRMS.HRCore.HomePage;
import pageObjects.HRMS.HRCore.LoginPage;
import testBase.BaseClass;

public class TC_LoginTest extends BaseClass
{
	@Test
	public void verify_login()
	{
		logger.info("login test started..");
		try
		{
			// login page
			LoginPage lp = new LoginPage(driver);
			lp.setUsername(p.getProperty("username"));
			Thread.sleep(3000);
			lp.setPwd(p.getProperty("pwd"));
			Thread.sleep(3000);
			lp.clkSignin();

			// home page
			HomePage hp = new HomePage(driver);
			boolean act = hp.isCompanyNameDisplay();
			Assert.assertEquals(act, true, "login failed");
			// Assert.assertTrue(act);
			logger.info("test case passed");
		}
		catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}
}