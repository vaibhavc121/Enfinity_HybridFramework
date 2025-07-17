package testCases.HRMS.Login;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageObjects.HRMS.HRCore.HomePage;
import pageObjects.HRMS.Login.LoginPage;
import utilities.RetryAnalyzer;

public class LoginTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
	public void verifyLoginWithValidCredentials()
	{
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
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}
}