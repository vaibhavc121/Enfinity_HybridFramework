package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.BaseTest;
import utilities.CommonActions;

public class DeptPage extends BasePage
{

    public DeptPage(WebDriver driver)
    {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    @FindBy(xpath = "//input[@id='Department.Name_I']")
    WebElement deptName;

    @FindBy(xpath = "//img[@id='EmployeeSelfService_CBImg']")
    WebElement selfService;

    @FindBy(xpath = "//img[@id='Department.ManagerEmployeeIdLookup_B-1Img']")
    WebElement deptMgrDD;

    @FindBy(xpath = "//div[@class='lookup-text']")
    WebElement deptMgrName;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    WebElement save;

    @FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
    WebElement filterCell;

    @FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]/a[1]")
    WebElement result;

    public String deptNm = randomString();

    public void clickNew()
    {
        clickOnNew();
    }

    public void provideDepartmentName(String value)
    {
        
        deptName.sendKeys(value);
    }

    public void selfServiceDD()
    {
        selfService.click();
    }

    public void clickDeptMgrDD()
    {
        deptMgrDD.click();
    }

    public void selectDeptMgrName()
    {
        selectDropdownValue("Mary Kom");
    }

    public void selectDeptMgr()
    {
        deptMgrName.click();
    }

    public void clickSaveBack()
    {
        clickSaveAndBack();
        // or save.click(); if you prefer direct click
    }

    public boolean isDeptCreated()
    {
        return resultValue(2).contains(deptNm);
    }
}