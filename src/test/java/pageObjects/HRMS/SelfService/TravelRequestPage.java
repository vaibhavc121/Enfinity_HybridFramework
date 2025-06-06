package pageObjects.HRMS.SelfService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class TravelRequestPage extends BasePage
{

	public TravelRequestPage(WebDriver driver)
	{
		super(driver);

	}

	// Locators
	@FindBy(xpath = "//a[@id='TxnInstanceView_I0i19_T']//span[@class='dx-vam'][normalize-space()='Profile Update']")
	WebElement profileUpdate;

	@FindBy(xpath = "//span[normalize-space()='Travel Request']")
	WebElement travelRequest;

	@FindBy(xpath = "//input[@id='TravelRequest.FromDate_I']")
	WebElement fromDate;

	@FindBy(xpath = "//input[@id='TravelRequest.UptoDate_I']")
	WebElement uptoDate;

	@FindBy(xpath = "//input[@id='TravelRequest.Category_I']")
	WebElement category;

	@FindBy(xpath = "//input[@id='TravelRequest.ToCountryIdLookup_I']")
	WebElement ToCountry;

	@FindBy(xpath = "//input[@id='TravelRequest.City_I']")
	WebElement city;

	@FindBy(xpath = "//span[@id='TravelRequest.HotelBookedByEmployee_S_D']//span[@class='dxSwitcher dx-not-acc']")
	WebElement hotelBookedByEmp;

	@FindBy(xpath = "//input[@id='TravelRequest.TicketDestinationIdLookup_I']")
	WebElement ticketDestination;

	@FindBy(xpath = "//input[@id='TravelRequest.TicketAmount_I']")
	WebElement ticketAmount;

	@FindBy(xpath = "//input[@id='TravelRequest.Purpose_I']")
	WebElement purpose;

	@FindBy(xpath = "//input[@id='TravelRequest.PaymentType_I']")
	WebElement paymentType;

	@FindBy(xpath = "//textarea[@id='TravelRequest.Description_I']")
	WebElement remarks;

	// Action Methods
	public void scrollDownWebpage()
	{
		scrollDownWebPage(profileUpdate);
	}

	public void clickTravelRequest()
	{
		travelRequest.click();
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideFromDate(String value)
	{
		clearAndProvide1(fromDate, value);
	}

	public void provideUptoDate(String value)
	{
		clearAndProvide1(uptoDate, value);
	}

	public void clickCategoryDD()
	{
		category.click();
	}

	public void selectCategory(String value)
	{
		selectDropdownValueOffice365(value);
	}

	public void provideCategory(String value)
	{
		clearAndProvide1(category, value);
	}

	public void provideToCountry(String value)
	{
		clearAndProvide1(ToCountry, value);
	}

	public void provideCity(String value)
	{
		city.sendKeys(value);
	}

	public void clickHotelBookedByEmpBtn()
	{
		hotelBookedByEmp.click();
	}

	public void provideTicketDestination(String value)
	{
		clearAndProvide1(ticketDestination, value);
	}

	public void provideTicketAmt(String value)
	{
		ticketAmount.sendKeys(value);
	}

	public void providePurpose(String value)
	{
		clearAndProvide1(purpose, value);
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
	}

	public boolean isTransactionCreated(String emp, String country)
	{
		return resultValue(5).contains(emp) && resultValue(7).contains(country);
	}

}
