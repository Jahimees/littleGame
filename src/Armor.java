public class Armor extends Equipment {
	private int armor;
	BodyPart bodyPart;
	
	public void setArmor(int armor) {
		this.armor = armor;
	}	
	public int getArmor() {
		return armor;
	}
	
	public void setBodyPart(BodyPart bodyPart) {
		this.bodyPart = bodyPart;
	}
	
	public String getBodyPart() {
		return bodyPart.getBodyPart();
	}
	
	public String getName() {
		return super.name;
	}
	
	//////////////CONSTRUCTOR
	Armor(String nam, int arm, BodyPart bp) {
		super.name = nam;
		armor = arm;
		setBodyPart(bp);
	}
			
	@Override
	public void equip(Player player) {
		player.equipStatus.setAllArmor(this);
		//System.out.println(this.bodyPart.getBodyPart());
		//player.equipStatus.setTotalArmor(this.getArmor()); //
	}
			
}
	
		
	