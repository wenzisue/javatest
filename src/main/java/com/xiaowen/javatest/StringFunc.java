package com.xiaowen.javatest;

public class StringFunc {
	
	public static void main(String args[]) {
		String a = "Document is missing or has an incorrect diagnosis,";
		
		String b = a.substring(0, a.length());
		
		System.out.println(b);
		
		String c = a.substring(0, a.length() - 1);
		
		System.out.println(c);
		

	}
}
