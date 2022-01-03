package com.xiaowen.javatest;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

public class MoveFiles {
	public static void main(String args[]) {
		System.out.println("start moving files ...");

		Iterator it = FileUtils.iterateFiles(
				new File("\\\\orppp4.rotech.com\\PlanetPress\\prodServer\\submittedForm\\"), null, false);

		while (it.hasNext()) {

			File source = (File) it.next();
			

			if (source.isFile() && source.getName().contains("Forms_2021January")) {
				Date lastModifiedDate = new Date(source.lastModified());
				
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(lastModifiedDate);
				int year = calendar.get(Calendar.YEAR);
				//Add one to month {0 - 11}
				int month = calendar.get(Calendar.MONTH) + 1;
				
				//int day = calendar.get(Calendar.DAY_OF_MONTH);	
				
				//System.out.println(year);
				
				System.out.println(source.getName());


				File dest = new File("\\\\orppp4.rotech.com\\PlanetPress\\prodServer\\archived\\submittedForm\\" + year
						+ "\\" + month + "\\" + source.getName());

				try {
					FileUtils.moveFile(source, dest);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		

	}
}
