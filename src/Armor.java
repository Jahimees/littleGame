public class Armor extends Equipment {
	int armor;
	public BodyPart bodyPart;
	
	public void setArmor(int armor) {
		this.armor = armor;
	}	
	public int getArmor() {
		return armor;
	}
	
	public void setBodyPart(BodyPart bodyPart) {
		this.bodyPart = bodyPart;
	}
	
	public String getName() {
		return super.name;
	}
	
	//////////////CONSTRUCTOR
	Armor(String nam, int arm, BodyPart bp) {
		super.name = nam;
		armor = arm;
		bodyPart = bp;
	}
			
	@Override
	public void equip(Player player) {
		player.equipStatus.setAllArmor(this);
		player.equipStatus.setTotalArmor(armor); //
	}
			
}
	
		
	