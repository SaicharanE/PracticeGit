package com.rameshsoft.automation.supporters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextTest {
public static void main(String[] args) throws IOException {
	
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
	
	bw.write("Hello");
	bw.newLine();
	bw.write("PLZ PRACTICE");
	bw.newLine();
	bw.write("11 HRS FROM TODAY ONWARDS");
	bw.newLine();
	bw.write("SURE JOB VL BE IN UR HAND");
	bw.newLine();
	
	bw.flush();
	
	bw.close();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
