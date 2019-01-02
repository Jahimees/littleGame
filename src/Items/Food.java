package Items;

public class Food extends Item {

	private int countOfHealth;
	
	public void use() {
		///////need make + HP to Main Player
		this.drop();
	}

	public int getCountOfHealth() {
		return countOfHealth;
	}

	public void setCountOfHealth(int countOfHealth) {
		this.countOfHealth = countOfHealth;
	}
}
