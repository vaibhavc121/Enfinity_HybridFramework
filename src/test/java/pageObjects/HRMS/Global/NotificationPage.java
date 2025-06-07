package pageObjects.HRMS.Global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class NotificationPage extends BasePage
{

	public NotificationPage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(xpath = "//i[@class='dx-icon bell-icon white-color-icon']")
	WebElement bellIcon;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[1]")
	WebElement notificationSection;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-ellipsis-icon']")
	WebElement settingIcon;

	@FindBy(xpath = "//span[normalize-space()='Open']")
	WebElement open;

	public void clickBellIcon()
	{
		bellIcon.click();
	}

	public void isLeaveDataCorrect(String expEmpName, String status)
	{
		String notificationData = driver.findElement(By.xpath("//p[normalize-space()='002-Rohit Chavan']")).getText();
		if (notificationData.contains(expEmpName))
		{
			settingIcon.click();
			open.click();
			BasePage.switchTab();

			switch (status)
			{
			case "Approve":
				BasePage.clickOnApprove();
				break;
			case "Revise":
				BasePage.clickRevise();
				break;
			case "Reject":
				BasePage.clickReject();
				break;
			default:
				throw new IllegalArgumentException("Invalid leave status: " + status);
			}

			BasePage.acceptAlert(driver);
			// BasePage.closeCurrentTab();
			// BasePage.closeTab();
		} else
		{
			throw new RuntimeException("Leave data is not correct");
		}
	}

}
