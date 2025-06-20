package base;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import pageObjects.HRMS.HRCore.EmployeePage;
import pageObjects.HRMS.HRCore.LoginPage;

public class SelenideBasePage
{
    public static WebDriver driver;
    Robot robot;

    //region Constructor
//    public SelenideBasePage(WebDriver driver)
//    {
//        SelenideBasePage.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
    //endregion

    //region Listing Filters (Relative xpath)
    public static void filterByIndex(int columnIndex, String value)
    {
        // I expect the index to change dynamically
        String xpath = "(//input[@class='dx-texteditor-input'])[" + columnIndex + "]";
        SelenideElement element = $(By.xpath(xpath)).shouldBe(visible);
        element.clear();
        BaseTest.log("value cleared in filter box");

        element.setValue(value);
        BaseTest.log("provided filter value");
    }

    // other approach
    public static void filterValue(int columnIndex, String value)
    {
        String xpath = "(//tbody//tr)[11]//td[" + columnIndex + "]";
        $(By.xpath(xpath)).shouldBe(visible).setValue(value);
    }

    public static void filterDateByIndex(int columnIndex, String value)
    {
        String xpath = "(//input[@class='dx-texteditor-input'])[" + columnIndex + "]";
        $(By.xpath(xpath)).shouldBe(visible).clear();
        $(By.xpath(xpath)).shouldBe(visible).setValue(value).pressEnter();
    }

    public static void filterAndOpenTransaction(int filterIndex, int resultIndex, String expValue, String mode)
    {
        filterByIndex(filterIndex, expValue);
        waitSS(2);
        String actValue = resultValue(resultIndex);
        if (actValue.contains(expValue))
        {
            selectRow();
            if (mode.contains("view"))
            {
                clickOnView();
            } else
            {
                clickOnEdit();
            }
        } else
        {
            throw new RuntimeException("VRC- No matching record found");
        }
    }
    //endregion

    //region Listing result (Relative xpath)
    public static void selectRow()
    {
        // driver.findElement(By.xpath("(//tr)[12]//td[2]")).click();
        $x("(//tr)[12]//td[2]").click();
    }

    public static String resultValue(int columnIndex)
    {
        // String result =
        // driver.findElement(By.xpath("(//tbody//tr)[12]//td[2]")).getText();
        // return result;
        String xpath = "(//tbody//tr)[12]//td[" + columnIndex + "]";
        try
        {
            BaseTest.log("extracting text from the result");
            return $x(xpath).getText();
        } catch (Exception e)
        {
            BaseTest.log("No matching record found");
            return "No matching record found";
        }
        //		String xpath = "(//tbody//tr)[12]//td[" + columnIndex + "]";
        //		String result = driver.findElement(By.xpath(xpath)).getText();
        //		return result;
    }
    //endregion

    //region Transaction form related Action Methods

    public static void clickOnHamburgerMenu()
    {
        $("#leftAreaMenu_DXI0_").click();
    }

    public static void clickOnOk()
    {
        $x("//span[normalize-space()='OK']").click();
    }

    public static void clickOnSave()
    {
        $x("//span[normalize-space()='Save']").click();
    }

    public void clickSaveSubmit()
    {
        $x("//span[text()='Save and Submit']").click();
    }

    public static void clickSaveAndBack()
    {
        $x("//span[normalize-space()='Save']").click();
        back();
    }

    public static void clickOnView()
    {
        $x("//span[normalize-space()='View']").click();
    }

    public static void clickOnApprove()
    {
        $x("//span[normalize-space()='Approve']").click();
    }

    public static void clickOnViewApproveBack()
    {
        $x("//span[normalize-space()='View']").click();
        waitSS(1);
        $x("//span[normalize-space()='Approve']").click();
        waitSS(1);
        back();
    }

    public static void clickReject()
    {
        $x("//span[normalize-space()='Reject']").click();
    }

    public static void clickRevise()
    {
        $x("//span[normalize-space()='Revise']").click();
    }

