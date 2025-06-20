package pages.HRMS;

import base.BasePage;
import base.SelenideBasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class VariableSalaryPage extends SelenideBasePage
{

    private SelenideElement variableSalary = $x("(//span[text()='Variable Salary'])[2]");
    private SelenideElement empdd = $x("//input[@id='VariableSalary.EmployeeIdLookup_I']");
    private SelenideElement effectiveDate = $x("//input[@id='VariableSalary.EffectiveDate_I']");
    private SelenideElement remarks = $("#VariableSalary.Description_I");
    private SelenideElement save = $x("//span[normalize-space()='Save']");
    private SelenideElement newLine = $x("//i[@class='dx-icon dx-icon-new-icon']");
    private SelenideElement SalaryCompo = $x("//input[@id='VariableSalaryLine_SalaryComponentId_I']");
    private SelenideElement amtfield = $x("//td[@class=' grid-cell dx-wrap dxgv dx-ellipsis dx-ar']//div[@class='dxgBCTC dx-ellipsis'][normalize-space()='0']");
    private SelenideElement viewbtn = $x("//span[normalize-space()='View']");
    private SelenideElement approvebtn = $x("//span[normalize-space()='Approve']");
    private SelenideElement variablesal = $x("//a[normalize-space()='Variable Salary']");

    public void clkVariableSal()
    {
        variableSalary.click();
    }

    public void clkNewBtn()
    {
        clickOnNew();
    }

    public void provideEmp(String value)
    {
        clearAndProvide1(empdd, value);
    }

    public void provideEffectiveDate(String value)
    {
        clearAndProvide1(effectiveDate, value);
    }

    public void provideRemarks(String value)
    {
        remarks.setValue(value);
    }

    public void clkSave() throws InterruptedException
    {
        clickOnSave();
        Thread.sleep(2000);
    }

    public void clkNewline()
    {
        clickOnNewLine();
    }

    public void provideSalaryComp(String value)
    {
        waitTS(2);
        provideAndEnter(SalaryCompo, value);
    }

    public void provideAmt(String value) throws InterruptedException
    {

        clearAndProvide2(amtfield, value);
        clickOnSave();
    }

    public void clkViewBtn()
    {
        viewbtn.click();
        waitTS(2);
    }

    public void clkApproveBack()
    {
        clickApproveAndBack();
    }
}