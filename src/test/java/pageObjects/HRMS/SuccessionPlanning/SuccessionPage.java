package pageObjects.HRMS.SuccessionPlanning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class SuccessionPage extends BasePage
{

	public SuccessionPage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(xpath = "//img[@id='applicationMenu_DXI10_PImg']")
	private WebElement menu;

	@FindBy(xpath = "//span[normalize-space()='Succession Planning']")
	private WebElement successionPlanning;

	@FindBy(xpath = "//a[@title='Succession Plan']//span[@class='dx-vam'][normalize-space()='Succession Plan']")
	private WebElement successionPlan;

	public void clickMenu()
	{
		menu.click();
	}

	public void clickSuccessionPlanning()
	{
		successionPlanning.click();
	}

	public void clickSuccessionPlan()
	{
		successionPlan.click();
	}

}
