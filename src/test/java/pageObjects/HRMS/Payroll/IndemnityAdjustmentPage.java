package pageObjects.HRMS.Payroll;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class IndemnityAdjustmentPage extends BasePage
{

    @FindBy(xpath = "//span[contains(text(),'Indemnity Adjustment')]")
    WebElement indemnityAdjustment;

    @FindBy(xpath = "//input[@id='GratuityAdjustment.EffectiveDate_I']")
    private WebElement effectiveDate;

    @FindBy(xpath = "//input[@id='GratuityAdjustment.EmployeeIdLookup_I']")
    private WebElement empdd;

    @FindBy(xpath = "//input[@id='GratuityAdjustment.GratuityIdLookup_I']")
    private WebElement indemnityDD;

    @FindBy(xpath = "//input[@id='GratuityAdjustment.PaidDays_I']")
    private WebElement paidDays;

    @FindBy(xpath = "//a[normalize-space()='Indemnity Adjustment']")
    private WebElement indemnityAdjustmentLabel;

//	String IndemnityBal=DriverFactory.getDriver().findElement(By.xpath("//input[@id='GratuityAdjustment.GratuityBalance_I")).getText();
//	int actIndBalInt=Integer.parseInt(IndemnityBal);
//	int expindbal=actIndBalInt-1;

    public void clkIndemnityAdjustment()
    {
        indemnityAdjustment.click();
    }

    public void clkNewBtn()
    {
        clickOnNew();
    }

    public void provideEffectiveDate(String value)
    {
        clearAndProvide1(effectiveDate, value);
    }

    public void provideEmployee(String value)
    {
        provideAndEnter(empdd, value);
    }

    public void provideIndemnity(String value)
    {
        provideAndEnter(indemnityDD, value);
    }

    public void providePaidDays(String value)
    {
        clearAndProvide1(paidDays, value);
    }

    public void clkView()
    {
        clickOnViewTxn();
    }

    public void clkApprove() throws InterruptedException
    {
        clickOnApprove();
        DriverFactory.getDriver().navigate().back();
        Thread.sleep(3000);
    }

    public void clickIndemnityAdjustmentLabel()
    {
        clickOnElement1(indemnityAdjustmentLabel);
    }
}