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
	
	interface FuncInterface 
	{ 
	    // An abstract function 
	    void abstractFun(int x); 
	  
	    // A non-abstract (or default) function 
	    default void normalFun() 
	    { 
	       System.out.println("Hello"); 
	    } 
	} 
	
	public static void main(String args[]) {
		NumericTest isEven = (n) -> (n % 2) == 0;
		NumericTest isNegative = (n) -> (n < 0);
		
		System.out.println("isEven: " + isEven.computerTest(4));
		System.out.println("isNegative: " + isNegative.computerTest(5));
		
		MyGreeting morningGreeting = (String str) -> "Good Morning " + str + "!";
		MyGreeting nightGreeting = (str) -> "Good Night " + str + "!";
		
		System.out.println(morningGreeting.processName("Geek"));
		System.out.println(nightGreeting.processName("Geek2"));
		
		MyString reverseStr = (str) -> {
			String result = "";			
			for(int i = str.length()-1; i >= 0; i--)
				result += str.charAt(i);
			return result;
		};
		
		System.out.println("reverse (regular): " + reverseStr.myStringFunction("wow anna"));
		
		
		//String version of MyGenericInteface
		MyGeneric<String> reverse = (str) -> {
			String result = "";			
			for(int i = str.length()-1; i >= 0; i--)
				result += str.charAt(i);
			return result;
		};

		//Integer version of MyGeneric
		MyGeneric<Integer> factorial = (Integer n) -> {
			int result = 1;
			for(int i=1; i <= n; i++)
				result = i * result;
			return result;
		};
		
		// Output: omeD adbmaL
		System.out.println("reverse (generic): " + reverse.compute("Was it a cat I saw")); 

		// Output: 120
		System.out.println("factorial of 5 (generic): " + factorial.compute(5));
		
		
		System.out.println("reverse (pass interface as parameter): " + reverseStr(reverseStr, "Hello Lambda"));
		
		// lambda expression to implement above 
        // functional interface. This interface 
        // by default implements abstractFun() 
        FuncInterface fobj = (int x)->System.out.println(2*x); 
  
        // This calls above lambda expression and prints 10. 
        fobj.abstractFun(5);
	}

}