    public static void clickAttachFile()
    {
        $x("//span[normalize-space()='Attach Files']").click();
    }

    public static void clickViewAndBack()
    {
        $x("//span[normalize-space()='View']").click();
        waitSS(2);
        clickOnEdit();
        clickOnView();
        back();
    }

    public static void clickOnEdit()
    {
        // waitForElement1(By.xpath("//span[normalize-space()='Edit']")).click();
        $x("//span[normalize-space()='Edit']").click();
    }

    public static void clickApproveAndBack()
    {
        // waitForElement1(By.xpath("//span[normalize-space()='Approve']")).click();
        $x("//span[normalize-space()='Approve']").click();
        back();
    }

    public static void clickOnNew()
    {
        // waitForElement1(By.xpath("//span[normalize-space()='New']")).click();
        $x("//span[normalize-space()='New']").click();
    }

    public static void selectDropdownOption(String expectedValue)
    {
        // List<WebElement> dropdownList = driver.findElements(By.xpath(...))
        ElementsCollection dropdownList = $$x("//div[@class='dx-item dx-list-item']");
        for (SelenideElement dropdownElement : dropdownList)
        {
            if (dropdownElement.getText().contains(expectedValue))
            {
                dropdownElement.click();
                break;
            }
        }
    }

    public static void selectDropdownValue(String value)
    {
        while (true)
        {
            ElementsCollection valuesList = $$x("//div[@class='grid-row-template']");
            for (SelenideElement valueElement : valuesList)
            {
                if (valueElement.getText().contains(value))
                {
                    valueElement.click();
                    return;
                }
            }
            $x("//i[@class='dx-icon dx-icon-next-icon']").click();
            sleep(3000);
        }
    }

    public static void selectDropdownValueOffice365(String value)
    {
        ElementsCollection valuesList = $$x("//tr[@class='dxeListBoxItemRow_Office365']");
        for (SelenideElement valueElement : valuesList)
        {
            if (valueElement.getText().contains(value))
            {
                valueElement.click();
                break;
            }
        }
    }

    public static void clearAndProvide(By locator, String value)
    {
        SelenideElement element = $(locator);
        element.click();
        element.clear();
        element.setValue(value);
    }

    public static void clearAndProvide1(SelenideElement locator, String value)
    {
        locator.click();
        sleep(1000);
        actions().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        sleep(1000);
        locator.setValue(value);
    }

    public static void clearAndProvide2(SelenideElement locator, String value) throws InterruptedException
    {
        actions().moveToElement(locator).click().doubleClick().sendKeys(value).perform();
        waitSS(1);
    }

    public static void provideAndEnter(SelenideElement locator, String value)
    {
        locator.click();
        actions().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        locator.setValue(value);
        sleep(2000);
        locator.pressEnter();
    }

    public static void provideValue(SelenideElement locator, String value)
    {
        executeJavaScript("arguments[0].value='" + value + "';", locator);
    }

    public void provideDescription(String value)
    {
        By description = By.xpath("//textarea[contains(@id,'Description')]");
        clearAndProvide(description, value);
    }

    public static void globalSearch(String value)
    {
        SelenideElement globalSearchInput = $("#GlobalSearch");
        globalSearchInput.click();
        SelenideElement comboBoxInput = $x("//input[@role='combobox']");
        comboBoxInput.sendKeys(value);
        waitSS(2);
        selectDropdownOption(value);
    }

    public static void scrollDownWebPageSample()
    {
        SelenideElement element = $x("//input[contains(@id,'OldContractSalary')]");
        element.scrollIntoView(true);
    }

    public static void scrollDownWebPage(SelenideElement locator)
    {
        locator.scrollIntoView(true);
    }

    public static void clickOnNewLine()
    {
        $x("//i[@class='dx-icon dx-icon-new-icon']").click();
    }

    public static void hoverAndClick(SelenideElement locator, SelenideElement locator1)
    {
        locator.hover();
        locator1.click();
    }

