package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUIMainFrame {
	private static int height;
	private static int width;
	private static String language;
	
	public static void setLanguage(String s) {
		language = s;
	}
	
	public static String getLanguage() {
		return language;
	}
	
	public static void setResolution(int height1, int width1) {
		height = height1;
		width = width1;
	}
	
	public static int getResolution() {
		return height+width;
	}
	
}

