package com.xiaowen.javatest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ProcessFile2 {
	public static void main(String[] args) {
		BufferedReader reader;

		int lineCount = 0;

		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\xiaowen.wu\\Downloads\\plans.csv"));
			
			BufferedWriter  bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\xiaowen.wu\\Downloads\\plans.txt")));
			
			
			String line = reader.readLine();
			while (line != null && !line.isEmpty()) {
				bw.write(line.toString().trim() + ",");
				
				// read next line
				line = reader.readLine();
				lineCount++;
			}
			

			System.out.println("count: " + lineCount);
			reader.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

