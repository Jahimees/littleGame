
public class Equipment {
	String name;
	int armor;
	boolean equiped;
	
	class Breastplate extends Equipment {
		
	}
	
	class Helmet extends Equipment  {
		
	}
	
	class Leggins extends Equipment {
		
	}
	
	class Boots extends Equipment {
		String name;
		int armor;
		boolean equiped;
	}
	
	class Shield extends Equipment {
		String name;
		int armor;
		boolean equiped;
	}
	
	class Weapon extends Equipment {
		String name;
		int damage;
		boolean equiped;
	}
}
