package testCases.HRMS.Payroll.Setups;

import base.BaseTest;
import factory.LoggerFactory;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.FileUtils;
import utilities.JsonUtils;

import java.util.List;

public class FinancialIntegrationGroupsTest extends BaseTest
{
    String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
    List<PayrollModel.PaymentBatchModel> paymentBatchData = JsonUtils.convertJsonListDataModel(payrollFile, "paymentBatch",
            PayrollModel.PaymentBatchModel.class);

    @Test
    public void createFinancialIntegrationGroups()
    {
        try
        {

        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test
    public void deleteFinancialIntegrationGroups()
    {
        try
        {

        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}