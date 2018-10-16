package com.xiaowen.javatest;

import java.util.Random;

public class Test {
	public static void main(String args[]) {

		String[] color = { "red", "blue", "yellow", "purple", "black" };

		Random rand = new Random();
		for (int i = 0; i < 5; i++) {
			int rand_int = rand.nextInt(5);
			String randomColors = (color[rand_int]);
			System.out.println(randomColors);
		}

	}
}
