package all;

import java.awt.EventQueue;

import javax.swing.*;

import GUI.LanguageFrame;
import GUI.MainWindow;
import Items.Armor;
import Items.BodyPart;
import Items.Equipment;
import Items.Weapon;

public class InputPoint {

	public MainWindow mainWindow;
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
		
		//////////////////////////////////
		
		MainWindow.setLanguage("English");
		System.out.println(MainWindow.getLanguage()+" language is selected");
		
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