    public static void deleteTxn(int index, String value)
    {
        filterByIndex(index, value);
        waitSS(2);
        try
        {
            $x("(//tr)[12]//td[2]").click();
            BaseTest.log("row selected");
        } catch (Exception e)
        {
            Assert.fail("Vaibhav- There is no active records..");
            System.exit(1);
        }
        try
        {
            clickOnView();
            BaseTest.log("clickOnView");
        } catch (Exception e)
        {
            clickOnEdit();
            BaseTest.log("clickOnEdit");
        }
        waitSS(5);
        $x("(//img[@class='dxWeb_mAdaptiveMenu_Office365 dxm-pImage'])[8]").click();
        BaseTest.log("clciked on setting");
        $x("//span[normalize-space()='Delete']").click();
        BaseTest.log("clicked on delete");
        waitSS(1);
        actions().sendKeys(Keys.ENTER).perform();
        BaseTest.log("enter pressed");
        back();
        BaseTest.log("went back to listing");
    }

    public static void performAction(int index, String value, String action)
    {
        filterByIndex(index, value);
        waitSS(2);
        try
        {
            // Need to select row to click on view
            $x("(//tr)[12]//td[2]").click();
            BaseTest.log("clicked on row");
        } catch (Exception e)
        {
            Assert.fail("Vaibhav - There are no active records.");
            System.exit(1); // Exit application
        }
        try
        {
            clickOnView();
            BaseTest.log("clicked on view");
        } catch (Exception e)
        {
            clickOnEdit();
            BaseTest.log("clicked on edit");
        }
        waitSS(5);

        // Click on menu image icon
        $x("(//img[@class='dxWeb_mAdaptiveMenu_Office365 dxm-pImage'])[8]").click();
        BaseTest.log("Clicked on menu image icon");

        // Click the action (e.g., Delete, View, Edit)
        $x("//span[normalize-space()='" + action + "']").click();
        BaseTest.log("Clicked on " + action);

        waitSS(1);
        actions().sendKeys(Keys.ENTER).perform();
        BaseTest.log("pressed enter");

        // Delete the transaction
        $x("(//img[@class='dxWeb_mAdaptiveMenu_Office365 dxm-pImage'])[8]").click();
        BaseTest.log("clicked on menu/setting");

        $x("//span[normalize-space()='Delete']").click();
        BaseTest.log("clicked on delete");

        waitSS(1);

        actions().sendKeys(Keys.ENTER).perform();
        BaseTest.log("pressed enter button");

        back(); // or BrowserUtils.navigateBack(driver);
        BaseTest.log("navigate back to listing");
    }

    public static void deleteHrCoreTxn(int ColumnIndex, String value)
    {
        filterByIndex(ColumnIndex, value);
        waitSS(2);
        try
        {
            if (ColumnIndex == 2)
            {
                $x("(//tr)[12]//td[1]").click();
            } else
            {
                $x("(//tr)[12]//td[2]").click();
            }
        } catch (Exception e)
        {
            Assert.fail("Vaibhav- There is no active records..");
            System.exit(1);
        }
        try
        {
            clickOnView();
        } catch (Exception e)
        {
            clickOnEdit();
        }
        waitSS(5);
        $x("(//img[@class='dxWeb_mAdaptiveMenu_Office365 dxm-pImage'])[8]").click();
        $x("//span[normalize-space()='Delete']").click();
        waitSS(1);
        actions().sendKeys(Keys.ENTER).perform();
        back();
    }

    public static void clickOnContextMenu()
    {
        $("#MainMenu_DXI11_P").click();
    }

    //endregion

    //region Employee listing
    public static void filterEmployee(String value)
    {
        // driver.findElement(By.id("//input[@aria-describedby='dx-col-4']")).sendKeys(value);
        $x("//input[@aria-describedby='dx-col-4']").sendKeys(value);
    }

