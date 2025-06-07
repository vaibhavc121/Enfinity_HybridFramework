package testCases.HRMS.Onboarding;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.Onboarding.Onboarding.OnboardingModel.CandidateModel;
import base.BasePage;
import pageObjects.HRMS.Onboarding.CandidatePage;
import pageObjects.HRMS.Onboarding.OnboardingPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateCandidateTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createCandidate()
	{
		try
		{
			String onboardingFile = FileUtils.getDataFile("Onboarding", "Onboarding", "OnboardingData");
			List<CandidateModel> candidateData = JsonUtils.convertJsonListDataModel(onboardingFile, "createCandidate",
					CandidateModel.class);

			// onboarding page
			OnboardingPage op = new OnboardingPage(driver);
			op.clickMenu();
			op.clickOnboarding();
			op.clickCandidate();

			// candidate page
			CandidatePage cp = new CandidatePage(driver);

			for (CandidateModel candidate : candidateData)
			{
				cp.clickNew();
				cp.provideName();
				// cp.provideNameArabic(candidate.nameArabic);
				cp.provideEmail();
				cp.provideMbl(candidate.mobileNumber);
				cp.provideDob(candidate.dateOfBirth);
				cp.provideGender(candidate.gender);
				cp.provideMaritalStatus(candidate.maritalStatus);
				cp.provideCity(candidate.city);
				cp.provideState(candidate.state);
				cp.provideCountry(candidate.country);
				cp.providePostalCode(candidate.postalCode);
				cp.provideWorkExperienceInYear(candidate.workExperienceInYear);
				cp.provideCurrentJobTitle(candidate.currentJobTitle);
				cp.provideCurrentEmployer(candidate.currentEmployer);
				cp.provideSkills(candidate.skills);
				cp.provideCurrentSalary(candidate.currentSalary);
				cp.provideExpectedSalary(candidate.expectedSalary);
				cp.provideNoticePeriodInDays(candidate.noticePeriodInDays);
				cp.providePassportNumber(candidate.passportNumber);
				cp.providePassportIssueDate(candidate.passportIssueDate);
				cp.providePassportExpiryDate(candidate.passportExpiryDate);
				cp.provideVisaType(candidate.visaType);
				cp.provideCivilIdNumber(candidate.civilIdNumber);
				cp.clickAddQualification();
				cp.provideUniversity(candidate.university);
				cp.provideAcademicDegree(candidate.academicDegree);
				cp.provideMajorDegree(candidate.majorDegree);
				cp.provideYearOfPassing(candidate.yearOfPassing);
				cp.clickAddExperience();
				cp.provideJobTitle(candidate.jobTitle);
				cp.provideCompany(candidate.company);
				cp.provideStartDate(candidate.startDate);
				cp.provideEndDate(candidate.endDate);
				cp.provideWorkProfile(candidate.workProfile);
				cp.clickSave();

				Assert.assertTrue(cp.isTxnCreated());
			}
		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
