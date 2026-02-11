package pageObjects.HRMS.Attendance;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RosterRequestPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//label[normalize-space()='Roster Request']")
    private WebElement rosterRequest;

    @FindBy(id = "RosterRequest.FromDate_I")
    private WebElement fromDate;

    @FindBy(id = "RosterRequest.ToDate_I")
    private WebElement toDate;

    @FindBy(id = "RosterRequest.TimetableIdLookup_I")
    private WebElement timetable;

    @FindBy(id = "RosterRequest.EmployeeIds_I")
    private WebElement employee;
    //endregion

    //region Action Methods
    public void clickRosterRequest()
    {
        clickOnElement1(rosterRequest);
    }
    public void enterFromDate(String date)
    {
        clearAndProvide1(fromDate, date);
    }
    public void enterToDate(String date)
    {
        clearAndProvide1(toDate, date);
    }
    public void enterTimetable(String timetableName)
    {
        clearAndProvide1(timetable, timetableName);
    }
    public void enterEmployee(String employeeName)
    {
        provideAndEnter(employee, employeeName);
    }
    //endregion
}