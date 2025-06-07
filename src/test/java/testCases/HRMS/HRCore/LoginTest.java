package testCases.HRMS.HRCore;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import base.BasePage;
import pageObjects.HRMS.HRCore.HomePage;
import pageObjects.HRMS.HRCore.LoginPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class LoginTest extends BaseTest
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
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}

	}
}
