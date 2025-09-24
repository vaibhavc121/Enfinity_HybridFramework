package pageObjects.HRMS.SuccessionPlanning;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class SuccessionPage extends BasePage
{

    @FindBy(xpath = "//img[@id='applicationMenu_DXI10_PImg']")
    private WebElement menu;

    @FindBy(xpath = "//span[normalize-space()='Succession Planning']")
    private static WebElement successionPlanning;

    @FindBy(xpath = "//label[contains(normalize-space(),'Succession Plan')]")
    private WebElement successionPlan;

    @FindBy(xpath = "//img[@id='MainMenu_DXI11_PImg']")
    private WebElement contextMenu;

    @FindBy(xpath = "//span[@title='Delete']")
    private WebElement delete;

    public void clickMenu()
    {
        menu.click();
    }

    public static void clickSuccessionPlanning()
    {
        BasePage.clickMenuIcon();
        successionPlanning.click();
    }

    public void clickSuccessionPlan()
    {
        BasePage.openSidebar();
        successionPlan.click();
    }

    public void deleteSuccessionPlan(String expValue, int filterIndex, int resultIndex)
    {
        filterByIndex(filterIndex, expValue);
        waitTS(2);
        String actValue = resultValue(resultIndex);
        if (actValue.contains(expValue))
        {
            selectRow();
            clickOnElement1(contextMenu);
            BaseTest.log("Clicked on Context Menu");
            clickOnElement1(delete);
            BaseTest.log("Clicked on Delete option");
            waitTS(2);
            pressEnter();
        } else
        {
            throw new RuntimeException("VRC- No matching record found");
        }
    }
}