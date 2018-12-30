

public class InputPoint {

	public static void main(String[] args) {
		Player play = new Player();
		play.equipStatus.showFullStatus();
		BodyPart legs = new BodyPart("legs");
		Equipment newLegs = new Armor("Штанишки", 5, legs);
		newLegs.equip(play);
		
		play.equipStatus.showFullStatus();
	}

}
