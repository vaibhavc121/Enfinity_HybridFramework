package testCases.HRMS.Recruitment;

import base.BasePage;
import base.BaseTest;
import factory.LoggerFactory;
import models.Recruitment.Recruitment.RecruitmentModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Recruitment.CandidatePage;
import pageObjects.HRMS.Recruitment.RecruitmentPage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class CreateCandidateTest extends BaseTest
{
    @Test(groups = "functional", retryAnalyzer = RetryAnalyzer.class)
    public void createCandidate()
    {
        try
        {
            String recruitmentFile = FileUtils.getDataFile("Recruitment", "Recruitment", "RecruitmentData");
            List<RecruitmentModel.CandidateModel> candidateData = JsonUtils.convertJsonListDataModel(recruitmentFile,
                    "createCandidate", RecruitmentModel.CandidateModel.class);

            // recruitment page
            RecruitmentPage rp = new RecruitmentPage();
            rp.clickRecruitment();
            rp.clickCandidate();

            // candidate page
            CandidatePage cp = new CandidatePage();

            for (RecruitmentModel.CandidateModel candidate : candidateData)
            {
                cp.clickNew();
                log("Clicked on New button");

                //region Personal Information
                String candidateName = faker.name().firstName();
                cp.provideName(candidateName);
                log("Provided candidate Name: " + candidateName);

                cp.provideEmail(faker.internet().emailAddress());
                log("Provided Email");

                cp.provideMobileNumber(candidate.mobile);
                log("Provided Mobile Number");

                cp.provideDateOfBirth(candidate.dob);
                log("Provided Date of Birth");

                cp.selectGender(candidate.gender);
                log("gender selected");

                cp.selectMaritalStatus(candidate.maritalStatus);
                log("Provided Marital Status");

                if (candidate.checkbox1)
                {
                    cp.clickDrivingLicense();
                    log("Clicked on Driving License checkbox");
                }

                cp.clickPictureBrowse();
                log("Clicked on Picture Browse button");

                cp.uploadFileWithRobot(System.getProperty("user.dir") + "\\files\\image");
                log("Uploaded Picture");

                cp.clickCVBrowse();
                log("Clicked on CV Browse button");

                cp.uploadFileWithRobot(System.getProperty("user.dir") + "\\files\\document");
                log("Uploaded CV");

                //endregion

                //region Address Information
                cp.provideCity(candidate.city);
                log("Provided City");

                cp.provideState(candidate.state);
                log("Provided State");

                cp.provideCountry(candidate.country);
                log("Provided Country");

                cp.providePostalCode(candidate.postalCode);
                log("Provided Postal Code");
                BasePage.pressTab();

                //endregion

                //region Professional Information
                cp.provideWorkExpInYears(candidate.workExperienceInYear);
                log("Provided Work Experience in Years");

                cp.provideCurrentJobTitle(candidate.currentJobTitle);
                log("Provided Current Job Title");

                cp.provideCurrentEmployer(candidate.currentEmployer);
                log("Provided Current Employer");

                cp.provideSkills(candidate.skills);
                log("Provided Skills");

                cp.provideCurrentSalary(candidate.currentSalary);
                log("Provided Current Salary");

                cp.provideExpectedSalary(candidate.expectedSalary);
                log("Provided Expected Salary");

                cp.provideNoticePeriodInDays(candidate.noticePeriodInDays);
                log("Provided Notice Period in Days");

                if (candidate.checkbox2)
                {
                    cp.clickOverseas();
                    log("Clicked on Overseas checkbox");
                }
                BasePage.pressTab();

                //endregion

                //region Document Information
                cp.providePassportNumber(candidate.passportNumber);
                log("Provided Passport Number");

                cp.providePassportIssueDate(candidate.passportIssueDate);
                log("Provided Passport Issue Date");
                BasePage.pressTab();

                cp.providePassportExpiryDate(candidate.passportExpiryDate);
                log("Provided Passport Expiry Date");

                cp.provideVisaType(candidate.visaType);
                log("Provided Visa Type");

                cp.provideCivilIdNumber(candidate.civilIdNumber);
                log("Provided Civil ID Number");

                //endregion

                cp.clickSave();
                log("Clicked on Save button");

                Assert.assertEquals(cp.getCandidateName(), candidateName);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}