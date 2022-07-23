package com.rameshsoft.automation.flipkart.scripts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.rameshsoft.automation.base.BaseEngine;

public class AmazonTest extends BaseEngine {

	@Test
	public void amazonTest() throws IOException {
		getDriver().get("https://www.flipkart.com");
		WebElement ele = getDriver().findElement(By.xpath("//*[text()='Electronics'][@class='_1QZ6fC _3Lgyp8']"));
		Actions actions = new Actions(getDriver());
		actions.moveToElement(ele).build().perform();
		String text = ele.getText();
		File file = new File("E:\\MyWorkspace\\frameworks830am\\src\\com\\rameshsoft\\automation\\supporters\\test.txt");
		boolean status = file.createNewFile();
		
		if (status) {
			System.out.println("File is created");
		}
		else{
			System.out.println("Return existing file");
		}
		
		FileWriter fw = new FileWriter(file,true);
		
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(text);
		bw.flush();
		
		
		
		
		
		
		
		
		
		
	}
	
}
