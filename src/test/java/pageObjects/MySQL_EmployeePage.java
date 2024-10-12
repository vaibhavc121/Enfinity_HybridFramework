package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class MySQL_EmployeePage extends BasePage
{

	public MySQL_EmployeePage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	BaseClass bc = new BaseClass();

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

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement mobileNumber;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement joiningDate;

	@FindBy(css = "div[class='dx-first-row dx-first-col dx-last-row dx-field-item dx-col-0 dx-field-item-required dx-flex-layout dx-label-v-align'] div[class='dx-show-invalid-badge dx-selectbox dx-textbox dx-texteditor dx-show-clear-button dx-dropdowneditor-button-visible dx-editor-outlined dx-texteditor-empty dx-widget dx-dropdowneditor dx-dropdowneditor-field-clickable dx-validator dx-visibility-change-handler'] div[class='dx-dropdowneditor-icon']")
	WebElement clkdept;

	@FindBy(xpath = "//div[contains(text(),'prod')]")
	WebElement slctdept;

	@FindBy(xpath = "/html[1]/body[1]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
	WebElement slctdept1;

	@FindBy(css = "div[class='dx-first-row dx-last-row dx-field-item dx-col-1 dx-field-item-required dx-flex-layout dx-label-v-align'] div[class='dx-show-invalid-badge dx-selectbox dx-textbox dx-texteditor dx-show-clear-button dx-dropdowneditor-button-visible dx-editor-outlined dx-texteditor-empty dx-widget dx-dropdowneditor dx-dropdowneditor-field-clickable dx-validator dx-visibility-change-handler'] div[class='dx-dropdowneditor-icon']")
	WebElement clkdesg;

	@FindBy(xpath = "//div[contains(text(,'Systems Analyst')]") // error
	WebElement slctdesg;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
	WebElement clkgrade;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]")
	WebElement clkgender;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]")
	WebElement clkreligion;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]")
	WebElement clkmaritalstatus;

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

	public void clkBtnNew()
	{
		newbtn.click();
	}

	public void setWorkEmail(String email)
	{
		workEmail.sendKeys(email);
	}

	public void setName(String ename)
	{
		name.sendKeys(ename);
	}

	public void clkMgrDropdown()
	{
		clkmgr.click();
	}

	public void slctMgr()
	{
		slctmgr.click();
	}

	public void setMblNum(String mbl)
	{
		mobileNumber.sendKeys(mbl);
	}

	public void setDOJ(String DOJ)
	{
		joiningDate.clear();
		joiningDate.sendKeys(DOJ);
	}

	public void clkDept()
	{
		clkdept.click();
	}

	public void slctDept(String dept)
	{
		List<WebElement> deptslist = driver
				.findElements(By.xpath("//div[@class='dx-item-content dx-list-item-content']"));
		for (WebElement deptnm : deptslist)
		{
			String actdept = deptnm.getText();
			if (actdept.equals(dept))
			{
				deptnm.click();
				break;
			}
		}

	}

	public void clkDesig()
	{
		clkdesg.click();
	}

	public void slctDesig(String desg)
	{
		List<WebElement> desglist = driver
				.findElements(By.xpath("//div[@class='dx-item-content dx-list-item-content']"));
		for (WebElement desgnm : desglist)
		{
			String actdesg = desgnm.getText();
			if (actdesg.equals(desg))
			{
				desgnm.click();
				break;
			}
		}
	}

	public void setGrade(String grade)
	{
		clkgrade.click();
		List<WebElement> gradelist = driver
				.findElements(By.xpath("//div[@class='dx-item-content dx-list-item-content']"));
		for (WebElement gradenm : gradelist)
		{
			String actgrade = gradenm.getText();
			if (actgrade.equals(grade))
			{
				gradenm.click();
				break;
			}
		}
	}

	public void setGender(String gender)
	{
		clkgender.click();
		List<WebElement> genderlist = driver
				.findElements(By.xpath("//div[@class='dx-item-content dx-list-item-content']"));
		for (WebElement gendernm : genderlist)
		{
			String actgender = gendernm.getText();
			if (actgender.equals(gender))
			{
				gendernm.click();
				break;
			}
		}
	}

	public void setReligion(String religion)
	{
		clkreligion.click();
		List<WebElement> religionlist = driver
				.findElements(By.xpath("//div[@class='dx-item-content dx-list-item-content']"));
		for (WebElement religionnm : religionlist)
		{
			String actreligion = religionnm.getText();
			if (actreligion.equals(religion))
			{
				religionnm.click();
				break;
			}
		}
	}

	public void setMaritalStatus(String maritalstatus)
	{
		clkmaritalstatus.click();
		List<WebElement> maritalstatuslist = driver
				.findElements(By.xpath("//div[@class='dx-item-content dx-list-item-content']"));
		for (WebElement maritalstatusnm : maritalstatuslist)
		{
			String actmaritalstatus = maritalstatusnm.getText();
			if (actmaritalstatus.equals(maritalstatus))
			{
				maritalstatusnm.click();
				break;
			}
		}
	}

	public void clkSave() throws InterruptedException
	{
		save.click();
		driver.navigate().back();
		Thread.sleep(3000);
	}

	public void empName(String empnm)
	{
		String empname = empnm;
	}

	public boolean isEmployeeCreated()
	{
//		filter.sendKeys(emp);
//		Thread.sleep(2000);
//		String bank = result.getText();
//		if (temp.equals(bank))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
		return true;
	}

}
