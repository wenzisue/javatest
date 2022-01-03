package com.xiaowen.javatest;

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Test {
	// compare if A is before B in dictionary
	static String compare(final String A, final String B) {
		int lengthA = A.length();
		int lengthB = B.length();
		int length = 0;

		if (lengthA >= lengthB) {
			length = lengthB;
		} else {
			length = lengthA;
		}

		for (int i = 0; i < length; i++) {
			if (A.charAt(i) > B.charAt(i))
				return "Yes";

			if (B.charAt(i) > A.charAt(i))
				return "No";
		}

		return "No";
	}

	public static String findDay(int month, int day, int year) {
		LocalDate localDate = LocalDate.of(year, month, day);

		// Getting the day of week for a given date
		java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		return dayOfWeek.toString();
	}

	static boolean isAnagram(String a, String b) {
		// Complete the function
		char[] word1 = a.replaceAll("[\\s]", "").toCharArray();
		char[] word2 = b.replaceAll("[\\s]", "").toCharArray();
		java.util.Arrays.sort(word1);
		java.util.Arrays.sort(word2);
		return java.util.Arrays.equals(word1, word2);
	}

	public static void main(String args[]) {
		/*
		 * String[] color = { "red", "blue", "yellow", "purple", "black" };
		 * 
		 * Random rand = new Random(); for (int i = 0; i < 5; i++) { int rand_int =
		 * rand.nextInt(5); String randomColors = (color[rand_int]);
		 * System.out.println(randomColors); }
		 * 
		 * String A = "ma"; String B = "mad";
		 * 
		 * System.out.println(A.length()+B.length()); System.out.println(compare(A, B));
		 * System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1) + " " +
		 * B.substring(0, 1).toUpperCase() + B.substring(1));
		 * 
		 * System.out.println(findDay(01, 01, 2019));
		 * 
		 * String a = "anagramm"; String b = "marganaa"; boolean ret = isAnagram(a, b);
		 * System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
		 * 
		 * SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy"); try { Date date =
		 * sdf.parse("2019-07-09T00:00:00"); System.out.println(date.toString()); }
		 * catch (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		Scanner in = new Scanner(System.in);
		System.out.print("Enter i Value:  ");
		int i = in.nextInt();
		System.out.print("Enter j Value:  ");
		int j = in.nextInt();
		if (i > j)
			System.out.println(i + "i is greater than " + j);
		else
			System.out.println(j + " is greater than " + i);

	}
}
