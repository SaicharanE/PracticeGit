package com.rameshsoft.automation.supporters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextReaderWriter {

	private String filePath;
	private FileReader fileReader;
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	private BufferedReader bufferedReader;
	
	
	public TextReaderWriter(String filePath) throws IOException
	{
		this.filePath = filePath;
		File file = new File(filePath);
		if (file.createNewFile()) {
			System.out.println("File is created newly!");
		}
		else{
			System.out.println("Return existing file!");
		}
		fileWriter = new FileWriter(file);
		bufferedWriter = new BufferedWriter(fileWriter);
		
		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
	}
	
	public String getSingleLineData() throws IOException {
		return bufferedReader.readLine();
	}
	
	public List<String> getTotalData() throws IOException {
		List<String> data = new ArrayList<String>();
		while(bufferedReader.ready()){
			String data1 = bufferedReader.readLine();
			data.add(data1);
		}
		return data;
	}
	
	public void writeData(int data) throws IOException {
		bufferedWriter.write(data);
		bufferedWriter.flush();
	}
	
	public void writeData(String data) throws IOException {
		bufferedWriter.write(data);
		bufferedWriter.flush();
	}
}
