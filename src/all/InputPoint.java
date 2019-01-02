package all;

import Items.Armor;
import Items.BodyPart;
import Items.Equipment;
import Items.Weapon;

public class InputPoint {

	public static void main(String[] args) {
		Player play = new Player();
		play.equipStatus.showFullStatus();
		BodyPart legs = new BodyPart("legs");
		Equipment newLegs = new Armor("Штанишки", 5, legs);
		newLegs.equip(play);
		Equipment someSword = new Weapon("Меч какой-таааа", 10);
		someSword.equip(play);
		
		play.equipStatus.showFullStatus();
	}

}
