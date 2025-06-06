package pageObjects.HRMS.SelfService;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class BusinessTripClaimPage extends BasePage
{

	public BusinessTripClaimPage(WebDriver driver)
	{
		super(driver);

	}

	// Locators
	@FindBy(xpath = "//span[normalize-space()='Business Trip Claim']")
	WebElement businessTripClaim;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-new-icon']")
	WebElement newLine;

	@FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[1]")
	WebElement expenseDate;

	@FindBy(xpath = "//td[contains(@class,'grid-cell hide-error-frame dx-wrap dxgv dx-ellipsis')]//div[@class='dxgBCTC dx-ellipsis']")
	WebElement remarks;

	@FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[3]")
	WebElement expenseClaimCategory;

	@FindBy(xpath = "//input[@id='ExpenseClaimLine_CurrencyId_I']")
	WebElement expenseClaimLineCurrency;

	@FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[6]")
	WebElement amount;

	// Action Methods
	public void clickBusinessTripClaim()
	{
		businessTripClaim.click();
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void clickSave()
	{
		clickOnSave();
	}

	public void scrollDownWebPage()
	{
		scrollDownWebPage(newLine);
	}

	public void clickNewLine()
	{
		newLine.click();
	}

	public void provideExpenseDate(String value)
	{
		clearAndProvide1(expenseDate, value);
	}

	public void provideRemarks(String value)
	{
		clearAndProvide1(remarks, value);
	}

	public void provideExpenseClaimCategory(String value)
	{
		clearAndProvide1(expenseClaimCategory, value);
	}

	public void clickExpenseClaimCategoryDD()
	{
		expenseClaimCategory.click();
	}

	public void selectExpenseClaimCategory(String value)
	{
		List<WebElement> valuesList = driver.findElements(By.xpath("//div[@class='lookup-text']"));
		for (WebElement valueElement : valuesList)
		{
			String actualValue = valueElement.getText();
			if (actualValue.contains(value))
			{
				valueElement.click();
				break;
			}
		}
	}

	public void provideCurrency(String value)
	{
		expenseClaimLineCurrency.click();
		List<WebElement> valuesList = driver.findElements(By.xpath("//div[@class='lookup-text']"));
		for (WebElement valueElement : valuesList)
		{
			String actualValue = valueElement.getText();
			if (actualValue.contains(value))
			{
				valueElement.click();
				break;
			}
		}
	}

	public void provideAmount(String value)
	{
		clearAndProvide1(amount, value);
	}

	public boolean isTxnCreated()
	{
		return isTransactionCreated();
	}
}
