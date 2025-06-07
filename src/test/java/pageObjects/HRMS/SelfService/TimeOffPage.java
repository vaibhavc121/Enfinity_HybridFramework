package pageObjects.HRMS.SelfService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class TimeOffPage extends BasePage
{

	public TimeOffPage(WebDriver driver)
	{
		super(driver);

	}

	// Locators

	// Action Methods

	@FindBy(xpath = "(//span[text()='Time Off'])[2]")
	WebElement timeOff;

	@FindBy(xpath = "//input[contains(@id,'LateDate')]")
	WebElement permissionDate;

	@FindBy(xpath = "(//div[@class='dx-item-content'])[1]")
	WebElement personal;

	@FindBy(xpath = "(//div[@class='dx-item-content'])[2]")
	WebElement business;

	@FindBy(xpath = "(//div[@class='dx-item-content'])[3]")
	WebElement leave;

	@FindBy(xpath = "//input[contains(@id,'FromTime')]")
	WebElement fromTimeField;

	@FindBy(xpath = "//input[contains(@id,'UptoTime')]")
	WebElement uptoTime;

	@FindBy(xpath = "//input[@aria-label='hours']")
	WebElement hrs;

	@FindBy(xpath = "//input[@aria-label='minutes']")
	WebElement minutes;

	@FindBy(xpath = "//div[@class='dx-dropdowneditor-input-wrapper dx-selectbox-container']//div[@class='dx-dropdowneditor-icon']")
	WebElement timeNotation;

	@FindBy(xpath = "//div[text()='AM']")
	WebElement AM;

	@FindBy(xpath = "//div[text()='PM']")
	WebElement PM;

	@FindBy(xpath = "//input[@aria-label='hours']")
	WebElement hrs1;

	@FindBy(xpath = "//input[@aria-label='minutes']")
	WebElement minutes1;

	@FindBy(xpath = "//div[@class='dx-dropdowneditor-input-wrapper dx-selectbox-container']//div[@class='dx-dropdowneditor-icon']")
	WebElement timeNotation1;

	@FindBy(xpath = "//div[text()='AM']")
	WebElement AM1;

	@FindBy(xpath = "//div[text()='PM']")
	WebElement PM1;

	@FindBy(xpath = "//textarea[contains(@id,'Description')]")
	WebElement description;

	@FindBy(xpath = "(//tr)[12]//td[2]")
	WebElement selectRow;

	@FindBy(xpath = "//img[@id='MainMenu_DXI18_PImg']")
	WebElement contextMenu;

	@FindBy(xpath = "//span[normalize-space()='Delete']")
	WebElement delete;

	@FindBy(xpath = "//div[@aria-label='Ok']//div[@class='dx-button-content']")
	WebElement ok;

	@FindBy(xpath = "//span[normalize-space()='Ok']")
	WebElement ok1;

	public void clickTimeOff()
	{
		timeOff.click();
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void providePermissonDate(String value)
	{
		clearAndProvide1(permissionDate, value);
	}

	public void clickPersoanl()
	{
		personal.click();
	}

	public void clickBusiness()
	{
		business.click();
	}

	public void clickLeave()
	{
		leave.click();
	}

	public void clickFromTimeField()
	{
		fromTimeField.click();
	}

	public void provideHrs(String value)
	{
		clearAndProvide1(hrs, value);
	}

	public void provideMinutes(String value)
	{
		clearAndProvide1(minutes, value);
	}

	public void clickTimeNotation()
	{
		timeNotation.click();
	}

	public void selectTimeNotation()
	{
		AM.click();
	}

	public void clickOk()
	{
		clickOnOk();
	}

	public void clickUpToTimeField()
	{
		uptoTime.click();
	}

	public void provideUpToHrs(String value)
	{
		clearAndProvide1(hrs1, value);
	}

	public void provideUpTOHrs1()
	{
		// ClickElementByJavaScript(driver, hrs1);
	}

	public void provideUpToMinutes(String value)
	{
		clearAndProvide1(minutes1, value);
	}

	public void clickUpToTimeNotation()
	{
		timeNotation1.click();
	}

	public void selectUpToTimeNotation()
	{
		AM1.click();
	}

	public void clickUpToOk()
	{
		clickOk();
	}

	public void enterDescription(String value)
	{
		provideDescription(value);
	}

	public void saveAndSubmit()
	{
		clickSaveSubmit();
	}

	public void clickSave()
	{
		clickSaveAndBack();
	}

	public boolean isTxnCreated(String value)
	{
		return resultValue(9).contains(value);
	}

	public void selectTheRow()
	{
		selectRow.click();
	}

	public void clickView()
	{
		clickOnView();
	}

	public void clickContextMenu()
	{
		contextMenu.click();
	}

	public void clickDelete() throws InterruptedException
	{
		delete.click();
		Thread.sleep(1000);
	}

}
