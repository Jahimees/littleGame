package GUI;
import javax.swing.*;

import Items.Equipment;
import Items.Food;
import all.Player;

public class GUIInventory {
	JFrame inventoryFrame = new JFrame();
	JButton button = new JButton("click me");
	JPanel inventoryPanel = new JPanel();
	private Food[] foodInventory = new Food[5];
	private Equipment[] equipmentInventory = new Equipment[10];
	

	
	public void use(Food food) {
		//
	}
	
	////////WTF?????????
	public void equip(Equipment equipment, Player player) {
		equipment.equip(player);
	}
	
	
	public Food[] getFoodInventory() {
		return foodInventory;
	}
	public void setFoodInventory(Food[] foodInventory) {
		this.foodInventory = foodInventory;
	}
	public Equipment[] getEquipmentInventory() {
		return equipmentInventory;
	}
	public void setEquipmentInventory(Equipment[] equipmentInventory) {
		this.equipmentInventory = equipmentInventory;
	} 
	
	
	public void initiateInventory() {
		inventoryFrame.setSize(300, 300);
		inventoryFrame.getContentPane().add(button);
		inventoryFrame.setVisible(true);
		inventoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
