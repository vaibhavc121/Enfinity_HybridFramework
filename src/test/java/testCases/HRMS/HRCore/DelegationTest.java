package testCases.HRMS.HRCore;

import base.BasePage;
import models.HRCore.HRCore.HRCoreModel;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.HRCore.DelegationPage;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.HRCore.SetupPage;
import utilities.CommonActions;
import utilities.FileUtils;
import utilities.JsonUtils;

import java.util.List;

public class DelegationTest extends BaseTest
{
    String delegationFile = FileUtils.getDataFile("HRCore", "HRCore", "HRCoreData");
    List<HRCoreModel.DelegationModel> delegationData = JsonUtils.convertJsonListDataModel(delegationFile, "Delegation",
            HRCoreModel.DelegationModel.class);

    @Test(groups = "regression")
    public void verifyDelegation()
    {
        try
        {
            // hr core
            HRCorePage hc = new HRCorePage(driver);
            hc.clickHRCore();
            log("clicked on hr core link");
            hc.clickSetupForm();
            log("clicked on setup form");

            // setup page
            SetupPage sp = new SetupPage(driver);
            sp.clickDelegation();
            log("clicked on delegation");
            Thread.sleep(2000);

            // delegation pg
            DelegationPage dp = new DelegationPage(driver);
            for (HRCoreModel.DelegationModel data : delegationData)
            {
                dp.clkNewBtn();
                log("clicked on new btn");

                dp.provideDelegator(data.delegator);
                log("provided delegator: " + data.delegator);

                dp.provideDelegatee(data.delegatee);
                log("provided delegatee: " + data.delegatee);

                dp.provideDesc(data.description);
                log("provided description: " + data.description);

                //Assert.assertTrue(CommonActions.IsTxnCreated());

            }
        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}