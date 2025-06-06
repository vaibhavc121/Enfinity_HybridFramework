package pageObjects.HRMS.SelfService;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class SupportRequestCategoryPage extends BasePage
{

	public SupportRequestCategoryPage(WebDriver driver)
	{
		super(driver);

	}

	// Locators

	// Action Methods

	@FindBy(name = "Name")
	WebElement name;

	@FindBy(xpath = "//input[contains(@id,'RequestTo')]")
	WebElement requestTo;

	@FindBy(xpath = "Low")
	WebElement low;

	@FindBy(xpath = "Normal")
	WebElement normal;

	@FindBy(xpath = "//div[text()='High']")
	WebElement high;

	@FindBy(xpath = "//input[contains(@id,'WorkflowId')]")
	WebElement workflow;

	@FindBy(xpath = "//span[normalize-space()='Submit']")
	WebElement submit;

	@FindBy(xpath = "//span[normalize-space()='Approve']")
	WebElement approve;

	@FindBy(xpath = "//textarea[contains(@id,'Description')]")
	WebElement description;

	public void globalSearch1(String expectedValue) throws InterruptedException
	{
		WebElement globalSearchInput = driver.findElement(By.id("GlobalSearch"));
		globalSearchInput.click();

		WebElement comboBoxInput = driver.findElement(By.xpath("//input[@role='combobox']"));
		comboBoxInput.sendKeys(expectedValue);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[normalize-space()='Support Request Category']")).click();
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideCategoryname(String value)
	{
		name.sendKeys(value);
	}

	public void selectRequestedTo(String value)
	{
		requestTo.click();
		selectDropdownOption(value);
	}

	public void selectPriority(String value)
	{
		if (value.contains("High"))
		{
			high.click();
		} else if (value.contains("Normal"))
		{
			normal.click();
		} else if (value.contains("Low"))
		{
			low.click();
		} else
		{
			low.click();
			throw new RuntimeException("VRC- Matching priority not found");
		}
	}

	public void selectWorkflow(String value)
	{
		provideAndEnter(workflow, value);
	}

	public void requireAttachment(String value)
	{
		if (value.contains("Submit"))
		{
			submit.click();
		} else if (value.contains("Approve"))
		{
			approve.click();
		} else
		{
			throw new RuntimeException("VRC- no matching value found");
		}
	}

	public void provideDesc(String value)
	{
		description.sendKeys(value);
	}

	public void clickSaveBack()
	{
		clickSaveAndBack();
	}

	public boolean isTransactionCreated(String expDate, String expEmp, String expStatus) throws InterruptedException
	{
		if (expDate != null && !expDate.isEmpty())
		{
			filterDateByIndex(2, expDate);
			Thread.sleep(2000);
		}
		if (expEmp != null && !expEmp.isEmpty())
		{
			filterByIndex(2, expEmp);
			Thread.sleep(2000);
		}
		if (expStatus != null && !expStatus.isEmpty())
		{
			filterByIndex(7, expStatus);
			Thread.sleep(2000);
		}

		boolean isMatch = true;

		if (expDate != null && !expDate.isEmpty())
		{
			String actualDate = resultValue(2);
			isMatch &= actualDate.contains(expDate);
		}
		if (expEmp != null && !expEmp.isEmpty())
		{
			String actualEmp = resultValue(1);
			isMatch &= actualEmp.contains(expEmp);
		}
		if (expStatus != null && !expStatus.isEmpty())
		{
			String actualStatus = resultValue(7);
			isMatch &= actualStatus.contains(expStatus);
		}
		return isMatch;
	}

	public void deleteTransaction(int index, String value) throws InterruptedException
	{
		filterByIndex(index, value);
		Thread.sleep(2000);

		try
		{
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]"))
					.click();
		} catch (Exception e)
		{
			throw new RuntimeException("Vaibhav- There is no active records..");
		}

		clickOnEdit();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//img[@class='dxWeb_mAdaptiveMenu_Office365 dxm-pImage'])[8]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Delete']")).click();
		Thread.sleep(1000);
		pressKey("enter");
	}

}
