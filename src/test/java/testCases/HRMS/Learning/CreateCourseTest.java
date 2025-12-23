package testCases.HRMS.Learning;

import factory.LoggerFactory;
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
            LearningPage lp = new LearningPage();
            lp.clickLearning();
            lp.clickCourse();

            // course page
            CoursePage cp = new CoursePage();

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
                for (SkillModel skill : course.skills)
                {
                    cp.clickAddSkillsBtn();
                    if (iteration == 1)
                    {
                        cp.provideSkillName1(skill.skillName);
                        cp.provideLevel1(skill.level);
                        cp.provideWeightage1(skill.weightage);
                    }
                    if (iteration == 2)
                    {
                        cp.provideSkillName2(skill.skillName);
                        cp.provideLevel2(skill.level);
                        cp.provideWeightage2(skill.weightage);
                    }
                    if (iteration == 3)
                    {
                        cp.provideSkillName3(skill.skillName);
                        cp.provideLevel3(skill.level);
                        cp.provideWeightage3(skill.weightage);
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
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}