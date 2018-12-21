import java.util.ArrayList;
import java.util.HashSet;
public class Player {
	ArrayList inventory = new ArrayList();
	private int health;
	public EquipStatus equipStatus = new EquipStatus();
	
	/////////////////////////Methods///////////////////////////////		
	//openInventory
	
	
	////////////////////////GETTERS AND SETTERS////////////////////
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	
	////////////////////////////EQUIP STATUS CLASS/////////////////////
	public class EquipStatus{
		int damage;
		int totalArmor;
		ArrayList<Armor> allArmor = new ArrayList<Armor>();
		Weapon weapon;
		boolean head;
		boolean legs;
		boolean breast;
		boolean foots;
		
		
		
		////////////////////////GETTERS AND SETTERS////////////////////			
		public int getTotalArmor() {
			return totalArmor;
		}
		public void setTotalArmor(int totalArmor) {
			this.totalArmor += totalArmor;
		}		
		
		public int getDamage() {
			return damage;
		}
		public void setDamage(int damage) {
			this.damage = damage;
		}		
		
		public void getAllArmor() {
			System.out.println(allArmor); //for time wrong getter
		}
		
		public void setAllArmor(Armor equip) {
			switch (equip.bodyPart.getBodyPart()) { //need to do else parts (check for equipped items)
			case "head": if (!head) {allArmor.add(equip); head = true;} else {}
			case "legs": if (!legs) {allArmor.add(equip); legs = true;} else {}
			case "breast": if (!breast) {allArmor.add(equip); breast = true;} else {}
			case "foots": if (!foots) {allArmor.add(equip); foots = true;} else {}
			}			
		}
		
		public void setWeapon(Weapon weapon) {
			this.weapon = weapon;
		}
		
		public void getWeapon() {
			System.out.println(weapon.name); //for time wrong getter
		}
		
		public void getAllEquip() { //for time wrong getter
			System.out.println(allArmor);
			System.out.println(weapon.name);
		}
		
		public void showEquipStatus() {
			System.out.println("Armor:"+totalArmor);
			System.out.println("damage:"+damage);
			System.out.println((allArmor.get(0).name)); 
			System.out.println(weapon.name);
		}		
	}


}
