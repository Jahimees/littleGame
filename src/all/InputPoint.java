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
					MainWindow window = new MainWindow();
					window.frame.setVisible(false);
					} catch (Exception e) {
						e.printStackTrace();
						}
				}
		});
		
	}

}
