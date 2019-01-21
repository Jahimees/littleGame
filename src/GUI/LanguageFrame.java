package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LanguageFrame implements ActionListener {
	JFrame RALFrame;
	JPanel choosePanel;
	JRadioButton languageEnglish;
	JRadioButton languageRussian;
	ButtonGroup languageGroup;
	Box languageBox;
	JButton confirm;
	ActionListener confirmListener;
	
	public LanguageFrame() {
		RALFrame = new JFrame("Choose language");
		choosePanel = new ImagePanel();
		try {
			((ImagePanel) choosePanel).setImage(ImageIO.read(new File("src\\images\\language.jpg")));
			} catch (IOException e) {
				e.printStackTrace();
			}		
		RALFrame.setSize(250, 300);
		RALFrame.getContentPane().add(choosePanel);
		RALFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font BigFontTR = new Font("TimesRoman", Font.PLAIN, 27);
		
		//////////////////////LANGUAGE
		languageGroup = new ButtonGroup();
		languageBox = new Box(3);
		languageEnglish = new JRadioButton("English");
		languageEnglish.setFont(BigFontTR);
		languageEnglish.setBackground(null);
		languageEnglish.setSelected(true);
		languageRussian = new JRadioButton("Русский");
		languageRussian.setFont(BigFontTR);
		languageBox.add(languageEnglish);
		languageBox.add(languageRussian);
		languageGroup.add(languageEnglish);
		languageGroup.add(languageRussian);
		
		choosePanel.add(languageBox, BorderLayout.CENTER);
		
		/////////////////////OK button
		confirm = new JButton("Confirm");
		confirm.addActionListener(this);
		confirm.setFont(BigFontTR);	
	    choosePanel.add(confirm, BorderLayout.SOUTH);		
		
		
		RALFrame.add(choosePanel);
		RALFrame.setResizable(false);
		RALFrame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (languageEnglish.isSelected()) {			
			WindowBuilder.setLanguage("English");
		} else {					
			WindowBuilder.setLanguage("Russian");
		}
		System.out.println(WindowBuilder.getLanguage()+" language is selected");
				
		RALFrame.setVisible(false);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilder window = new WindowBuilder();
					} catch (Exception e) {
						e.printStackTrace();
						}
				}
		});
		
	}		
}