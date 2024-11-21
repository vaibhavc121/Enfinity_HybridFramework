package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

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
		BaseClass.driver.navigate().back();
	}
	
	public static void clkNew()
	{
		BaseClass.driver.findElement(By.xpath("//span[normalize-space()='New']")).click();
	}
	
	public static void filterCell2(String name)
	{
		BaseClass.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(name);
		BaseClass.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(Keys.ENTER);
	}
	
	public static void filterCell5(String name)
	{
		BaseClass.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys(name);
		BaseClass.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys(Keys.ENTER);
	}
	
	public static void filterCell6(String name)
	{
		BaseClass.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[6]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(name);
	}
	
	public static void filterCell7(String name)
	{
		BaseClass.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[7]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(name);
	}
	
	public static void filterCell8(String name)
	{
		BaseClass.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[8]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(name);
	}
	
	public static void filterCell9(String name)
	{
		BaseClass.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[9]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(name);
	}
	
	public static void filterCell10(String name)
	{
		BaseClass.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[10]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")).sendKeys(name);
	}
	
	public static String result5()
	{
		String result= BaseClass.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]")).getText();
		return result;
	}
	
	public static String result6()
	{
		String result= BaseClass.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/span[1]/a[1]")).getText();
		return result;
	}
	
	public static String result7()
	{
		String result= BaseClass.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/span[1]/a[1]")).getText();
		return result;
	}
	
	public static String result8()
	{
		String result= BaseClass.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[8]")).getText();
		return result;
	}
	
	public static String result9()
	{
		String result= BaseClass.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[9]")).getText();
		return result;
	}
	
	public static String result10()
	{
		String result= BaseClass.driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[10]")).getText();
		return result;
	}

}
