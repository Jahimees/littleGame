

public class InputPoint {

	public static void main(String[] args) {
		Player play = new Player();
		BodyPart hd = new BodyPart("breast");
		Equipment eq = new Armor("Жоцкая броня", 54, hd);
		eq.equip(play);
		play.eq.showEquipStatus();

	}

}
