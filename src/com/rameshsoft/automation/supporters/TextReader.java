package com.rameshsoft.automation.supporters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {
public static void main(String[] args) throws IOException {
	
	File file = new File("E:\\MyWorkspace\\frameworks830am\\src\\com\\rameshsoft\\automation\\supporters\\test.txt");
	boolean status = file.createNewFile();
	
	if (status) {
		System.out.println("File is created");
	}
	else{
		System.out.println("Return existing file");
	}
	
	FileReader fr = new FileReader(file);
	BufferedReader br = new BufferedReader(fr);
	//br.readLine();
	while(br.ready()){
		System.out.println(br.readLine());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
