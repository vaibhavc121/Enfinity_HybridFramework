//package testCases.HRMS.HRCore;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import base.BaseTest;
//import base.BasePage;
//import pageObjects.HRMS.SelfService.SelfServicePage;
//import utilities.FileUtils;
//import utilities.JsonUtils;
//import utilities.RetryAnalyzer;
//import java.util.List;
//
//public class BudgetTest extends BaseTest
//{
//	@Test(groups = "regression")
//	public void verifyBudget()
//	{
//		try
//		{
//			// hr core
//			HRCorePage hc = new HRCorePage();
//			hc.clkHRCore();
//			log("clicked on hr core link");
//			hc.clkSetupForm();
//			log("clicked on setup form");
//
//			// setup page
//			SetupPage sp = new SetupPage();
//			sp.clkBudget();
//			Thread.sleep(2000);
//			log("clicked on budget");
//
//			// budget pg
//			BudgetPage bp = new BudgetPage();
//			bp.clkNewBtn();
//			log("clicked on new btn");
//			bp.setName();
//			log("provided budget name");
//			bp.setStartDt();
//			log("provided start dt");
//			bp.setEndDt();
//			Thread.sleep(2000);
//			log("provided end dt");
//			bp.clkSaveBtn();
//			log("clicked on save btn");
//
//			Assert.assertTrue(CommonActions.IsTxnCreated());
//			log("test case passed");
//		} catch (Exception e)
//		{
//			LoggerFactory.getLogger().error("Test failed due to exception: ", e);
//			Assert.fail("Test case failed: " + e);
//		}
//
//	}
//}