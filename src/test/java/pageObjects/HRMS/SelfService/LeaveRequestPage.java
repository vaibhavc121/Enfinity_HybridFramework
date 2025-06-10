package pageObjects.HRMS.SelfService;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LeaveRequestPage extends BasePage
{

	public LeaveRequestPage(WebDriver driver)
	{
		super(driver);

	}

	// Locators
	@FindBy(xpath = "(//span[text()='Leave Request'])[2]")
	WebElement leaveRequest;

	@FindBy(xpath = "//p[@title='Sick Leave']")
	WebElement sickLeave;

	@FindBy(xpath = "(//i[@class='dx-icon dx-icon-new-icon'])[2]")
	WebElement plusBtn;

//	@FindBy(xpath = "//div[@class='dx-start-datebox dx-datebox dx-textbox dx-texteditor dx-editor-outlined dx-widget dx-visibility-change-handler dx-auto-width dx-dropdowneditor dx-datebox-date dx-datebox-calendar dx-dropdowneditor-field-clickable']//input[@role='combobox']")
//	WebElement fromDate;

//	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]")
//	WebElement toDate;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[3]")
	WebElement fromDate;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[4]")
	WebElement toDate;

	@FindBy(xpath = "//span[normalize-space()='Save and Submit']")
	WebElement saveAndSubmit;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/img[1]")
	WebElement newBtn;

	@FindBy(xpath = "//img[@id='MainMenu_DXI0_Img']")
	WebElement plusBtn1;

	@FindBy(xpath = "//span[text()='Attach Files']")
	WebElement attachFiles;

	@FindBy(xpath = "//span[text()='Upload File']")
	WebElement uploadFile;

	// Action Methods
	public void clickLeaveRequest()
	{
		leaveRequest.click();
	}

	public void clickNew() throws InterruptedException
	{
		plusBtn1.click();
		Thread.sleep(5000);
	}

	public void hoverAndClick(String leaveType)
	{
		WebElement dynamicLeaveType = driver.findElement(By.xpath("//p[@title='" + leaveType + "']"));
		hoverAndClick(dynamicLeaveType, plusBtn);
		waitTS(5);
	}

	public void provideFromDate(String value)
	{
		clearAndProvide1(fromDate, value);
		pressTab();
	}

	public void provideToDate(String value)
	{
		clearAndProvide1(toDate, value);
	}

	public void clickSaveAndSubmit()
	{
		saveAndSubmit.click();
	}

	public void clickSave()
	{
		clickSaveAndBack();
	}

	public void attachFile()
	{
		attachFiles.click();
		uploadFile.sendKeys("C:\\Users\\Vaibhav\\Downloads\\universe.png");
	}

	public boolean isTxnCreated(String fromDate, String toDate)
	{
		return resultValue(8).contains(fromDate) && resultValue(8).contains(toDate);
	}
}
