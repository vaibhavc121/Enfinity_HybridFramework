package testCases;

import org.testng.annotations.Test;

import pageObjects.HrCorePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_HrCoreTest extends BaseClass
{
	@Test
	public void verifyEmpCreation()
	{
		// login page
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(p.getProperty("username"));
		lp.setPwd(p.getProperty("pwd"));
		lp.clkSignin();

		// hr core
		HrCorePage hc = new HrCorePage(driver);
		hc.clkEmp();
		hc.clkBtnNew();
		hc.clkMgrDropdown();
		hc.slctMgr();
		hc.setName();
		hc.clkDept();
		hc.slctDept();
		hc.clkDesig();
		hc.slctDesig();
		hc.clkSave();

	}
}
