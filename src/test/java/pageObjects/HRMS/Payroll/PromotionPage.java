package pageObjects.HRMS.Payroll;

import base.SelenideBasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import base.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class PromotionPage extends SelenideBasePage
{
	//region Locators
	SelenideElement promotion = $x("(//span[text()='Promotion'])[2]");
	//endregion

	//region Action Methods
	public void clickPromotion()
	{
		promotion.click();
	}

	public void clickNew()
	{
		clickOnNew();
	}

//	public void a()
//	{
//	}
//
//	public void a()
//	{
//	}
//
//	public void a()
//	{
//	}
//
//	public void a()
//	{
//	}
//
//	public void a()
//	{
//	}
//
//	public void a()
//	{
//	}
//
//	public void a()
//	{
//	}
//
//	public void a()
//	{
//	}
//
//	public void a()
//	{
//	}
//
//	public void a()
//	{
//	}
	//endregion

}