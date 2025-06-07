package pageObjects.HRMS.SelfService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class PromotionRequestPage extends BasePage
{

	public PromotionRequestPage(WebDriver driver)
	{
		super(driver);

	}

	// Locators
	@FindBy(xpath = "//a[@id='TxnInstanceView_I0i19_T']//span[@class='dx-vam'][normalize-space()='Profile Update']")
	WebElement profileUpdate;

	@FindBy(xpath = "(//span[text()='Promotion Request'])[2]")
	WebElement promotionRequest;

	@FindBy(xpath = "//input[@id='EmployeePromotionRequest.TxnDate_I']")
	WebElement txnDate;

	@FindBy(xpath = "//input[@id='EmployeePromotionRequest.EffectiveDate_I']")
	WebElement effectiveDate;

	@FindBy(xpath = "//input[@id='EmployeePromotionRequest.Type_I']")
	WebElement type;

	@FindBy(xpath = "//input[@id='EmployeePromotionRequest.NewDepartmentIdLookup_I']")
	WebElement newDepartment;

	@FindBy(xpath = "//input[@id='EmployeePromotionRequest.NewDesignationIdLookup_I']")
	WebElement newDesignation;

	@FindBy(xpath = "//input[@id='EmployeePromotionRequest.NewWorkLocationIdLookup_I']")
	WebElement newWorkLocation;

	@FindBy(xpath = "//input[@id='EmployeePromotionRequest.NewProjectIdLookup_I']")
	WebElement newProject;

	@FindBy(xpath = "//textarea[@id='EmployeePromotionRequest.Description_I']")
	WebElement description;

	@FindBy(xpath = "//img[@id='Line_CBImg']")
	WebElement salariesSection;

	@FindBy(xpath = "//input[@id='EmployeePromotionRequestLine_SalaryComponentId_I']")
	WebElement salaryComponent;

	@FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'][normalize-space()='0'])[2]")
	WebElement incrementAmount;

	@FindBy(xpath = "/html[1]/body[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[5]/td[6]/div[1]")
	WebElement effectiveFromDate;

	@FindBy(xpath = "/html[1]/body[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/table[1]/tbody[1]/tr[5]/td[7]/div[1]")
	WebElement effectiveToDate;

	@FindBy(xpath = "//span[@class='dx-vam dxm-contentText'][normalize-space()='New']")
	WebElement newBtn;

	// Action Methods
	public void scrollDownWebpage()
	{
		scrollDownWebPage(profileUpdate);
	}

	public void clickPromotionRequest()
	{
		promotionRequest.click();
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideTxnDate(String value)
	{
		clearAndProvide1(txnDate, value);
	}

	public void provideEffectiveDate(String value)
	{
		clearAndProvide1(effectiveDate, value);
	}

	public void provideType(String value)
	{
		clearAndProvide1(type, value);
	}

	public void provideNewDepartment(String value)
	{
		clearAndProvide1(newDepartment, value);
	}

	public void provideNewDesignation(String value)
	{
		clearAndProvide1(newDesignation, value);
	}

	public void provideNewWorkLocation(String value)
	{
		clearAndProvide1(newWorkLocation, value);
	}

	public void provideNewProject(String value)
	{
		clearAndProvide1(newProject, value);
	}

	public void provideDesc(String value)
	{
		clearAndProvide1(description, value);
	}

	public void clickSalariesSection()
	{
		salariesSection.click();
	}

	public void clickSave() throws InterruptedException
	{
		clickOnSave();
		Thread.sleep(2000);
	}

	public void clickPlusBtn()
	{
		clickOnNewLine();
	}

	public void provideSalaryComponent(String value)
	{
		clearAndProvide1(salaryComponent, value);
	}

	public void provideIncrementAmount(String value)
	{
		clearAndProvide1(incrementAmount, value);
	}

	public void provideEffectiveFromDate(String value)
	{
		clearAndProvide1(effectiveFromDate, value);
	}

	public void provideEffectiveToDate(String value)
	{
		clearAndProvide1(effectiveToDate, value);
	}

	public void clickNewBtn() throws InterruptedException
	{
		newBtn.click();
		Thread.sleep(2000);
	}

	public void saveAndBack()
	{
		clickSaveAndBack();
	}

	public boolean isTxnCreated()
	{
		clickOnSave();
		return isTransactionCreated();
	}

//	public boolean isTxnCreated(String effectiveDate)
//	{
//		return result5().contains(effectiveDate);
//	}

}
