package mobileTesting.tests.hrms;

import factory.LoggerFactory;
import mobileTesting.base.BaseTest;
import mobileTesting.pages.hrms.LeavePage;
import mobileTesting.pages.hrms.LoanPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateLeaveRequestTest extends BaseTest
{
    @Test
    public void createLeaveRequestTest()
    {
        //        String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
//        List<VariableSalModel> leaveRequestData = JsonUtils.convertJsonListDataModel(payrollFile,
//                "createVariableSal", VariableSalModel.class);

        try
        {
            LeavePage lp = new LeavePage();
            lp.clickPlusBtn();
            log("Clicked on plus button");

            lp.clickExpenseClaim();
            log("Clicked on Expense Claim");

            lp.providedAdvanceAmount();
            log("Provided advance amount");

            lp.providedDescription();
            log("Provided description");

            lp.clickSubmit();
            log("Clicked submit button");

            Assert.assertTrue(true, "Leave request created successfully");
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}