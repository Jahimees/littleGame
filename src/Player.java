import java.util.ArrayList;
import java.util.HashSet;

public class Player {
	ArrayList inventory = new ArrayList();
	private int health;
	Equipment equip = new Equipment();
	
	
	////////////////////////GETTERS AND SETTERS////////////////////
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	

}