    public static String resultEmployee()
    {
        // String result = driver.findElement(By.xpath(
        // "/html[1]/body[1]/div[6]/div[2]/div[1]/div[2]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/p[1]/span[1]/a[1]")).getText();
        return $x("/html[1]/body[1]/div[6]/div[2]/div[1]/div[2]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/p[1]/span[1]/a[1]")
                .getText();
    }

    public static String result()
    {
        // String result = driver.findElement(By.xpath("//td[@class='list-hyperlink dx-cell-focus-disabled']")).getText();
        return $x("//td[@class='list-hyperlink dx-cell-focus-disabled']").getText();
    }

    public static void clickResult(String value)
    {
        // WebElement employee = driver.findElement(By.xpath("//td[@class='list-hyperlink dx-cell-focus-disabled']"));
        SelenideElement employee = $x("//td[@class='list-hyperlink dx-cell-focus-disabled']");
        String result = employee.getText();
        if (result.contains(value))
        {
            employee.click();
        }
    }

    public static void navigateToEmployee(String value)
    {
        // selectFilterAll();
        filterByIndex(2, value);
        BaseTest.log("value filtered");
        waitSS(2);
        String employee = resultValue(1);
        // Thread.sleep(2000);
        if (employee.contains(value))
        {
            selectRow();
            clickOnView();
        } else
        {
            throw new RuntimeException("VRC- No matching record found");
        }
    }

