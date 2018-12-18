import java.util.ArrayList;
import java.util.HashSet;

public class Player {
	ArrayList inventory = new ArrayList();
	private int health;
	EquipStatus eq = new EquipStatus();
	
	
	////////////////////////GETTERS AND SETTERS////////////////////
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	class EquipStatus {
		Equipment bp = new Breastplate();
		Equipment helm = new Helmet();
		Equipment legg = new Leggins();
		Equipment boots = new Boots();
		Equipment shield = new Shield();
		Equipment weapon = new Weapon();
		
	}
	
	public class Equipment {		
		String name;		
		boolean equiped;		
	}
	
	class Breastplate extends Equipment {
		int armor;
	}
	
	class Helmet extends Equipment  {
		int armor;
	}
	
	class Leggins extends Equipment {
		int armor;
	}
	
	class Boots extends Equipment {
		int armor;
	}
	
	class Shield extends Equipment {
		int armor;
	}
	
	class Weapon extends Equipment {
		int damage;
	}


}
