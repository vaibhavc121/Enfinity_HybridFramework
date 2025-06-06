package pageObjects.HRMS.HRCore;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.DataUtils;

public class EmployeePage1 extends BasePage
{

	public EmployeePage1(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "#MainMenu_DXI0_Img")
	WebElement newbtn;

	@FindBy(name = "Email")
	WebElement workEmail;

	@FindBy(name = "Name")
	WebElement name;

	@FindBy(css = "div[class='dx-first-col dx-last-col dx-last-row dx-field-item dx-col-0 dx-field-item-optional dx-field-item-has-group'] div[class='dx-dropdowneditor-icon']")
	WebElement clkmgr;

	@FindBy(xpath = "//div[contains(text(),'001 | Vaibhav Chavan')]")
	WebElement slctmgr;

	@FindBy(css = "#dx_dx-67a22bb8-3d7a-8162-872c-e3199251a8c4_MobileNumber")
	WebElement mobileNumber;

	@FindBy(css = "div[class='dx-first-row dx-first-col dx-last-row dx-field-item dx-col-0 dx-field-item-required dx-flex-layout dx-label-v-align'] div[class='dx-show-invalid-badge dx-selectbox dx-textbox dx-texteditor dx-show-clear-button dx-dropdowneditor-button-visible dx-editor-outlined dx-texteditor-empty dx-widget dx-dropdowneditor dx-dropdowneditor-field-clickable dx-validator dx-visibility-change-handler'] div[class='dx-dropdowneditor-icon']")
	WebElement clkdept;

	@FindBy(xpath = "//div[contains(text(),'prod')]")
	WebElement slctdept;

	@FindBy(css = "div[class='dx-first-row dx-last-row dx-field-item dx-col-1 dx-field-item-required dx-flex-layout dx-label-v-align'] div[class='dx-show-invalid-badge dx-selectbox dx-textbox dx-texteditor dx-show-clear-button dx-dropdowneditor-button-visible dx-editor-outlined dx-texteditor-empty dx-widget dx-dropdowneditor dx-dropdowneditor-field-clickable dx-validator dx-visibility-change-handler'] div[class='dx-dropdowneditor-icon']")
	WebElement clkdesg;

	@FindBy(xpath = "//div[contains(text(),'Systems Analyst')]")
	WebElement slctdesg;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

	@FindBy(xpath = "//h2[normalize-space()='Suraj']")
	WebElement empname;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[2]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement filter;

	@FindBy(xpath = "//a[normalize-space()='001 | Vaibhav Chavan']")
	WebElement clkfilteredemp;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[12]/a[1]/span[1]")
	WebElement residencyInfo;

	@FindBy(name = "SecondName")
	WebElement secondName;

	@FindBy(name = "ThirdName")
	WebElement thirdName;

	@FindBy(name = "FourthName")
	WebElement fourthName;

	@FindBy(name = "LastName")
	WebElement lastName;

	// Tab Page Objects
	@FindBy(xpath = "//span[normalize-space()='Time Off']")
	WebElement timeOff;

	// Tab Action Methods
	public void clkTimeOff()
	{
		timeOff.click();
	}

	// Time off Page Objects
	@FindBy(xpath = "(//p[@class='leave-balance'])[3]")
	WebElement annualLeaveBal;

	// Time off Action Methods
	public double getAnnualLeaveBal(int classIndex)
	{
		String bal = driver.findElement(By.xpath("(//p[@class='leave-balance'])[" + classIndex + "]")).getText();
		// String bal = annualLeaveBal.getText();
		String number = bal.replaceAll("[^0-9.]", "").trim();
		// String numberPart = bal.substring(0, 5);
		double expBal = Double.parseDouble(number);
		// expBal += 1;
		return expBal;

	}

	public double extractValueFromText()
	{
		return DataUtils.extractNumericValueFromText(annualLeaveBal);
	}

	public void clkBtnNew()
	{
		newbtn.click();
	}

	public void setWorkEmail()
	{
		workEmail.sendKeys(randomEmail());
	}

	public void setName()
	{
		name.sendKeys("Suraj");
	}

	public void clkMgrDropdown()
	{
		clkmgr.click();
	}

	public void slctMgr()
	{
		slctmgr.click();
	}

	public void setMblNum()
	{
		mobileNumber.sendKeys(randomMblNum());
	}

	public void clkDept()
	{
		clkdept.click();
	}

	public void slctDept()
	{
		slctdept.click();
	}

	public void clkDesig()
	{
		clkdesg.click();
	}

	public void slctDesig()
	{
		slctdesg.click();
	}

	public void clkSave()
	{
		clickOnSave();
	}

	public boolean verifyEmp()
	{
		// String emp=empname.getText();
		if (empname.isDisplayed())
		{
			return true;
		} else
		{
			return false;
		}
	}

	public void filterEmp()
	{
		filter.sendKeys("vaibhav chavan");
	}

	public void clkFilteredEmp()
	{
		clkfilteredemp.click();
	}

	public void clkResidencyInfo()
	{
		String originalWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows)
		{
			if (!windowHandle.equals(originalWindow))
			{
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		residencyInfo.click();
	}

	public void setSecName(String snm)
	{
		secondName.sendKeys(snm);
	}

	public void setThirdName(String tnm)
	{
		thirdName.sendKeys(tnm);
	}

	public void setFourthName(String fnm)
	{
		fourthName.sendKeys(fnm);
	}

	public void setLastName(String lnm)
	{
		secondName.sendKeys(lnm);
	}

}
