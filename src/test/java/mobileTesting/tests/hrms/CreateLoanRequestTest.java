package mobileTesting.tests.hrms;

import factory.LoggerFactory;
import mobileTesting.base.BaseTest;
import mobileTesting.pages.hrms.LoanPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.FileUtils;
import utilities.JsonUtils;

public class CreateLoanRequestTest extends BaseTest
{
    @Test
    public void createLoanRequest()
    {
//        String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
//        List<VariableSalModel> leaveRequestData = JsonUtils.convertJsonListDataModel(payrollFile,
//                "createVariableSal", VariableSalModel.class);

        try
        {
            LoanPage lp = new LoanPage();
            lp.clickPlusBtn();
            log("clicked on plus button");

            lp.clickLoanRequest();
            log("clicked on loan request");

            lp.providedLoanAmount("10");
            log("provided loan amt");

            lp.providedInstallmentAmount("1");
            log("providedInstallmentAmount");

            lp.providedNoOfInstallments("10");
            log("providedNoOfInstallments");

            lp.clickSubmit();
            log("clickSubmit");

            Assert.assertTrue(false);
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}