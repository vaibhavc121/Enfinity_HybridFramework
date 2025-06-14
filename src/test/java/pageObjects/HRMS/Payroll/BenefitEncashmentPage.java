package pageObjects.HRMS.Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class BenefitEncashmentPage extends BasePage
{

    public BenefitEncashmentPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Benefit Scheme Encashment']")
    WebElement benefitSchemeEncashment;

    @FindBy(xpath = "//input[@id='BenefitSchemeEncashment.EffectiveDate_I']")
    WebElement effectiveDate;

    @FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[5]/span[1]")
    WebElement monthYear;

    @FindBy(xpath = "//img[@id='BenefitSchemeEncashment.EffectiveDate_DDD_C_PMCImg']")
    WebElement previousMonth;

    @FindBy(xpath = "//input[@id='BenefitSchemeEncashment.EmployeeIdLookup_I']")
    WebElement empdd;

    @FindBy(xpath = "//input[@id='BenefitSchemeEncashment.EmployeeBenefitSchemeIdLookup_I']")
    WebElement benefitSchemeDD;

    @FindBy(xpath = "//input[@id='BenefitSchemeEncashment.RequestedAmount_I']")
    WebElement requestedAmount;

    @FindBy(xpath = "//input[@id='BenefitSchemeEncashment.ApprovedAmount_I']")
    WebElement approvedAmount;

    @FindBy(xpath = "//input[@id='BenefitSchemeEncashment.PaymentType_I']")
    WebElement paymentType;

    public void clkBenefitEncashment()
    {
        benefitSchemeEncashment.click();
    }

    public void clkNew()
    {
        clickOnNew();
    }

    public void provideEffectiveDate(String value)
    {
        clearAndProvide1(effectiveDate, value);
    }

//	public void slctEffectiveDate()
//	{
//		String expMonthYear="December 2023";
//		String expMonth="Oct";
//		String expYear="2023";
//		String expDate="21";
//
//		String monthYear=driver.findElement(By.id("//span[@id='BenefitSchemeEncashment.EffectiveDate_DDD_C_T']")).getText();
//		List<WebElement> allDates= driver.findElements(By.xpath("//table[@id='BenefitSchemeEncashment.EffectiveDate_DDD_C_mt']/tbody/tr/td"));
//
//
//
//		while(!monthYear.equals(expMonthYear))
//		{
//			previousMonth.click();
//		}
//
//		for(WebElement date: allDates)
//		{
//			String actdate=date.getText();
//			if(expDate.equals(actdate))
//			{
//				date.click();
//			}
//		}
//
//
//	}

    public void provideEmp(String value) throws InterruptedException
    {
        clearAndProvide1(empdd, value);
    }

    public void provideBenefitScheme(String value) throws InterruptedException
    {
        clearAndProvide1(benefitSchemeDD, value);
    }

    public void provideReqAmt(String value)
    {
        clearAndProvide1(requestedAmount, value);
    }

    public void provideApprovedAmt(String value)
    {
        clearAndProvide1(approvedAmount, value);
    }

    public void selectPaymentType(String value)
    {
        selectDropdownValueOffice365(value);
    }

    public void provideRemarks(String value)
    {
        provideDescription(value);
    }

    public void clkView()
    {
        clickOnView();
    }

    public void clkApproveBack() throws InterruptedException
    {
        clickApproveAndBack();
    }

    public boolean isTxnCreated()
    {
        String expemp = "Vaibhav Chavan";
        String expBenefitSceme = "Health Insurance";
        String expapprovedAmt = "100";
        String expEffectiveDate = "20-Nov-2024"; // can replace effectivedt
        CommonActions.filterCell5(expEffectiveDate);
        CommonActions.filterCell6(expemp);
        CommonActions.filterCell7(expBenefitSceme);
        CommonActions.filterCell9(expapprovedAmt);

        if (CommonActions.result5().contains(expEffectiveDate) && CommonActions.result6().contains(expemp)
                && CommonActions.result7().contains(expBenefitSceme)
                && CommonActions.result9().contains(expapprovedAmt))
        // if(CommonActions.result6().contains(expemp) &&
        // CommonActions.result7().equals(expBenefitSceme))
        {
            return true;
        } else
        {
            return false;
        }
    }
}