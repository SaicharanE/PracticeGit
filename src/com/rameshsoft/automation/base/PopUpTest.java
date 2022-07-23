package com.rameshsoft.automation.base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PopUpTest extends BaseEngine{
	@Test
public void main() throws InterruptedException {
	
	getDriver().get("file:///C:/Users/thripura/Desktop/alerts4/WindowUploadfile.html");
	
	getDriver().findElement(By.id("1")).sendKeys("C:\\Users\\thripura\\Desktop\\GitCommands.txt");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*getDriver().findElement(By.xpath("//*[@onclick='promptFunction()']")).click();
	
	Thread.sleep(3000);
	
	TargetLocator targetLocator = getDriver().switchTo();
	Alert alert = targetLocator.alert();
	
	alert.sendKeys("Hello plzpractice");
	//alert.sendKeys(Keys.TAB);
	Actions actions = new Actions(getDriver());
	actions.sendKeys(Keys.TAB).build().perform();
	alert.sendKeys("job");
	String alertTxt = alert.getText();
	System.out.println(alertTxt);
	
	alert.accept();*/
	
	Thread.sleep(8000);
	
	
	
	
	
	
	
	
	
	
	
}
}
