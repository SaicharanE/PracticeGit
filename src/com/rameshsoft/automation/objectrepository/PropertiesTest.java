package com.rameshsoft.automation.objectrepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
public static void main(String[] args) throws IOException {
	
	FileInputStream fip = new FileInputStream("E:\\MyWorkspace\\frameworks830am\\src\\com\\rameshsoft\\automation\\objectrepository\\OR.properties");
	Properties properties = new Properties();
	properties.load(fip);
	
	Set keys = properties.keySet();
	for(Object obj : keys){
		String key = (String) obj;
		String value = properties.getProperty(key);
		System.out.println(key+"   "+value);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*properties.setProperty("hello", "easy");
	properties.setProperty("easy", "try to understand");
	properties.setProperty("sal", "25000");
	
	
	properties.store(new FileOutputStream("E:\\MyWorkspace\\frameworks830am\\src\\com\\rameshsoft\\automation\\objectrepository\\Hello.properties"), "File is saved successfully");*/
	/*String practiceValue = properties.getProperty("practice","hello plz practice");
	String practiceHrsValue = properties.getProperty("practiceHrs");
	String whoworkshardValue = properties.getProperty("whoworkshard");
	String swjobValue = properties.getProperty("swjob");
	
	
	
	System.out.println(practiceHrsValue+"  "+practiceValue+"   "+whoworkshardValue+"   "+swjobValue);
	
	*/
	
	
	
	
	
	
	
	
	
}
}
