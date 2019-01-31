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
import java.awt.PopupMenu;

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
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.JSlider;
import java.awt.Choice;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Locale;

public class MainWindow {

	public JFrame frame;
	JPanel backgroundPanel;
	static JPanel settingsPanel;
	static String language;
	static JLabel backLabel;	
	static JLabel loadLabel;
	static JLabel playLabel;
	static JLabel settingsLabel;
	static JLabel helpLabel;
	static JLabel exitLabel;
	static JLabel backLabelSettings;
	static Choice languageChoice;
	static JLabel createLabel;
	
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
		backgroundPanel = new ImagePanel();			
		settingsPanel = new ImagePanel();	
		
		///////////////////////////////LOAD CREATE LABEL///////////////////////////////
		loadLabel = new JLabel("");
		loadLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/loadEng.png")));
		loadLabel.setBounds(643, 180, 450, 398);		
		createLabel = new JLabel("");
		createLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/createEng.png")));
		createLabel.setBounds(181, 180, 450, 398);
		backgroundPanel.add(createLabel);
		backgroundPanel.add(loadLabel);
		
		//LISTENERS
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
		
		////////////////////////////CHOICE//////////////////////////////////
		languageChoice = new Choice();		
		languageChoice.setLocale(new Locale("aa"));
		languageChoice.setLocation(new Point(10, 10));
		languageChoice.setMinimumSize(new Dimension(100, 10));
		languageChoice.setSize(new Dimension(10, 10));
		languageChoice.setPreferredSize(new Dimension(10, 10));
		languageChoice.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		languageChoice.setFocusable(false);
		languageChoice.setFocusTraversalKeysEnabled(false);
		languageChoice.setFont(new Font("Baskerville Old Face", Font.BOLD, 28));
		languageChoice.setForeground(Color.BLACK);
		languageChoice.setBackground(new Color(222, 184, 135));
			
		languageChoice.setBounds(89, 313, 265, 34);
		if (getLanguage()=="English") {
			languageChoice.select("English");
			languageChoice.add("English");
			languageChoice.add("Русский");	
		} else {
			languageChoice.select("Русский");
			languageChoice.add("Русский");
			languageChoice.add("English");
		}
		
		/////////////////////////////FRAME/////////////////////////////
		frame = new JFrame();
		int height = 800;
		int width = 1280;	
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/images/icon.png")));
		frame.setVisible(false);
		frame.setBounds(100, 100, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		////////////////////////////////////////////////		
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
			
			
			///////////////////////////HELP BUTTON/////////////////////		
			helpLabel = new JLabel("");
			helpLabel.setBounds(500, 414, 265, 94);
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
			settingsLabel = new JLabel("");
			settingsLabel.setBounds(500, 307, 265, 94);
			backgroundPanel.add(settingsLabel);
			settingsLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/settingsEng.png")));
			settingsLabel.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					hideMainButtons();
					settingsPanel.setVisible(true);
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
			exitLabel = new JLabel("");
			exitLabel.setBounds(500, 521, 265, 94);
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
			playLabel = new JLabel("");
			playLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/playEng.png")));
			playLabel.setBounds(500, 200, 265, 94);
			backgroundPanel.add(playLabel);
			playLabel.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					backLabel.setVisible(true);
					hideMainButtons();
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
			
			
			///////////////////////////////////BACK BUTTON/////////////////////////////
			backLabel = new JLabel("");
			backLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backEng.png")));
			backLabel.setBounds(500, 623, 265, 93);
			backgroundPanel.add(backLabel);
			backLabel.setVisible(false);
			backLabel.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					backLabel.setVisible(false);
					showMainButtons();
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
			
		
		
			
			
			///////////////////////////////Settings///////////////////////////			
			settingsPanel.setVisible(false);			
			settingsPanel.setBounds(191, 104, 900, 600);
			backgroundPanel.add(settingsPanel);
			settingsPanel.setLayout(null);			
		
			
			settingsPanel.add(languageChoice);			
			
			//////////////////////////////BACK LABEL SETTINGS////////////////////
			backLabelSettings = new JLabel();
			backLabelSettings.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backEng.png")));
			backLabelSettings.setBounds(605, 477, 265, 94);
			settingsPanel.add(backLabelSettings);
			backLabel.setBounds(500, 623, 265, 93);
			backLabelSettings.setVisible(true);
			backLabelSettings.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					showMainButtons();
					settingsPanel.setVisible(false);
					if (languageChoice.getSelectedItem()=="Русский") {
						setRussian();
					} else { setEnglish(); }
					
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
						backLabelSettings.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backEngPressed.png")));
					} else {
						backLabelSettings.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backRusPressed.png")));
					}
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
					if (MainWindow.language=="English") {
						backLabelSettings.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backEng.png")));
					} else {
						backLabelSettings.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backRus.png")));
					}
				}
			});		
						
			
		//////////////////////////RUSSIAN LANGUAGE////////////////////////////////////
		if (MainWindow.getLanguage()=="Russian") {
			setRussian();
		} else {
			setEnglish();
		}
		frame.setVisible(true);
		frame.setResizable(false);
		//////////////////////////////////////////////	
	}
	
	protected void hideMainButtons() {
		playLabel.setVisible(false);	
		helpLabel.setVisible(false);
		settingsLabel.setVisible(false);
		exitLabel.setVisible(false);
	}
	
	protected void showMainButtons() {
		playLabel.setVisible(true);	
		helpLabel.setVisible(true);
		settingsLabel.setVisible(true);
		exitLabel.setVisible(true);
	}

	public static void setEnglish() {
		setLanguage("English");
		try {
		createLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/createEng.png")));
		loadLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/loadEng.png")));
		playLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/playEng.png")));
		helpLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/helpEng.png")));
		settingsLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/settingsEng.png")));
		exitLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/exitEng.png")));
		backLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backEng.png")));	
		backLabelSettings.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backEng.png")));
		
			((ImagePanel) settingsPanel).setImage(ImageIO.read(new File("src\\images\\settingsPanelEng.jpg")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		//repaint();
	}
	
	public static void setRussian() {
		setLanguage("Russian");
		createLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/createRus.png")));
		loadLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/loadRus.png")));
		playLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/playRus.png")));
		helpLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/helpRus.png")));
		settingsLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/settingsRus.png")));
		exitLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/exitRus.png")));
		backLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backRus.png")));	
		backLabelSettings.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/backRus.png")));
		try {
			((ImagePanel) settingsPanel).setImage(ImageIO.read(new File("src\\images\\settingsPanelRus.jpg")));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void setLanguage(String s) {
		language = s;
	}
	
	public static String getLanguage() {
		return language;
	}
}
