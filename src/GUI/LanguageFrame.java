package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LanguageFrame {
	static JFrame RALFrame;
	JPanel choosePanel;
	JLabel chooseEng;
	JLabel chooseRus;
	
	public LanguageFrame() {
		
		RALFrame = new JFrame("Choose language");
		choosePanel = new ImagePanel();
		try {
			((ImagePanel) choosePanel).setImage(ImageIO.read(new File("src\\images\\language.jpg")));
			} catch (IOException e) {
				e.printStackTrace();
			}		
		RALFrame.setSize(250, 250);
		RALFrame.getContentPane().add(choosePanel);
		RALFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//////////////////////LANGUAGE
		 chooseEng = new JLabel("");
		 chooseEng.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/chooseEng.png")));
		 chooseEng.setBounds(20, 20, 200, 80);
		 RALFrame.add(chooseEng);
		 chooseEng.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainWindow.setLanguage("English");
				LanguageFrame.init();
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}			 
		 });
		 
		 chooseRus = new JLabel("");
		 chooseRus.setIcon(new ImageIcon(MainWindow.class.getResource("/images/menuButtons/chooseRus.png")));
		 chooseRus.setBounds(20, 110, 200, 80);
		 RALFrame.add(chooseRus);
		 chooseRus.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					MainWindow.setLanguage("Russian");
					LanguageFrame.init();
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
				}
				@Override
				public void mousePressed(MouseEvent arg0) {
				}
				@Override
				public void mouseReleased(MouseEvent arg0) {
				}			 
			 });	
		
		RALFrame.add(choosePanel);
		RALFrame.setResizable(false);
		RALFrame.setVisible(true);
		
	}

	public static void init() {
		System.out.println(MainWindow.getLanguage()+" language is selected");
		
		RALFrame.setVisible(false);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					} catch (Exception e) {
						e.printStackTrace();
						}
				}
		});
	}
	
}