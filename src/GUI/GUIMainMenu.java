package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUIMainMenu {
	private static int height;
	private static int width;
	private static String language;
	private static JPanel backgroundPanel;
	private static JFrame mainMenuFrame;	
	private static Box mainMenuBox;
	private static Box playerMenuBox;
	static ActionListener exitListener;
	static ActionListener playListener;
	static ActionListener createListener;
	static ActionListener loadListener;
	static JButton play;
	static JButton exit;	
	static JButton create;
	static JButton load;
	
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
	
	///////////////////////////////////////////INITIALIZE MAIN MENU
	///////////////////////////change border of BOX
	public static void initializeMainMenu() {		
		mainMenuFrame = new JFrame("RPG Strategy");
		backgroundPanel = new ImagePanel();	
		mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font BigFontTR = new Font("TimesRoman", Font.PLAIN, 27);
		mainMenuBox = new Box(3);
		playerMenuBox = new Box(3);
		
		///////////////////////////////////////////CHOOSEN RESOLUTION
		if (GUIMainMenu.getResolution()==2080) {
			mainMenuFrame.setSize(1280, 800);	
			try {
				((ImagePanel) backgroundPanel).setImage(ImageIO.read(new File("src\\images\\background1280x800.jpg")));
				} catch (IOException e) {
					e.printStackTrace();
				}			
		} else {
			mainMenuFrame.setSize(800, 600);
			try {
				((ImagePanel) backgroundPanel).setImage(ImageIO.read(new File("src\\images\\background800x600.jpg")));
				} catch (IOException e) {
					e.printStackTrace();
				}
		}		
		mainMenuFrame.setResizable(false);
		mainMenuFrame.getContentPane().add(backgroundPanel);	
		mainMenuFrame.setVisible(true);
		
		///////////////////////////////////////////CHOOSEN LANGUAGE
		if (GUIMainMenu.getLanguage()=="English") {
			play = new JButton("Play");
			exit = new JButton("Exit");
			create = new JButton("Create new character");
			load = new JButton("Load charachter");
		} else {
			play = new JButton("Играть");
			exit = new JButton("Выход");
			create = new JButton("Создать нового персонажа");
			load = new JButton("Загрузить персонажа");
		}
	
		mainMenuBox.add(play);
		mainMenuBox.add(exit);
		backgroundPanel.add(mainMenuBox);
		exitListener = new ExitListener();
		playListener = new PlayListener();
		play.setFont(BigFontTR);
		exit.setFont(BigFontTR);	
		exit.addActionListener(exitListener);
		play.addActionListener(playListener);
		
		playerMenuBox.add(create);
		playerMenuBox.add(load);
		createListener = new CreateListener();
		loadListener = new LoadListener();
		create.setFont(BigFontTR);
		load.setFont(BigFontTR);
		create.addActionListener(createListener);
		load.addActionListener(loadListener);
		playerMenuBox.setVisible(false);
		
	}
	
	static class ExitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}		
	}
	
	static class PlayListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mainMenuBox.setVisible(false);
			backgroundPanel.remove(mainMenuBox);
			backgroundPanel.add(playerMenuBox);
			playerMenuBox.setVisible(true);
		}		
	}
	
	static class CreateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}		
	}
	
	static class LoadListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}		
	}

}
