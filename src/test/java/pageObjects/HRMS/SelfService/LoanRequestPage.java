package pageObjects.HRMS.SelfService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoanRequestPage extends BasePage
{

	public LoanRequestPage(WebDriver driver)
	{
		super(driver);

	}

	// Locators
	@FindBy(xpath = "//span[normalize-space()='Loan Request']")
	WebElement loanRequest;

	@FindBy(xpath = "(//i[@class='dx-icon dx-icon-plus'])[2]")
	WebElement plusBtn;

	@FindBy(xpath = "(//div[@class='dx-trackbar-container dx-slider-bar'])[1]")
	WebElement slider;

	@FindBy(css = "input[aria-label='Loan Amount Slider Value']")
	WebElement loanAmount;

	@FindBy(xpath = "//input[@aria-label='Slider Value']")
	WebElement installmentAmt;

	@FindBy(xpath = "//input[contains(@id,'RepaymentStartPeriodId')]")
	WebElement emiDD;

	// Action Methods
	public void clickLoanRequest()
	{
		loanRequest.click();
	}

	public void clickNew()
	{
		waitTS(3);
		clickOnNew();
		waitTS(5);
	}

	public void clickPlusBtn()
	{
		hoverOverElement(plusBtn);
		plusBtn.click();
	}

	public void provideLoanAmt(String value)
	{
		clearAndProvide1(loanAmount, value);
	}

	public void provideInstallmentAmt(String value)
	{
		clearAndProvide1(installmentAmt, value);
	}

	public void selectRepaymentStartPeriod(String value)
	{
		emiDD.click();
		selectDropdownOption(value);
	}

	public void provideRemarks(String value)
	{
		provideDescription(value);
	}

	public void clickSave()
	{
		clickSaveAndBack();
	}

	public boolean isTxnCreated(String loanType, String loanAmt)
	{
		return resultValue(6).contains(loanType) && resultValue(6).contains(loanAmt);
	}

}
