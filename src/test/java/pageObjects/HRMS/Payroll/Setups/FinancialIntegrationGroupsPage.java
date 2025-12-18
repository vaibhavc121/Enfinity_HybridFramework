package pageObjects.HRMS.Payroll.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinancialIntegrationGroupsPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[text()='Financial Integration Group']")
    private WebElement financialIntegrationGroup;
    @FindBy(xpath = "//input[@id='FinancialIntegrationGroup.Name_I']")
    private WebElement name;
    @FindBy(xpath = "//input[@id='FinancialIntegrationGroup.Segment1_I']")
    private WebElement division;
    @FindBy(xpath = "//input[@id='FinancialIntegrationGroup.Segment2_I']")
    private WebElement department;
    @FindBy(xpath = "//input[@id='FinancialIntegrationGroup.Segment3_I']")
    private WebElement project;
    @FindBy(xpath = "//input[@id='FinancialIntegrationGroup.Segment4_I']")
    private WebElement workLocation;
    //endregion

    //region Action Methods
    public void clickfFinancialIntegrationGroup()
    {
        clickOnElement1(financialIntegrationGroup);
    }

    public void provideName(String fname)
    {
        clearAndProvide1(name, fname);
    }
    public void provideDivision(String fdivision)
    {
        clearAndProvide1(division, fdivision);
    }
    public void provideDepartment(String fdepartment)
    {
        clearAndProvide1(department, fdepartment);
    }
    public void provideProject(String fproject)
    {
        clearAndProvide1(project, fproject);
    }
    public void provideWorkLocation(String fworkLocation)
    {
        clearAndProvide1(workLocation, fworkLocation);
    }
    //endregion
}