package testCases.HRMS.Global;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import base.BasePage;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HRMS.Attendance.AttendancePage;
import pageObjects.HRMS.Global.TopNavigationBar;
import pageObjects.HRMS.HRCore.HRCorePage;
import pageObjects.HRMS.Learning.LearningPage;
import pageObjects.HRMS.Onboarding.OnboardingPage;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Performance.PerformancePage;
import pageObjects.HRMS.Recruitment.RecruitmentPage;
import pageObjects.HRMS.SelfService.SelfServicePage;
import pageObjects.HRMS.SuccessionPlanning.SuccessionPage;
import utilities.BrokenLinksUtils;

public class BrokenLinksTest extends BaseTest
{
    public static int totalBrokenLinks = 0;
    public static int totalNonBrokenLinks = 0;
    @Test(groups = "regression")
    public void findBrokenLinks() throws InterruptedException
    {

        //region HR Core
        HRCorePage hc = new HRCorePage();
        hc.clickHRCore();
        log("Clicked on HR Core module");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickReports();
        log("Clicked on Reports");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickAnalytics();
        log("Clicked on Analytics");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickSetups();
        log("Clicked on Setups");
        BrokenLinksUtils.checkBrokenLinks();
        //endregion

        //region Payroll
        System.out.print("----------------Payroll----------------");
        PayrollPage pp = new PayrollPage();
        pp.clkPayroll();
        log("clicked on payroll module");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickReports();
        log("Clicked on Reports");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickAnalytics();
        log("Clicked on Analytics");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickSetups();
        log("Clicked on Setups");
        BrokenLinksUtils.checkBrokenLinks();

        pp.clkTxn();
        log("clicked on Transactions");
        BrokenLinksUtils.checkBrokenLinks();
        //endregion

        //region Self Service
        log("----------------Self Service----------------");
        SelfServicePage ss = new SelfServicePage();
        ss.clickSelfService();
        log("Clicked on Self Service module");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickReports();
        log("Clicked on Reports");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickSetups();
        log("Clicked on Setups");
        BrokenLinksUtils.checkBrokenLinks();

        ss.clickTransactions();
        log("Clicked on Transactions");
        BrokenLinksUtils.checkBrokenLinks();
        //endregion

        //region Attendance
        log("----------------Attendance----------------");
        AttendancePage ap = new AttendancePage();
        ap.clickAttendance();
        log("Clicked on Attendance module");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickReports();
        log("Clicked on Reports");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickAnalytics();
        log("Clicked on Analytics");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickSetups();
        log("Clicked on Setups");
        BrokenLinksUtils.checkBrokenLinks();
        //endregion

        //region Performance
        log("----------------Performance----------------");
        PerformancePage pf = new PerformancePage();
        pf.clickPerformance();
        log("Clicked on Performance module");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickReports();
        log("Clicked on Reports");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickAnalytics();
        log("Clicked on Analytics");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickSetups();
        log("Clicked on Setups");
        BrokenLinksUtils.checkBrokenLinks();
        //endregion

        //region Learning
        log("----------------Learning----------------");
        LearningPage lp = new LearningPage();
        lp.clickLearning();
        log("Clicked on Learning module");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickReports();
        log("Clicked on Reports");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickAnalytics();
        log("Clicked on Analytics");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickSetups();
        log("Clicked on Setups");
        BrokenLinksUtils.checkBrokenLinks();
        //endregion

        //Recruitment
        log("----------------Recruitment----------------");
        RecruitmentPage rp = new RecruitmentPage();
        rp.clickRecruitment();
        log("Clicked on Recruitment module");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickReports();
        log("Clicked on Reports");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickAnalytics();
        log("Clicked on Analytics");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickSetups();
        log("Clicked on Setups");
        BrokenLinksUtils.checkBrokenLinks();
        //endregion

        //region Onboarding
        log("----------------Onboarding----------------");
        OnboardingPage ob = new OnboardingPage();
        ob.clickOnboarding();
        log("Clicked on Onboarding module");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickReports();
        log("Clicked on Reports");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickAnalytics();
        log("Clicked on Analytics");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickSetups();
        log("Clicked on Setups");
        BrokenLinksUtils.checkBrokenLinks();
        //endregion

        //region Succession Planning
        log("----------------Succession Planning----------------");
        SuccessionPage sp = new SuccessionPage();
        sp.clickSuccessionPlanning();
        log("Clicked on Succession Planning module");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickReports();
        log("Clicked on Reports");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickAnalytics();
        log("Clicked on Analytics");
        BrokenLinksUtils.checkBrokenLinks();

        BasePage.clickSetups();
        log("Clicked on Setups");
        BrokenLinksUtils.checkBrokenLinks();
        //endregion

        //region Global Settings
        log("----------------Global Settings----------------");
        TopNavigationBar tnb = new TopNavigationBar();
        tnb.clickGlobalSettingsIcon();
        log("Clicked on Global Settings icon");
        BrokenLinksUtils.checkBrokenLinks();
        //endregion

        log("Total broken links: " + totalBrokenLinks);
        log("Total non broken links: " + totalNonBrokenLinks);

        if (totalBrokenLinks > 0)
        {
            Assert.fail("There are broken links on the page");
        }
    }
}