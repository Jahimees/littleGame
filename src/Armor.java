public class Armor extends Equipment {
	int armor;
	BodyPart bodyPart;
	
	public void setArmor(int armor1) {
		armor = armor1;
	}	
	public int getArmor() {
		return armor;
	}
	
	public void setBodyPart(BodyPart bodyPart1) {
		bodyPart = bodyPart1;
	}
	
	public String getName() {
		return super.name;
	}
	
	Armor(String nam, int arm, BodyPart bp) {
		super.name = name;
		armor = arm;
		bodyPart = bp;
	}
			
	@Override
	public void equip(Player player) {
		player.eq.setAllEquip(this);
		player.eq.setTotalArmor(armor); //
	}
			
}
	
		
	