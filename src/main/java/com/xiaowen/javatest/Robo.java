package com.xiaowen.javatest;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.swing.JPanel;

public class Robo {
	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		String command = "notepad.exe";
		Runtime run = Runtime.getRuntime();
		run.exec(command);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Robot robot = new Robot();

		int i = 0;
		while (i++ < 1000) {
			robot.keyPress(KeyEvent.VK_H);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_E);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_L);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_L);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_O);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_SPACE);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_F);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_R);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_O);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_M);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_SPACE);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyPress(KeyEvent.VK_K);
			robot.keyPress(KeyEvent.VK_Y);
			robot.keyPress(KeyEvent.VK_N);
			robot.keyPress(KeyEvent.VK_E);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyPress(KeyEvent.VK_ENTER);

			Thread.sleep(120000);

		}

	}

}
