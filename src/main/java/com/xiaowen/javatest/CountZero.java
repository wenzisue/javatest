package com.xiaowen.javatest;
import java.util.*;
import java.lang.*;
import java.io.*;

class CountZero {
	public static void main (String[] args) {
		int argIndex = 0;
		int numTests = Integer.parseInt(args[argIndex].trim());
		for(int i = 0; i < numTests; i++) {
		    int numElements = Integer.parseInt(args[++argIndex].trim());
		    int zeroCount = 0;
		    for(int j = 0; j < numElements; j++) {
		    	if(args[++argIndex].trim().equals("0"))
		            zeroCount++;
		    }

		    System.out.println(zeroCount);
		}
	}
	
}
