package pageObjects.HRMS.Payroll.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[text()='Project']")
    private WebElement project;

    @FindBy(xpath = "//input[@id='Project.Name_I']")
    private WebElement name;

    @FindBy(id = "Project.ProjectGroupIdLookup_I")
    private WebElement projectGroup;

    @FindBy(id = "Project.ProjectManagerEmployeeIdLookup_I")
    private WebElement projectManagerEmployee;
    //endregion

    //region Action Methods
    public void clickProject()
    {
        clickOnElement1(project);
    }
    public void enterName(String projName)
    {
        clearAndProvide1(name, projName);
    }
    public void selectProjectGroup(String projGroup)
    {
        provideAndEnter(projectGroup, projGroup);
    }
    public void selectProjectManagerEmployee(String projManagerEmp)
    {
        provideAndEnter(projectManagerEmployee, projManagerEmp);
    }
    //endregion
}