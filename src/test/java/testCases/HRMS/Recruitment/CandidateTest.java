package testCases.HRMS.Recruitment;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Recruitment.CandidatePage;
import pageObjects.HRMS.Recruitment.RecruitmentPage;
import utilities.RetryAnalyzer;

public class CandidateTest extends BaseTest
{
    @Test(groups="functional", retryAnalyzer = RetryAnalyzer.class)
    public void createCandidate()
    {
        try
        {
//            String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
//            List<VariableSalModel> leaveRequestData = JsonUtils.convertJsonListDataModel(payrollFile,
//                    "createVariableSal", VariableSalModel.class);

            // recruitment page
            RecruitmentPage rp=new RecruitmentPage(driver);
            rp.clickCandidate();

            // candidate page
            CandidatePage cp=new CandidatePage(driver);
            cp.clickNew();
            log("Clicked on New button");

            cp.provideName(faker.name().firstName());
            log("Provided Name");
            cp.provideEmail(faker.internet().emailAddress());
            log("Provided Email");
            cp.provideMobileNumber(faker.phoneNumber().cellPhone());
            log("Provided Mobile Number");
            cp.provideDateOfBirth(faker.date().birthday(18, 60).toString());
            log("Provided Date of Birth");
            cp.clickSave();
            log("Clicked on Save button");





        } catch (Exception e)
        {
            logger.error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}