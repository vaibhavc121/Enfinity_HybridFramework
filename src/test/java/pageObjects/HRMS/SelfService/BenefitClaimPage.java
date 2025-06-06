package pageObjects.HRMS.SelfService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class BenefitClaimPage extends BasePage
{

	public BenefitClaimPage(WebDriver driver)
	{
		super(driver);

	}

	// Locators
	@FindBy(xpath = "//a[@id='TxnInstanceView_I0i19_T']//span[@class='dx-vam'][normalize-space()='Profile Update']")
	WebElement profileUpdate;

	@FindBy(xpath = "//span[normalize-space()='Benefit Claim']")
	WebElement benefitClaim;

	@FindBy(xpath = "//input[@id='BenefitClaim.ClaimDate_I']")
	WebElement claimDate;

	@FindBy(xpath = "//input[@id='BenefitClaim.EmployeeBenefitSchemeIdLookup_I']")
	WebElement EmpBenefitScheme;

	@FindBy(xpath = "//input[@id='BenefitClaim.ClaimAmount_I']")
	WebElement claimAmount;

	@FindBy(xpath = "//input[@id='BenefitClaim.PaymentType_I']")
	WebElement paymentType;

	@FindBy(xpath = "//textarea[@id='BenefitClaim.Description_I']")
	WebElement remarks;

	// Action Methods
	public void scrollDownWebpage()
	{
		scrollDownWebPage(profileUpdate);
	}

	public void clickBenefitClaim()
	{
		benefitClaim.click();
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideClaimDate(String value)
	{
		clearAndProvide1(claimDate, value);
	}

	public void provideBenefitScheme(String value)
	{
		clearAndProvide1(EmpBenefitScheme, value);
	}

	public void provideClaimAmt(String value)
	{
		claimAmount.sendKeys(value);
	}

	public void providePaymentType(String value)
	{
		clearAndProvide1(paymentType, value);
	}

	public void provideRemarks(String value)
	{
		remarks.sendKeys(value);
	}

	public void clickSave()
	{
		clickSaveAndBack();
		// clickSave();
	}

	public boolean isTxnCreated(String emp, String claimAmt)
	{
		if (resultValue(6).contains(emp) && resultValue(8).contains(claimAmt))
		{
			return true;
		} else
		{
			return false;
		}
	}
}
