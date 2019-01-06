package GUI;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Items.Equipment;
import Items.Food;
import all.Player;

public class GUIInventory {
	JFrame inventoryFrame;
	JPanel inventoryPanel;	
	Image inventoryImage;
	

	
	public void initiateInventory() {
		inventoryFrame = new JFrame();
		inventoryFrame.setTitle("My Panel");
		inventoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		inventoryPanel = new ImagePanel();
		try {
			((ImagePanel) inventoryPanel).setImage(ImageIO.read(new File("src\\images\\inventoryRUS.jpg")));
			} catch (IOException e) {
				e.printStackTrace();
				}		
		inventoryPanel.setSize(300, 400);		
		inventoryFrame.add(inventoryPanel, BorderLayout.CENTER);
		inventoryFrame.setSize(800, 600);
		inventoryFrame.setResizable(false);
		inventoryFrame.setVisible(false);
		
	}
}
