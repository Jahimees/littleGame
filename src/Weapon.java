
public class Weapon extends Equipment { 
	private int damage;
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	// look Armor class
	@Override
	public void equip(Player player) {
		player.equipStatus.setWeapon(this);
		player.equipStatus.setDamage(damage); //
	}
	
	//////////////CONSTRUCTOR
	Weapon(String nam, int dmg) {
			super.name = nam;
			damage = dmg;
	}
	
}