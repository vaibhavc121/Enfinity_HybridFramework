package pageObjects.HRMS.SelfService;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class ExpenseClaimPage extends BasePage
{

	public ExpenseClaimPage(WebDriver driver)
	{
		super(driver);

	}

	// Locators
	@FindBy(xpath = "//span[normalize-space()='Expense Claim']")
	WebElement expenseClaim;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-new-icon']")
	WebElement newLine;

	@FindBy(xpath = "/html[1]/body[1]/div[7]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[5]/td[2]/div[1]")
	WebElement expenseDate;

	@FindBy(xpath = "//td[contains(@class,'grid-cell hide-error-frame dx-wrap dxgv dx-ellipsis')]//div[@class='dxgBCTC dx-ellipsis']")
	WebElement remarks;

	@FindBy(xpath = "//input[@id='ExpenseClaimLine_ExpenseClaimCategoryId_I']")
	WebElement expenseClaimCategory;

	@FindBy(xpath = "//input[@id='ExpenseClaimLine_CurrencyId_I']")
	WebElement expenseClaimLineCurrency;

	@FindBy(xpath = "//td[@class=' grid-cell dx-wrap dxgv dx-ellipsis dx-ar']//div[@class='dxgBCTC dx-ellipsis'][normalize-space()='0']")
	WebElement amount;

	// Action Methods
	public void clickExpenseClaim()
	{
		expenseClaim.click();
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
		expenseDate.click();
		provideValue(expenseDate, value);
	}

	public void provideRemarks(String value)
	{
		remarks.click();
		provideValue(remarks, value);
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
