package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HrCorePage extends BasePage
{

	public HrCorePage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='HR Core']")
	WebElement hRCore;

	@FindBy(xpath = "//span[@class='dx-vam'][normalize-space()='Employee']")
	WebElement employee;

	@FindBy(css = "#MainMenu_DXI0_Img")
	WebElement newbtn;

	@FindBy(css = "div[class='dx-first-col dx-last-col dx-last-row dx-field-item dx-col-0 dx-field-item-optional dx-field-item-has-group'] div[class='dx-dropdowneditor-icon']")
	WebElement clkmgr;

	@FindBy(xpath = "//div[contains(text(),'001 | Vaibhav Chavan')]")
	WebElement slctmgr;

	@FindBy(name = "Name")
	WebElement name;

	@FindBy(css = "div[class='dx-first-row dx-first-col dx-last-row dx-field-item dx-col-0 dx-field-item-required dx-flex-layout dx-label-v-align'] div[class='dx-show-invalid-badge dx-selectbox dx-textbox dx-texteditor dx-show-clear-button dx-dropdowneditor-button-visible dx-editor-outlined dx-texteditor-empty dx-widget dx-dropdowneditor dx-dropdowneditor-field-clickable dx-validator dx-visibility-change-handler'] div[class='dx-dropdowneditor-icon']")
	WebElement clkdept;

	@FindBy(xpath = "//div[contains(text(),'prod')]")
	WebElement slctdept;

	@FindBy(css = "div[class='dx-first-row dx-last-row dx-field-item dx-col-1 dx-field-item-required dx-flex-layout dx-label-v-align'] div[class='dx-show-invalid-badge dx-selectbox dx-textbox dx-texteditor dx-show-clear-button dx-dropdowneditor-button-visible dx-editor-outlined dx-texteditor-empty dx-widget dx-dropdowneditor dx-dropdowneditor-field-clickable dx-validator dx-visibility-change-handler'] div[class='dx-dropdowneditor-icon']")
	WebElement clkdesg;

	@FindBy(xpath = "//div[contains(text(,'Systems Analyst')]") // error
	WebElement slctdesg;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save;

	@FindBy(xpath = "//h2[normalize-space()='Suraj']")
	WebElement empname;

	public void clkHRCore()
	{
		hRCore.click();
	}

	public void clkEmp()
	{
		employee.click();
	}

	public void clkBtnNew()
	{
		newbtn.click();
	}

	public void clkMgrDropdown()
	{
		clkmgr.click();
	}

	public void slctMgr()
	{
		slctmgr.click();
	}

	public void setName()
	{
		name.sendKeys("Suraj");
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
		save.click();
	}

	public boolean verifyEmp()
	{
		// String emp=empname.getText();
		if (empname.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
