package com.rameshsoft.automation.flipkart.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.rameshsoft.automation.base.BaseEngine;

public class Flipkart_Test extends BaseEngine {

	@Test
	public void flipKartTest() {
		getDriver().get("https://www.flipkart.com");
		WebElement ele = getDriver().findElement(By.id("hello"));
		ele.click();
	}
	
}
