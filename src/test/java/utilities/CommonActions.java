package utilities;

import org.openqa.selenium.By;

import testBase.BaseClass;

public class CommonActions
{
	
	public static void clkView()
	{
		BaseClass.driver.findElement(By.xpath("//span[normalize-space()='View']")).click();
	}
	
	public static void clkApprove()
	{
		BaseClass.driver.findElement(By.xpath("//span[normalize-space()='Approve']")).click();				
	}

}
