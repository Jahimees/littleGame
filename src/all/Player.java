package all;
import java.util.ArrayList;
import java.util.HashSet;

import GUI.GUIInventory;
import Items.Armor;
import Items.BodyPart;
import Items.Equipment;
import Items.Weapon;
public class Player {
	GUIInventory inventory = new GUIInventory();
	private int health;
	private int maxHealth;	
	public Status equipStatus = new Status();
	
	/////////////////////////Constructors//////////////////////////
	public Player() {
		setHealth(100);
		setMaxHealth(100);
		equipStatus.setDamage(3);		
	
		BodyPart legs = new BodyPart("legs");
		Armor legsArmor = new Armor("Обмотки на ноги", 1, legs);
		legsArmor.equip(this);
		
		BodyPart breast = new BodyPart("breast");
		Equipment breastArmor = new Armor("Обмотки", 0, breast);
		breastArmor.equip(this);
		inventory.initiateInventory();
	}
	
	/////////////////////////Methods///////////////////////////////	
	//use item?????
	//////wtf
	public void openInventory() { ///////////NEED GUI
		
	}
	
	////////////////////////GETTERS AND SETTERS////////////////////
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}	
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	////////////////////////////EQUIP STATUS CLASS/////////////////////
	public class Status{
		private int damage;
		private int totalArmor;
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
			switch (equip.getBodyPart()) { //need to do else parts (check for equipped items)
			case "head": if (!head) {
				allArmor.add(equip);
				head = true;
				equipStatus.setTotalArmor(equip.getArmor());
				break;
				} else {
					changeArmor("head", equip);				
					break;
				}
			
			case "legs": if (legs==false) {
				allArmor.add(equip);
				legs = true;
				equipStatus.setTotalArmor(equip.getArmor());
				break;
				} else {
					changeArmor("legs", equip);
					break;
					}
			
			
			case "breast": if (!breast) {
				allArmor.add(equip);
				breast = true;
				equipStatus.setTotalArmor(equip.getArmor());
				break;
				} else {
					changeArmor("breast", equip);
					break;
				}
			case "foots": if (!foots) {
				allArmor.add(equip);
				foots = true;
				equipStatus.setTotalArmor(equip.getArmor());
				break;
				} else {
					changeArmor("foots", equip);
					break;
				}
			}			
		}
		
		public void setWeapon(Weapon weapon) {
			this.weapon = weapon;
		}
		
		public void getWeapon() {
			System.out.println(weapon.getName()); //for time wrong getter
		}
		
		public void getAllEquip() { //for time wrong getter
			System.out.println(allArmor);
			System.out.println(weapon.getName());
		}
		
		
		///////////////////////////////////////SHOW ALL STATS
		////////////NEED GUI + CONNECT WITH INVENTORY
		public void showFullStatus() {
			System.out.println();
			System.out.println("~~~~~Статус:~~~~~");
			System.out.println("Armor:"+totalArmor);
			System.out.println("damage:"+ damage);	
			System.out.println("~~~~~Экипировка:~~~~~");
			for	(int i=0; i<allArmor.size(); i++) {	
				System.out.println((allArmor.get(i).getName())+" ("+(allArmor.get(i).getBodyPart())+")"+" armor: "+allArmor.get(i).getArmor());
			}
			
			if (weapon!=null) {
				System.out.println(weapon.getName()+" damage: "+getDamage());
			}
			System.out.print("Здоровье: "+getHealth());
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~");
			System.out.println();
			
		}
		
		
		//////////////////////////////////////REMOVE ARMOR
		public void changeArmor(String type, Armor equip) {
			for (int i=0; i<allArmor.size(); i++) {
				if (allArmor.get(i).getBodyPart()==type) {
					equipStatus.setTotalArmor(-(allArmor.get(i).getArmor()));
					allArmor.remove(i);
					}
				}
			allArmor.add(equip);
			System.out.println("Переодеваюсь!");
			equipStatus.setTotalArmor(equip.getArmor());
		}
		
		
	}


}