    public static void switchTab()
    {
        String originalWindow = WebDriverRunner.getWebDriver().getWindowHandle();
        // Get all window handles
        Set<String> allWindows = WebDriverRunner.getWebDriver().getWindowHandles();
        // Iterate through the window handles
        for (String windowHandle : allWindows)
        {
            if (!windowHandle.equals(originalWindow))
            {
                // Switch to the new window
                WebDriverRunner.getWebDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void closeTab()
    {
        String originalWindow = WebDriverRunner.getWebDriver().getWindowHandle();
        // Get all window handles
        Set<String> allWindows = WebDriverRunner.getWebDriver().getWindowHandles();
        // Iterate through the window handles
        for (String windowHandle : allWindows)
        {
            if (!windowHandle.equals(originalWindow))
            {
                // Switch to the new window
                WebDriverRunner.getWebDriver().switchTo().window(windowHandle);
                WebDriverRunner.getWebDriver().close();
                break;
            }
        }
    }
    //endregion

    //region Common Actions
    public static void logoutAndLogin(String username, String pwd)
    {
        EmployeePage ep = new EmployeePage(WebDriverRunner.getWebDriver());
        ep.clickRightAreaMenu();
        ep.clicklogOff();
        LoginPage lp = new LoginPage(WebDriverRunner.getWebDriver());
        lp.login(username, pwd);
    }

    public static void selectFilterAll()
    {
        // driver.findElement(By.id("//img[@id='ListingViews_B-1Img']")).click();
        // WebElement element = driver.findElement(By.id("//input[@name='ListingViews']"));
        // clickElementByJavaScript(driver, element);
        By locator = By.xpath("//img[@id='ListingViews_B-1Img']");
        $x("//img[@id='ListingViews_B-1Img']").click();
        selectDropdownValueOffice365("All");
    }
    //endregion

    //region Keyboard Actions
    public static void pause(String key)
    {
        // wait for 2 seconds
        actions().pause(Duration.ofSeconds(2)).perform();
    }

    public static void enterKey(String key)
    {
        actions().sendKeys(key).perform();
    }

    public static void enterCapitalKey(String key)
    {
        actions().keyDown(Keys.SHIFT).sendKeys(key).keyUp(Keys.SHIFT).perform();
    }

    public static void pressKey(String key)
    {
        actions().sendKeys(getKeyFromString(key)).perform();
    }

    public static Keys getKeyFromString(String key)
    {
        switch (key.toLowerCase())
        {
            // Editing keys
            case "enter":
                return Keys.ENTER;
            case "tab":
                return Keys.TAB;
            case "escape":
                return Keys.ESCAPE;
            case "backspace":
                return Keys.BACK_SPACE;
            case "delete":
                return Keys.DELETE;
            case "insert":
                return Keys.INSERT;
            case "space":
                return Keys.SPACE;
            // Modifier keys
            case "shift":
                return Keys.SHIFT;
            case "control":
                return Keys.CONTROL;
            case "alt":
                return Keys.ALT;
            // Navigation keys
            case "arrowup":
                return Keys.ARROW_UP;
            case "arrowdown":
                return Keys.ARROW_DOWN;
            case "arrowleft":
                return Keys.ARROW_LEFT;
            case "arrowright":
                return Keys.ARROW_RIGHT;
            case "home":
                return Keys.HOME;
            case "end":
                return Keys.END;
            case "pageup":
                return Keys.PAGE_UP;
            case "pagedown":
                return Keys.PAGE_DOWN;
            // Function keys
            case "f1":
                return Keys.F1;
            case "f2":
                return Keys.F2;
            case "f3":
                return Keys.F3;
            case "f4":
                return Keys.F4;
            // Separator and control keys
            case "add":
                return Keys.ADD;
            case "subtract":
                return Keys.SUBTRACT;
            case "multiply":
                return Keys.MULTIPLY;
            case "divide":
                return Keys.DIVIDE;
            case "decimal":
                return Keys.DECIMAL;
            default:
                throw new IllegalArgumentException("Invalid key name");
        }
    }

    public static void pressTab()
    {
        actions().sendKeys(Keys.TAB).perform();
    }

    public static void pressEnter()
    {
        actions().sendKeys(Keys.ENTER).perform();
    }
    //endregion

    //region Waits
    public static void waitUntil(By locator)
    {
        // waits until the element is visible or enabled, then clicks
        $(locator).shouldBe(visible.or(enabled)).click();
    }

    public static SelenideElement waitForElement(SelenideElement element)
    {
        // waits until the passed SelenideElement is visible or enabled
        return element.shouldBe(visible.or(enabled));
    }

    public static SelenideElement waitForElement1(By locator)
    {
        // waits until the element located by By is visible or enabled
        return $(locator).shouldBe(visible.or(enabled));
    }

    public static void wait(int seconds)
    {
        Selenide.sleep(seconds * 1000L);
    }

    public static void waitTS(int seconds)
    {
        try
        {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static void waitSS(int seconds)
    {
        Selenide.sleep(seconds * 1000L);
    }
    //endregion

    //region Validations
    public static boolean isValuePresent(List<SelenideElement> element, String value)
    {
        for (SelenideElement valueElement : element)
        {
            String actualValue = valueElement.getText();
            if (actualValue.contains(value))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isTransactionCreated()
    {
        String message = $(By.xpath("//div[@class='dx-toast-message']")).shouldBe(visible).getText();
        return message.contains("created successfully");
    }

    public static boolean isEmployeeDeleted()
    {
        String message = $(By.xpath("//div[@class='dx-toast-message']")).shouldBe(visible).getText();
        return message.contains("deleted successfully");
    }

    public static void validation(String expectedMessage)
    {
        SelenideElement element = $(By.className("dx-toast-message")).shouldBe(visible);
        String actualMessage = element.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    public static boolean validateListing(String value, int filterIndex, int resultIndex)
    {
        filterByIndex(filterIndex, value);
        waitSS(2);
        String actualValue = resultValue(resultIndex);
        return actualValue.contains(value);
    }

    public static boolean validateListing2Fields(String value1, int filterIndex1, int resultIndex1, String value2,
                                                 int filterIndex2, int resultIndex2)
    {
        // Apply first filter
        filterByIndex(filterIndex1, value1);
        waitSS(2);
        // Apply second filter
        filterByIndex(filterIndex2, value2);
        waitSS(2);
        // Get results
        String actualValue1 = resultValue(resultIndex1);
        String actualValue2 = resultValue(resultIndex2);
        // Validate results
        boolean isValid1 = actualValue1.contains(value1);
        boolean isValid2 = actualValue2.contains(value2);
        return isValid1 && isValid2;
    }

    public static boolean validateListing1(String expDate, String expEmp, String expStatus)
    {
        if (expDate != null && !expDate.isEmpty())
        {
            filterDateByIndex(2, expDate);
            waitSS(2);
        }
        if (expEmp != null && !expEmp.isEmpty())
        {
            filterByIndex(2, expEmp);
            waitSS(2);
        }
        if (expStatus != null && !expStatus.isEmpty())
        {
            filterByIndex(7, expStatus);
            waitSS(2);
        }
        boolean isMatch = true;
        if (expDate != null && !expDate.isEmpty())
        {
            String actualDate = resultValue(2);
            isMatch &= actualDate.contains(expDate);
        }
        if (expEmp != null && !expEmp.isEmpty())
        {
            String actualEmp = resultValue(1);
            isMatch &= actualEmp.contains(expEmp);
        }
        if (expStatus != null && !expStatus.isEmpty())
        {
            String actualStatus = resultValue(7);
            isMatch &= actualStatus.contains(expStatus);
        }
        return isMatch;
        // IsTransactionCreated(expDate: "2025-04-15"); // Only check date
        // IsTransactionCreated(expEmp: "John", expStatus: "Completed"); // Check employee and status
        // IsTransactionCreated("2025-04-15", "John", "Completed"); // Check all three
    }
    //endregion

    //region Alert Handling
    public static void acceptAlert()
    {
        // driver.switchTo().alert().accept();
        switchTo().alert().accept();
    }

    public void dismissAlert()
    {
        // driver.switchTo().alert().dismiss();
        switchTo().alert().dismiss();
    }

    public String getAlertText()
    {
        // return driver.switchTo().alert().getText();
        return switchTo().alert().getText();
    }

    public void sendKeysToAlert(String text)
    {
        // driver.switchTo().alert().sendKeys(text);
        switchTo().alert().sendKeys(text);
    }
    //endregion

    //region JavaScript Executor
    public static void executeScript(String script, Object... args)
    {
        // JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // jsExecutor.executeScript(script, args);
        executeJavaScript(script, args);
    }

    public Object executeScriptWithReturn(String script, Object... args)
    {
        // JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // return jsExecutor.executeScript(script, args);
        return executeJavaScript(script, args);
    }

    public void scrollToBottom()
    {
        // executeScript(driver, "window.scrollTo(0, document.body.scrollHeight);");
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollToTop()
    {
        // executeScript(driver, "window.scrollTo(0, 0);");
        executeJavaScript("window.scrollTo(0, 0);");
    }

    public void scrollIntoView(SelenideElement element)
    {
        // executeScript(driver, "arguments[0].scrollIntoView(true);", element);
        executeJavaScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void clickElementByJavaScript(SelenideElement element)
    {
        // executeScript(driver, "arguments[0].click();", element);
        executeJavaScript("arguments[0].click();", element);
    }

    public void setAttribute(SelenideElement element, String attributeName, String attributeValue)
    {
        // executeScript(driver, "arguments[0].setAttribute(...)", element);
        executeJavaScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", element);
    }

    public String getAttribute(SelenideElement element, String attributeName)
    {
        // return (String) executeScriptWithReturn(driver, "return arguments[0].getAttribute(...)", element);
        return executeJavaScript("return arguments[0].getAttribute('" + attributeName + "');", element);
    }

    public void highlightElement1(SelenideElement element)
    {
        // executeScript(driver, "arguments[0].style.border='3px solid red'", element);
        executeJavaScript("arguments[0].style.border='3px solid red'", element);
    }

    public static void highlightElement(SelenideElement element, boolean highlight)
    {
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        if (highlight)
        {
            // js.executeScript("arguments[0].style.border='3px solid red'", element);
            executeJavaScript("arguments[0].style.border='3px solid red'", element);
        } else
        {
            // js.executeScript("arguments[0].style.border=''", element);
            executeJavaScript("arguments[0].style.border=''", element);
        }
    }

    public void refreshBrowserUsingJS()
    {
        // executeScript(driver, "history.go(0);");
        executeJavaScript("history.go(0);");
    }

    public void openNewTabUsingJS()
    {
        // executeScript(driver, "window.open();");
        executeJavaScript("window.open();");
    }
    //endregion

    //region Frame Handling
    public void switchToFrameByIndex(int index)
    {
        // driver.switchTo().frame(index);
        switchTo().frame(index);
    }

    public void switchToFrameByNameOrId(String nameOrId)
    {
        // driver.switchTo().frame(nameOrId);
        switchTo().frame(nameOrId);
    }

    public void switchToFrameByElement(SelenideElement element)
    {
        // WebElement frameElement = element;
        // driver.switchTo().frame(frameElement);
        switchTo().frame(element);
    }

    public void switchToDefaultContent()
    {
        // driver.switchTo().defaultContent();
        switchTo().defaultContent();
    }

    public void switchToParentFrame()
    {
        // driver.switchTo().parentFrame();
        switchTo().parentFrame();
    }

    //endregion

    //region Mouse Actions
    public void hoverOverElement(SelenideElement locator)
    {
        // actions.moveToElement(locator).perform();
        actions().moveToElement(locator).perform();
    }

    public void dragAndDrop1(SelenideElement sourceLocator, SelenideElement targetLocator)
    {
        // actions.dragAndDrop(sourceLocator, targetLocator).perform();
        actions().dragAndDrop(sourceLocator, targetLocator).perform();
    }

    public static void moveToElement(SelenideElement element)
    {
        // actions.moveToElement(element).perform();
        actions().moveToElement(element).perform();
    }

    public static void clickAndHold(SelenideElement element)
    {
        // actions.clickAndHold(element).perform();
        actions().clickAndHold(element).perform();
    }

    public static void release()
    {
        // actions.release().perform();
        actions().release().perform();
    }

    public static void doubleClick(SelenideElement element)
    {
        // actions.doubleClick(element).perform();
        actions().doubleClick(element).perform();
    }

    public static void contextClick(SelenideElement element)
    {
        // actions.contextClick(element).perform();
        actions().contextClick(element).perform();
    }

    public static void dragAndDrop(SelenideElement source, SelenideElement target)
    {
        // actions.dragAndDrop(source, target).perform();
        actions().dragAndDrop(source, target).perform();
    }

    public static void dragAndDropByOffset(SelenideElement element, int xOffset, int yOffset)
    {
        // actions.dragAndDropBy(element, xOffset, yOffset).perform();
        actions().dragAndDropBy(element, xOffset, yOffset).perform();
    }

    public static void moveSliderByOffset(SelenideElement locator, int xOffset)
    {
        // actions.clickAndHold(locator).moveByOffset(xOffset, 0).release().perform();
        actions().clickAndHold(locator).moveByOffset(xOffset, 0).release().perform();
    }

    public void scrollToElement(SelenideElement element)
    {
        // actions.scrollFromOrigin(origin, 0, 0).perform();
        actions().scrollFromOrigin(WheelInput.ScrollOrigin.fromElement(element.getWrappedElement()), 0, 0).perform();
    }

    public void moveToLocation(int x, int y)
    {
        // actions.moveByOffset(x, y).perform();
        actions().moveByOffset(x, y).perform();
    }

    public void scrollByAmount(int deltaX, int deltaY)
    {
        // actions.scrollByAmount(deltaX, deltaY).perform();
        actions().scrollByAmount(deltaX, deltaY).perform();
    }

    public void scrollFromOrigin(WheelInput.ScrollOrigin origin, int deltaX, int deltaY)
    {
        // actions.scrollFromOrigin(origin, deltaX, deltaY).perform();
        actions().scrollFromOrigin(origin, deltaX, deltaY).perform();
    }
    //endregion

    //region File Upload
    public void uploadFile(SelenideElement locator, String filePath)
    {
        // waitForElement(locator).sendKeys(filePath);
        locator.uploadFile(new File(filePath));
    }
    //endregion
}