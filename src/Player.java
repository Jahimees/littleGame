import java.util.ArrayList;
import java.util.HashSet;



public class Player {
	ArrayList inventory = new ArrayList();
	private int health;
	public EquipStatus eq = new EquipStatus();
	
	/////////////////////////Methods///////////////////////////////		
	
	
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
		ArrayList<Equipment> allEquip = new ArrayList<Equipment>();
		
		
		////////////////////////GETTERS AND SETTERS////////////////////			
		public int getTotalArmor() {
			return totalArmor;
		}
		public void setTotalArmor(int totalArmor1) {
			this.totalArmor += totalArmor1;
		}		
		
		public int getDamage() {
			return damage;
		}
		public void setDamage(int damage1) {
			this.damage = damage1;
		}
		
		public void getAllEquip() {
			System.out.println(allEquip);
		}
		
		public void setAllEquip(Equipment equip) {
			allEquip.add(equip); //add equip to ArrayList
		}
		
		public void showEquipStatus() {
			System.out.println("Armor:"+totalArmor);
			System.out.println("damage:"+damage);
			System.out.println((allEquip.get(0).name)); //doesn't work, cause it use Equipment and not Weapon or Armor
		}		
	}


}
