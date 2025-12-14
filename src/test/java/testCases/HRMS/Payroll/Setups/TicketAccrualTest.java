package testCases.HRMS.Payroll.Setups;

import base.BasePage;

import base.BaseTest;
import factory.LoggerFactory;
import models.Payroll.Payroll.PayrollModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HRMS.Payroll.PayrollPage;
import pageObjects.HRMS.Payroll.Setups.TicketAccrualPage;
import utilities.BrowserUtils;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class TicketAccrualTest extends BaseTest
{
    String payrollFile = FileUtils.getDataFile("Payroll", "Payroll", "PayrollData");
    List<PayrollModel.TicketAccrualModel> ticketAccrualData = JsonUtils.convertJsonListDataModel(payrollFile, "ticketAccrual",
            PayrollModel.TicketAccrualModel.class);
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createTicketAccrual()
    {
        try
        {
            // payroll pg
            PayrollPage pp = new PayrollPage();
            pp.clkPayroll();
            log("clicked on payroll link");
            BasePage.clickSetups();
            log("clicked on setups link");

            //ticket accrual pg
            TicketAccrualPage ta = new TicketAccrualPage();
            ta.clickTicketAccrual();
            log("clicked on ticket accrual link");
            BasePage.clickOnNew();
            log("clicked on new btn");

            for (PayrollModel.TicketAccrualModel data : ticketAccrualData)
            {
                ta.enterName(data.name);
                log("entered name: " + data.name);

                ta.enterNumberOfTicket(data.numberOfTicket);
                log("entered number of ticket: " + data.numberOfTicket);

                ta.enterNumberOfYear(data.numberOfYear);
                log("entered number of year: " + data.numberOfYear);

                ta.enterEarningSalaryCom(data.earningSalaryComponent);
                log("selected earning salary component: " + data.earningSalaryComponent);

                if (data.includeUnpaidDaysInProvision)
                {
                    ta.clickIncludeUnpaidDayBtn();
                    log("selected include unpaid days in provision: " + data.includeUnpaidDaysInProvision);
                }

                ta.clickSave();
                log("clicked on save btn");

                ta.clickAgeWisePaymentSchedules();
                log("clicked on age wise payment schedules tab");

                ta.scrollPage();
                log("scrolled to age wise payment schedules section");

                /*
                //age wise payment schedule
                for (PayrollModel.AgeWisePaymentScheduleModel line : data.ageWisePaymentSchedules)
                {
                    ta.clickOnNewLine();
                    log("clicked on new line btn");

                    ta.provideTillAge(line.tillAge);
                    log("entered till age: " + line.tillAge);

                    ta.providePercentage(line.percentage);
                    log("entered percentage: " + line.percentage);
                }

                 */
                BasePage.clickViewAndBack();
                log("clicked on view btn and back to ticket accrual list");

                Assert.assertTrue(BasePage.validateListing(data.name, 2, 1), "Ticket Accrual creation failed: " + data.name);
                log("Verified: Ticket Accrual created successfully: " + data.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteTicketAccrual()
    {
        try
        {
            for (PayrollModel.TicketAccrualModel data : ticketAccrualData)
            {
                // payroll pg
                PayrollPage pp = new PayrollPage();
                pp.clkPayroll();
                log("clicked on payroll link");
                BasePage.clickSetups();
                log("clicked on setups link");

                // Ticket Accrual pg
                TicketAccrualPage ta = new TicketAccrualPage();
                ta.clickTicketAccrual();
                log("clicked on ticket accrual link");

                BasePage.performAction(2, data.name, "Delete");
                BrowserUtils.navigateBack(BaseTest.getDriver());
                Assert.assertFalse(BasePage.validateListing(data.name, 2, 1), "Ticket Accrual deletion failed: " + data.name);
                log("Verified: Ticket Accrual deleted successfully: " + data.name);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}