package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import Items.Armor;
import Items.BodyPart;
import Items.Equipment;
import Items.Weapon;
import all.Player;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.SystemColor;

public class WindowBuilder {

	private JFrame frame;
	static String language;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		

		Player play = new Player();
		play.equipStatus.showFullStatus();
		BodyPart legs = new BodyPart("legs");
		Equipment newLegs = new Armor("Штанишки", 5, legs);
		newLegs.equip(play);
		Equipment someSword = new Weapon("Меч какой-таааа", 10);
		someSword.equip(play);

		
		
		play.equipStatus.showFullStatus();

		LanguageFrame f = new LanguageFrame();
		
		//////////////////////////////////
		///////////////////////////////////////
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilder window = new WindowBuilder();
					window.frame.setVisible(false);
					} catch (Exception e) {
						e.printStackTrace();
						}
				}
		});
		
		/////////////////////////////////
	}

	/**
	 * Create the application.
	 */
	public WindowBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int height = 800;
		int width = 1280;		
		frame = new JFrame();
		frame.setVisible(false);
		frame.setBounds(100, 100, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		////////////////////////////////////////////////
		JPanel backgroundPanel = new ImagePanel();
		springLayout.putConstraint(SpringLayout.NORTH, backgroundPanel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, backgroundPanel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, backgroundPanel, 765, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, backgroundPanel, 1274, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(backgroundPanel);		
		try {
			((ImagePanel) backgroundPanel).setImage(ImageIO.read(new File("src\\images\\background1280x800.jpg")));
			} catch (IOException e) {
				e.printStackTrace();
			}	
			SpringLayout sl_backgroundPanel = new SpringLayout();
			backgroundPanel.setLayout(sl_backgroundPanel);
			
			JButton playBtn = new JButton("Play");
			playBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
			sl_backgroundPanel.putConstraint(SpringLayout.NORTH, playBtn, 148, SpringLayout.NORTH, backgroundPanel);
			sl_backgroundPanel.putConstraint(SpringLayout.WEST, playBtn, 492, SpringLayout.WEST, backgroundPanel);
			sl_backgroundPanel.putConstraint(SpringLayout.SOUTH, playBtn, -521, SpringLayout.SOUTH, backgroundPanel);
			sl_backgroundPanel.putConstraint(SpringLayout.EAST, playBtn, -492, SpringLayout.EAST, backgroundPanel);
			backgroundPanel.add(playBtn);
			
			JButton settingsBtn = new JButton("Settings");
			settingsBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
			sl_backgroundPanel.putConstraint(SpringLayout.NORTH, settingsBtn, 23, SpringLayout.SOUTH, playBtn);
			sl_backgroundPanel.putConstraint(SpringLayout.WEST, settingsBtn, 492, SpringLayout.WEST, backgroundPanel);
			sl_backgroundPanel.putConstraint(SpringLayout.SOUTH, settingsBtn, -402, SpringLayout.SOUTH, backgroundPanel);
			sl_backgroundPanel.putConstraint(SpringLayout.EAST, settingsBtn, 0, SpringLayout.EAST, playBtn);
			backgroundPanel.add(settingsBtn);
			
			JButton exitBtn = new JButton("Exit");
			exitBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
			sl_backgroundPanel.putConstraint(SpringLayout.WEST, exitBtn, 492, SpringLayout.WEST, backgroundPanel);
			sl_backgroundPanel.putConstraint(SpringLayout.SOUTH, exitBtn, -158, SpringLayout.SOUTH, backgroundPanel);
			sl_backgroundPanel.putConstraint(SpringLayout.EAST, exitBtn, 0, SpringLayout.EAST, playBtn);
			backgroundPanel.add(exitBtn);
			
			JButton helpBtn = new JButton("Help");
			helpBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
			sl_backgroundPanel.putConstraint(SpringLayout.NORTH, exitBtn, 27, SpringLayout.SOUTH, helpBtn);
			sl_backgroundPanel.putConstraint(SpringLayout.NORTH, helpBtn, 25, SpringLayout.SOUTH, settingsBtn);
			sl_backgroundPanel.putConstraint(SpringLayout.WEST, helpBtn, 492, SpringLayout.WEST, backgroundPanel);
			sl_backgroundPanel.putConstraint(SpringLayout.SOUTH, helpBtn, -281, SpringLayout.SOUTH, backgroundPanel);
			sl_backgroundPanel.putConstraint(SpringLayout.EAST, helpBtn, 0, SpringLayout.EAST, playBtn);
			backgroundPanel.add(helpBtn);
			
		
		if (WindowBuilder.getLanguage()=="Russian") {
			playBtn.setText("Играть");
			settingsBtn.setText("Настройки");
			exitBtn.setText("Выход");
			helpBtn.setText("Помощь");
		}
		frame.setVisible(true);
		frame.setResizable(false);
		//////////////////////////////////////////////
	
	
	}
	
	public static void setLanguage(String s) {
		language = s;
	}
	
	public static String getLanguage() {
		return language;
	}
}
