package com.rameshsoft.automation.supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ApplicationProperties {

	private String filePath;
	private FileInputStream fip;
	private Properties properties;
	
	public ApplicationProperties(String filePath) throws IOException
	{
		this.filePath = filePath;
		fip = new FileInputStream(filePath);
		properties = new Properties();
		if (properties!=null) {
			properties.load(fip);
		}
		else
		{
			//throw new FrameworkException("PROPERTIES OBJECT IS NOT INITIALISED");
		}
	}
	
	public String getPropertyValue(String key) {
		String value = properties.getProperty(key);
		return value;
	}
	
	public String getPropertyValue(String key,String defaultValue) {
		String value = properties.getProperty(key,defaultValue);
		if (value == null) {
			value = defaultValue;
		}
		return value;
	}
	
	public String getPropertyValue(Object key) {
		String value = (String) properties.get(key);
		return value;
	}
	
	public String getPropertyValue(Object key,Object defaultValue) {
		String value = (String) properties.getOrDefault(key, defaultValue);
		if (value == null) {
			value = (String) defaultValue;
		}
		return value;
	}
	
	public Set keysSet() {
		Set keys = properties.keySet();
		return keys;
	}
	
	public Map<String, String> keyValueSet() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		Set keys = properties.keySet();
		for(Object obj : keys){
			String key = (String) obj;
			String value = properties.getProperty(key);
			map.put(key, value);
		}
		return map;
	}
	
	public void writeKeyValue(String key,String value) throws FileNotFoundException, IOException {
		properties.setProperty(key, value);
		properties.store(new FileOutputStream(filePath), "file is saved succesfully");
	}
	
	public void writeKeyValue(Object key,Object value) throws FileNotFoundException, IOException {
		properties.put(key, value);
		properties.store(new FileOutputStream(filePath), "file is saved succesfully");
	}
}


