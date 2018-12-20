
		public class Weapon extends Equipment { 
			int damage1;
			
			@Override
			public void equip(Player player) {
				player.eq.setAllEquip(this);
				player.eq.setDamage(damage1); //
			}
		}