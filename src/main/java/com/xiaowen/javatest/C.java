package com.xiaowen.javatest;

import java.lang.reflect.Field;

public class C {
	public static void main(String args[]) {
		Class c = A.class.getDeclaredClasses()[0];
		Field f;
		try {
			
			f = c.getDeclaredField("password");
			
			System.out.println(f.get(null));
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
