package com.xiaowen.javatest;

public class Lambda {
	interface NumericTest {
		boolean computerTest(int n);
	}
	
	interface MyGreeting {
		String processName(String str);
	}
	
	interface MyString {
		String myStringFunction(String str);
	}
	
	interface MyGeneric<T> {
		T compute(T t);
	}
	
	public static String reverseStr(MyString reverse, String str) {
		  return reverse.myStringFunction(str);
	}
	
	public static void main(String args[]) {
		NumericTest isEven = (n) -> (n % 2) == 0;
		NumericTest isNegative = (n) -> (n < 0);
		
		System.out.println("isEven: " + isEven.computerTest(4));
		System.out.println("isNegative: " + isNegative.computerTest(5));
		
		MyGreeting morningGreeting = (String str) -> "Good Morning " + str + "!";
		MyGreeting nightGreeting = (str) -> "Good Night " + str + "!";
		
		System.out.println(morningGreeting.processName("Anna"));
		System.out.println(nightGreeting.processName("Jonathan"));
		
		MyString reverseStr = (str) -> {
			String result = "";			
			for(int i = str.length()-1; i >= 0; i--)
				result += str.charAt(i);
			return result;
		};
		
		System.out.println(reverseStr.myStringFunction("Lambda Demo"));
		
		
		// String version of MyGenericInteface
		MyGeneric<String> reverse = (str) -> {
			String result = "";			
			for(int i = str.length()-1; i >= 0; i--)
				result += str.charAt(i);
			return result;
		};

		// Integer version of MyGeneric
		MyGeneric<Integer> factorial = (Integer n) -> {
			int result = 1;
			for(int i=1; i <= n; i++)
				result = i * result;
			return result;
		};
		
		// Output: omeD adbmaL
		System.out.println(reverse.compute("Lambda Demo")); 

		// Output: 120
		System.out.println(factorial.compute(5));
		
		
		System.out.println(reverseStr(reverseStr, "Hello Lambda"));
		
	}
}
