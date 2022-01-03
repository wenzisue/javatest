package com.xiaowen.javatest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessFile {
	public static void main(String[] args) {
		BufferedReader reader;
		String docId = "1559";
		String field = null;
		int lineCount = 0;

		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\xiaowen.wu\\work\\OL\\Tasks_from_Jen\\"
					+ "LotTankForm\\fields.txt"));
			String line = reader.readLine();
			while (line != null && !line.isEmpty()) {
				field = "F"+docId+"_"+line.trim();
				
//				if(line.contains("CkBx")){
//					//for web template
//					System.out.println("<input id=\""+field+"\" " + "name=\"" + field + "\" type=\"checkbox\">");
//					System.out.println("<br>");
//					
//					
//				} else if (line.contains("Radio")) {
//					//for web template
//					System.out.println("<input id=\""+field+"\" " + "name=\"" + field + "\" type=\"radio\">");
//					System.out.println("radio_val");
//
//					
//				} else { //text input
//					//for web template
//					System.out.println("<input id=\""+field+"\" " + "name=\"" + field +  "\" class=\"form-control biggerfield\"" +  " type=\"text\">");
//					
//				}
				
				//for print template
				System.out.println("@f_"+field+"@");
				
				
				// read next line
				line = reader.readLine();
				lineCount++;
			}
			

			System.out.println("count: " + lineCount);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

