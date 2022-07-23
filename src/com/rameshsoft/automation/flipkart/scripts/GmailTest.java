package com.rameshsoft.automation.flipkart.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.rameshsoft.automation.base.BaseEngine;
import com.rameshsoft.automation.supporters.ApplicationProperties;
import com.rameshsoft.automation.supporters.ExcelReader;
import com.rameshsoft.automation.utilities.AppFilePaths;
import com.relevantcodes.extentreports.LogStatus;

public class GmailTest extends BaseEngine {

	@Test
	public void gmail_Login_Test() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException {
		ApplicationProperties appConf = new ApplicationProperties(AppFilePaths.confFilePath);
		String URL = appConf.getPropertyValue("prod_url");
		getDriver().get(URL);
		getExtentTest().log(LogStatus.INFO, "URL is entered as: " +URL);
		
		
		ExcelReader er = new ExcelReader("E:\\MyWorkspace\\frameworks830am\\src\\com\\rameshsoft\\automation\\testdata\\test.xls");
		String un = er.getSingleCellData("Sheet1", 0, 0);
		String pwd1 = er.getSingleCellData("Sheet1", 0, 1);
		ApplicationProperties appOr = new ApplicationProperties(AppFilePaths.orFilePath);
		String unId = appOr.getPropertyValue("un_id");
		String nextXapth = appOr.getPropertyValue("next_xpath");
		WebElement element = getDriver().findElement(By.id(unId));
		element.clear();
		getExtentTest().log(LogStatus.INFO, "CLEARING THE FILED: UN");
		element.sendKeys(un);
		getExtentTest().log(LogStatus.INFO, "Data Typing Action is done on UN element with test data: " +un);
		WebElement next = getDriver().findElement(By.xpath(nextXapth));
		next.click();
		getExtentTest().log(LogStatus.INFO, "Clicked on NEXT button");
		
		Thread.sleep(3000);
		
		WebElement pwd = getDriver().findElement(By.name(appOr.getPropertyValue("pwd_name")));
		pwd.clear();
		getExtentTest().log(LogStatus.INFO, "CLEARING THE FILED: UN");
		pwd.sendKeys(pwd1);
		getExtentTest().log(LogStatus.INFO, "Data Typing Action is done on UN element with test data: " +pwd1);
		
		WebElement signin = getDriver().findElement(By.xpath(appOr.getPropertyValue("signin_xpath")));
		signin.click();
		getExtentTest().log(LogStatus.INFO, "Clicked on SIGNIN button");
		
	}	
}
