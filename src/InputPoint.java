

public class InputPoint {

	public static void main(String[] args) {
		Player play = new Player();
		BodyPart breast = new BodyPart("breast");
		Equipment equipka = new Armor("Iron Breast", 54, breast);
		Equipment someSword = new Weapon("Iron Sword", 10);
		someSword.equip(play);
		equipka.equip(play);
		play.equipStatus.showEquipStatus();
	}

}
