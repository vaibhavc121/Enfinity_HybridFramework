package pageObjects.HRMS.Payroll;

import base.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;

public class PromotionPage extends BasePage
{
    public PromotionPage(WebDriver driver)
    {
        super(driver);
    }

    //region Locators
    @FindBy(xpath = "(//span[text()='Promotion'])[2]")
    private WebElement promotion;

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