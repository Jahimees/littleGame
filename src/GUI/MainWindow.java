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
import java.beans.PropertyVetoException;
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
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import java.awt.Label;

public class MainWindow {

	public JFrame frame;
	static String language;
	JLabel backLabel;	
	JLabel loadLabel;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		try {
			initialize();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws PropertyVetoException {
		JLabel createLabel = new JLabel("");
		createLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/createEng.png")));
		int height = 800;
		int width = 1280;		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/images/icon.png")));
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
			if (MainWindow.getLanguage()=="English") {
				createLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/createEng.png")));
			} else { 
				createLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/createRus.png")));
			}
			
			///////////////////////////HELP BUTTON/////////////////////
			JLabel helpLabel = new JLabel("");
			helpLabel.setBounds(500, 354, 265, 94);
			backgroundPanel.add(helpLabel);
			helpLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/helpEng.png")));
			helpLabel.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
					if (MainWindow.language=="English") {
						helpLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/helpEngPressed.png")));
					} else {
						helpLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/helpRusPressed.png")));
					}
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
					if (MainWindow.language=="English") {
						helpLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/helpEng.png")));
					} else {
						helpLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/helpRus.png")));
					}
				}
			});
			
			//////////////////////SETTINGS BUTTON////////////////////////
			JLabel settingsLabel = new JLabel("");
			settingsLabel.setBounds(500, 247, 265, 94);
			backgroundPanel.add(settingsLabel);
			settingsLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/settingsEng.png")));
			settingsLabel.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
					if (MainWindow.language=="English") {
						settingsLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/settingsEngPressed.png")));
					} else {
						settingsLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/settingsRusPressed.png")));
					}
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
					if (MainWindow.language=="English") {
						settingsLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/settingsEng.png")));
					} else {
						settingsLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/settingsRus.png")));
					}
				}
			});
			settingsLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
			
			//////////////////////////////////EXIT BUTTON///////////////////////////
			JLabel exitLabel = new JLabel("");
			exitLabel.setBounds(500, 461, 265, 94);
			backgroundPanel.add(exitLabel);
			exitLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/exitEng.png")));
			exitLabel.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					System.exit(0);
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
					if (MainWindow.language=="English") {
						exitLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/exitEngPressed.png")));
					} else {
						exitLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/exitRusPressed.png")));
					}
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
					if (MainWindow.language=="English") {
						exitLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/exitEng.png")));
					} else {
						exitLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/exitRus.png")));
					}
				}
			});
			exitLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 20));
			
			///////////////////////////////////PLAY BUTTON/////////////////////////////////
			JLabel playLabel = new JLabel("");
			playLabel.setBounds(500, 140, 265, 94);
			backgroundPanel.add(playLabel);
			playLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/playEng.png")));
			playLabel.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					backLabel.setVisible(true);
					playLabel.setVisible(false);
					settingsLabel.setVisible(false);
					helpLabel.setVisible(false);
					exitLabel.setVisible(false);
					createLabel.setVisible(true);
					loadLabel.setVisible(true);
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
					if (MainWindow.language=="English") {
						playLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/playEngPressed.png")));
					} else {
						playLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/playRusPressed.png")));
					}
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
					if (MainWindow.language=="English") {
						playLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/playEng.png")));
					} else {
						playLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/playRus.png")));
					}
				}
			});
			createLabel.setBounds(181, 180, 450, 398);
			backgroundPanel.add(createLabel);
			
			///////////////////////////////////BACK BUTTON/////////////////////////////
			backLabel = new JLabel("");
			backLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backEng.png")));
			backLabel.setBounds(500, 568, 265, 93);
			backgroundPanel.add(backLabel);
			backLabel.setVisible(false);
			backLabel.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					backLabel.setVisible(false);
					playLabel.setVisible(true);
					settingsLabel.setVisible(true);
					helpLabel.setVisible(true);
					exitLabel.setVisible(true);
					createLabel.setVisible(false);
					loadLabel.setVisible(false);
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
					if (MainWindow.language=="English") {
						backLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backEngPressed.png")));
					} else {
						backLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backRusPressed.png")));
					}
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
					if (MainWindow.language=="English") {
						backLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backEng.png")));
					} else {
						backLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backRus.png")));
					}
				}
			});
			
			///////////////////////////////load///////////////////////////////
			loadLabel = new JLabel("");
			loadLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/loadEng.png")));
			loadLabel.setBounds(643, 180, 450, 398);
			backgroundPanel.add(loadLabel);
			
			JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
			internalFrame.setBounds(12, 75, 189, 148);
			backgroundPanel.add(internalFrame);
			internalFrame.setVisible(true);
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
			if (MainWindow.getLanguage()=="English") {
				loadLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/loadEng.png")));
			} else { 
				loadLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/loadRus.png")));
			}
			
						
			
		//////////////////////////RUSSIAN LANGUAGE////////////////////////////////////
		if (MainWindow.getLanguage()=="Russian") {
			playLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/playRus.png")));
			helpLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/helpRus.png")));
			settingsLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/settingsRus.png")));
			exitLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/exitRus.png")));
			backLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backRus.png")));
			settingsLabel.setText("Настройки");
			exitLabel.setText("Выход");
			helpLabel.setText("Помощь");
			backLabel.setText("Назад");
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
