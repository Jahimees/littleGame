package all;

import javax.swing.*;

import GUI.GUIMainMenu;
import GUI.ResolutionAndLanguageFrame;
import Items.Armor;
import Items.BodyPart;
import Items.Equipment;
import Items.Weapon;

public class InputPoint {

	
	
	public static void main(String[] args) {
		Player play = new Player();
		play.equipStatus.showFullStatus();
		BodyPart legs = new BodyPart("legs");
		Equipment newLegs = new Armor("��������", 5, legs);
		newLegs.equip(play);
		Equipment someSword = new Weapon("��� �����-�����", 10);
		someSword.equip(play);

		
		
		play.equipStatus.showFullStatus();
		
		//////////////////////////////////
		ResolutionAndLanguageFrame f = new ResolutionAndLanguageFrame();
		
		
	}

}
