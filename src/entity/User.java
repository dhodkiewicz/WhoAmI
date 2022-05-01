package entity;

import java.awt.Point;

import item.Axe;
import item.Item;
import item.Longsword;
import item.Shortsword;

public class User<T> {

	private Point location;
	private String Name;
	private int currentRoom;
	private static Backpack backpack;
	private T equippedWeapon;
	
	public User() {
		
	}

	//getter for users location(Point <x,y>)
	public Point getLocation() {
		return location;
	}

	//setter for users location
	public void setLocation(Point location) {
		this.location = location;
	}

	//getter for current user's name
	public String getName() {
		return Name;
	}

	//setter for user's current name
	public void setName(String name) {
		Name = name;
	}

	//getter for users current room
	public int getCurrentRoom() {
		return currentRoom;
	}

	//setter for users current room
	public void setCurrentRoom(int currentRoom) {
		this.currentRoom = currentRoom;
	}

	public static Backpack getBackpack() {
		return backpack;
	}

	public static void setBackpack(Backpack backpack) {
		User.backpack = backpack;
	}

	public T getEquippedWeapon() {
		return this.equippedWeapon;
	}

	public void setEquippedWeapon(T equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}
	
	public double getWeaponStats() {
		
		if (this.equippedWeapon instanceof Axe) {
			Axe a = (Axe) this.equippedWeapon;
			return a.getAttack();
		}
		if (this.equippedWeapon instanceof Shortsword) {
			Shortsword sw = (Shortsword) this.equippedWeapon;
			return sw.getAttack();
		}
		if (this.equippedWeapon instanceof Longsword) {
			Longsword sw = (Longsword) this.equippedWeapon;
			return sw.getAttack();
		}
		
		return 0.0;
	}

}
