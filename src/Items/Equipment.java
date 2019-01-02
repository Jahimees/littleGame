package Items;

import all.Player;

public abstract class Equipment {		
	private String name;
	abstract public void equip(Player player);
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}