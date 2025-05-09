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

	@FindBy(xpath = "//img[@id='BenefitSchemeEncashment.EffectiveDate_B-1Img']")
	WebElement effectiveDateDD;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[5]/span[1]")
	WebElement monthYear;

	@FindBy(xpath = "//img[@id='BenefitSchemeEncashment.EffectiveDate_DDD_C_PMCImg']")
	WebElement previousMonth;

	@FindBy(xpath = "//input[@id='BenefitSchemeEncashment.EffectiveDate_I']")
	WebElement effectiveDate;

	@FindBy(xpath = "//img[@id='BenefitSchemeEncashment.EmployeeIdLookup_B-1Img']")
	WebElement empdd;

	@FindBy(xpath = "//div[contains(text(),'001 | Vaibhav Chavan')]")
	WebElement emp;

	@FindBy(xpath = "//img[@id='BenefitSchemeEncashment.EmployeeBenefitSchemeIdLookup_B-1Img']")
	WebElement benefitScemedd;

	@FindBy(css = "td[id='BenefitSchemeEncashment.EmployeeBenefitSchemeIdLookup_DDD_gv_tcrow0'] div[class='lookup-text']")
	WebElement benefitSceme;

	@FindBy(xpath = "//input[@id='BenefitSchemeEncashment.RequestedAmount_I']")
	WebElement requestedAmount;

	@FindBy(xpath = "//input[@id='BenefitSchemeEncashment.ApprovedAmount_I']")
	WebElement approvedAmount;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[8]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement filterCellReqAmt;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[8]")
	WebElement resultReqAmt;

	public void clkBenefitEncashment()
	{
		benefitSchemeEncashment.click();
	}

	public void clkNew()
	{
		clickOnNew();
	}

	public void clkEffectiveDateDD()
	{
		effectiveDateDD.click();
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
	public String effectivedt = "20-11-2024";

	public void slctEffectiveDate()
	{
		effectiveDate.clear();
		effectiveDate.sendKeys(effectivedt);
	}

	public void clkEmpDD() throws InterruptedException
	{
		empdd.click();
		Thread.sleep(4000);
	}

	public void slctEmp() throws InterruptedException
	{
		emp.click();
		Thread.sleep(2000);
	}

	public void clkBenefitScemeDD() throws InterruptedException
	{
		benefitScemedd.click();
		Thread.sleep(2000);
	}

	public void slctBenefitSceme() throws InterruptedException
	{
		benefitSceme.click();
		Thread.sleep(2000);
	}

	public void provideReqAmt()
	{
		requestedAmount.clear();
		requestedAmount.sendKeys("100");
	}

	public void provideApprovedAmt()
	{
		approvedAmount.clear();
		approvedAmount.sendKeys("100");
	}

	public void clkView()
	{
		clickOnView();
	}

	public void clkApprove() throws InterruptedException
	{
		clickOnApprove();
		Thread.sleep(2000);
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
