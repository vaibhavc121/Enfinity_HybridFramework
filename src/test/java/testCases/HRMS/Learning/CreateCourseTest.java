package testCases.HRMS.Learning;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import models.Learning.Learning.LearningModel.CourseModel;
import models.Learning.Learning.LearningModel.CourseModel.SkillModel;
import base.BasePage;
import pageObjects.HRMS.Learning.CoursePage;
import pageObjects.HRMS.Learning.LearningPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;
import java.util.List;

public class CreateCourseTest extends BaseTest
{
	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void createCourse()
	{
		try
		{
			String learningFile = FileUtils.getDataFile("Learning", "Learning", "LearningData");
			List<CourseModel> courseData = JsonUtils.convertJsonListDataModel(learningFile, "createCourse",
					CourseModel.class);

			// learning page
			LearningPage lp = new LearningPage(driver);
			lp.clickLearning();
			lp.clickCourse();

			// course page
			CoursePage cp = new CoursePage(driver);

			for (CourseModel course : courseData)
			{
				cp.clickNew();
				cp.provideCourseName(course.courseName);
				cp.provideCategory(course.category);
				cp.provideMode(course.mode);
				cp.provideCourseTrainer(course.courseTrainer);
				cp.provideType(course.type);
				cp.provideEnroller(course.enroller);

				int iteration = 1;
				for (SkillModel skill : course.Skills)
				{
					cp.clickAddSkillsBtn();
					if (iteration == 1)
					{
						cp.provideSkillName1(skill.SkillName);
						cp.provideLevel1(skill.Level);
						cp.provideWeightage1(skill.Weightage);
					}
					if (iteration == 2)
					{
						cp.provideSkillName2(skill.SkillName);
						cp.provideLevel2(skill.Level);
						cp.provideWeightage2(skill.Weightage);
					}
					if (iteration == 3)
					{
						cp.provideSkillName3(skill.SkillName);
						cp.provideLevel3(skill.Level);
						cp.provideWeightage3(skill.Weightage);
					}
					iteration++;
				}

				cp.scrollWebPage();
				cp.clickAddBatch();
				cp.provideBatchName(course.batchName);
				cp.provideStartDate(course.startDate);
				cp.provideEndDate(course.endDate);
				cp.clickSaveBack();

				Assert.assertTrue(true);
			}

		} catch (Exception e)
		{
			logger.error("Test failed due to exception: ", e);
			Assert.fail("Test case failed: " + e);
		}
	}

}
