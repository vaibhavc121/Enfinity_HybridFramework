package pageObjects.HRMS.Payroll.Setups;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalaryComponentPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[text()='Salary Component']")
    private WebElement salaryComponent;

    @FindBy(xpath = "//input[@id='SalaryComponent.Name_I']")
    private WebElement name;

    @FindBy(id = "SalaryComponent.EarningOrDeduction_I")
    private WebElement earningOrDeduction;

    @FindBy(id = "SalaryComponent.ComputationType_I")
    private WebElement computationType;

    @FindBy(id = "SalaryComponent.CalculationMethod_I")
    private WebElement calculationMethod;

    @FindBy(id = "SalaryComponent.SalaryComponentGroupIdLookup_I")
    private WebElement salaryComponentGroup;
    //endregion

    //region Action Methods
    public void clickSalaryComponent()
    {
        clickOnElement1(salaryComponent);
    }

    public void clickNew()
    {
        clickOnNew();
    }

    public void provideName(String compName)
    {
        clearAndProvide1(name, compName);
    }
    public void selectEarningOrDeduction(String type)
    {
        clickOnElement1(earningOrDeduction);
        selectDropdownValueOffice365(type);
    }
    public void selectComputationType(String type)
    {
        clickOnElement1(computationType);
        selectDropdownValueOffice365(type);
    }
    public void selectCalculationMethod(String method)
    {
        clickOnElement1(calculationMethod);
        selectDropdownValueOffice365(method);
    }
    public void selectSalaryComponentGroup(String group)
    {
        provideAndEnter(salaryComponentGroup, group);
        waitTS(2);
    }
    //endregion
}