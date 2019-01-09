package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ResolutionAndLanguageFrame implements ActionListener {
	JFrame RALFrame;
	JPanel choosePanel;
	JRadioButton lowResolution;
	JRadioButton highResolution;
	JRadioButton languageEnglish;
	JRadioButton languageRussian;
	ButtonGroup resolutionGroup;
	ButtonGroup languageGroup;
	Box resolutionBox;
	Box languageBox;
	JButton confirm;
	ActionListener confirmListener;
	
	public ResolutionAndLanguageFrame() {
		RALFrame = new JFrame("Choose resolution and language");
		choosePanel = new ImagePanel();
		try {
			((ImagePanel) choosePanel).setImage(ImageIO.read(new File("src\\images\\resolution and language.jpg")));
			} catch (IOException e) {
				e.printStackTrace();
			}		
		RALFrame.setSize(400, 180);
		RALFrame.getContentPane().add(choosePanel);
		RALFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font BigFontTR = new Font("TimesRoman", Font.PLAIN, 27);
		//////////////////////RESOLUTION
		resolutionGroup = new ButtonGroup();
		resolutionBox = new Box(3);
		lowResolution = new JRadioButton("800x600");
		lowResolution.setFont(BigFontTR);
		lowResolution.setSelected(true);
		highResolution = new JRadioButton("1280x800");
		highResolution.setFont(BigFontTR);
		resolutionBox.add(highResolution);
		resolutionBox.add(lowResolution);
		resolutionGroup.add(lowResolution);
		resolutionGroup.add(highResolution);
		//////////////////////LANGUAGE
		languageGroup = new ButtonGroup();
		languageBox = new Box(3);
		languageEnglish = new JRadioButton("English");
		languageEnglish.setFont(BigFontTR);
		languageEnglish.setSelected(true);
		languageRussian = new JRadioButton("Русский");
		languageRussian.setFont(BigFontTR);
		languageBox.add(languageEnglish);
		languageBox.add(languageRussian);
		languageGroup.add(languageEnglish);
		languageGroup.add(languageRussian);
		
		choosePanel.add(resolutionBox, BorderLayout.EAST);
		choosePanel.add(languageBox, BorderLayout.WEST);
		
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
			GUIMainMenu.setLanguage("English");
		} else {					
			GUIMainMenu.setLanguage("Russian");
		}
		System.out.println(GUIMainMenu.getLanguage()+" language is selected");
		
		if (lowResolution.isSelected()) {
			GUIMainMenu.setResolution(800, 600);			
		} else {
			GUIMainMenu.setResolution(1280, 800);
		}
		if (GUIMainMenu.getResolution()==2080) {
			System.out.println("1280x800 resolution is selected");
		} else {
			System.out.println("800x600 resolution is selected");
		}
		GUIMainMenu.initializeMainMenu();
		RALFrame.setVisible(false);
		
	}		
}
