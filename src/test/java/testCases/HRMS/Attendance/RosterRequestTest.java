package testCases.HRMS.Attendance;

import base.BaseTest;
import org.testng.annotations.Test;
import utilities.RetryAnalyzer;

public class RosterRequestTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void createRosterRequest()
    {
    }

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void deleteRosterRequest()
    {
    }
}