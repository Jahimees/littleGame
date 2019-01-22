package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import java.awt.Panel;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import javax.swing.ImageIcon;

public class MainWindow {

	public JFrame frame;
	static String language;
	JButton backBtn;
	JLabel createLabel;
	JLabel loadLabel;

	/**
	 * Create the application.
	 */
	public MainWindow() {
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
			backgroundPanel.setLayout(null);
			
			Panel mainPanel = new Panel();
			mainPanel.setBounds(500, 202, 265, 376);
			mainPanel.setBackground(UIManager.getColor("textHighlight"));
			backgroundPanel.add(mainPanel);
			SpringLayout sl_mainPanel = new SpringLayout();
			mainPanel.setLayout(sl_mainPanel);
			
			JButton playBtn = new JButton("Play");
			playBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					backBtn.setVisible(true);
					mainPanel.setVisible(false);
					createLabel.setVisible(true);
					loadLabel.setVisible(true);
				}
			});
			sl_mainPanel.putConstraint(SpringLayout.NORTH, playBtn, 0, SpringLayout.NORTH, mainPanel);
			sl_mainPanel.putConstraint(SpringLayout.WEST, playBtn, 0, SpringLayout.WEST, mainPanel);
			sl_mainPanel.putConstraint(SpringLayout.SOUTH, playBtn, 94, SpringLayout.NORTH, mainPanel);
			sl_mainPanel.putConstraint(SpringLayout.EAST, playBtn, 265, SpringLayout.WEST, mainPanel);
			mainPanel.add(playBtn);
			playBtn.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
			
			JButton helpBtn = new JButton("Help");
			sl_mainPanel.putConstraint(SpringLayout.NORTH, helpBtn, 94, SpringLayout.NORTH, mainPanel);
			sl_mainPanel.putConstraint(SpringLayout.WEST, helpBtn, 0, SpringLayout.WEST, mainPanel);
			sl_mainPanel.putConstraint(SpringLayout.SOUTH, helpBtn, 188, SpringLayout.NORTH, mainPanel);
			sl_mainPanel.putConstraint(SpringLayout.EAST, helpBtn, 265, SpringLayout.WEST, mainPanel);
			mainPanel.add(helpBtn);
			helpBtn.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
			
			JButton settingsBtn = new JButton("Settings");
			sl_mainPanel.putConstraint(SpringLayout.NORTH, settingsBtn, 188, SpringLayout.NORTH, mainPanel);
			sl_mainPanel.putConstraint(SpringLayout.WEST, settingsBtn, 0, SpringLayout.WEST, mainPanel);
			sl_mainPanel.putConstraint(SpringLayout.SOUTH, settingsBtn, 282, SpringLayout.NORTH, mainPanel);
			sl_mainPanel.putConstraint(SpringLayout.EAST, settingsBtn, 265, SpringLayout.WEST, mainPanel);
			mainPanel.add(settingsBtn);
			settingsBtn.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
			
			JButton exitBtn = new JButton("Exit");
			sl_mainPanel.putConstraint(SpringLayout.NORTH, exitBtn, 282, SpringLayout.NORTH, mainPanel);
			sl_mainPanel.putConstraint(SpringLayout.WEST, exitBtn, 0, SpringLayout.WEST, mainPanel);
			sl_mainPanel.putConstraint(SpringLayout.SOUTH, exitBtn, 376, SpringLayout.NORTH, mainPanel);
			sl_mainPanel.putConstraint(SpringLayout.EAST, exitBtn, 265, SpringLayout.WEST, mainPanel);
			mainPanel.add(exitBtn);
			exitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			exitBtn.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
			
			
			backBtn = new JButton("Back");
			backBtn.setVisible(false);
			backBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					backBtn.setVisible(false);
					mainPanel.setVisible(true);
					createLabel.setVisible(false);
					loadLabel.setVisible(false);
				}
			});
			backBtn.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
			backBtn.setBounds(500, 584, 265, 70);
			backgroundPanel.add(backBtn);
					
			
			/////////////////////////////create/////////////////////////
			createLabel = new JLabel("");
			createLabel.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					if (MainWindow.getLanguage()=="English") {
						createLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/createEngEntered.png")));
					} else { 
						createLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/createRusEntered.png")));
					}
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					if (MainWindow.getLanguage()=="English") {
						createLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/createEng.png")));
					} else { 
						createLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/createRus.png")));
					}
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
				}				
			});
			createLabel.setVisible(false);
			createLabel.setBounds(180, 202, 450, 398);
			backgroundPanel.add(createLabel);
			if (MainWindow.getLanguage()=="English") {
				createLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/createEng.png")));
			} else { 
				createLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/createRus.png")));
			}
			
			///////////////////////////////load///////////////////////////////
			loadLabel = new JLabel("");
			loadLabel.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					if (MainWindow.getLanguage()=="English") {
						loadLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/loadEngEntered.png")));
					} else { 
						loadLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/loadRusEntered.png")));
					}
				}
				@Override
				public void mouseExited(MouseEvent e) {
					if (MainWindow.getLanguage()=="English") {
						loadLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/loadEng.png")));
					} else { 
						loadLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/loadRus.png")));
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseReleased(MouseEvent e) {
				}
				});
			loadLabel.setVisible(false);
			loadLabel.setBounds(637, 202, 450, 398);
			backgroundPanel.add(loadLabel);
			if (MainWindow.getLanguage()=="English") {
				loadLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/loadEng.png")));
			} else { 
				loadLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/loadRus.png")));
			}
			
			playBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					backBtn.setVisible(true);
					mainPanel.setVisible(false);
					createLabel.setVisible(true);
					loadLabel.setVisible(true);
				}
			});
			
			
		//////////////////////////RUSSIAN LANGUAGE////////////////////////////////////
		if (MainWindow.getLanguage()=="Russian") {
			playBtn.setText("Играть");
			settingsBtn.setText("Настройки");
			exitBtn.setText("Выход");
			helpBtn.setText("Помощь");
			backBtn.setText("Назад");
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
