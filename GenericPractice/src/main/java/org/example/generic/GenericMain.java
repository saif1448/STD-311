package org.example.generic;

import java.util.*;

/**
 * This class demonstrates the use of a generic class `GameInventory` with different types of data.
 * It also includes an inner class `Weapon` to represent custom objects in the inventory.
 */
public class GenericMain {
    public static void main(String[] args) {
        // Create an inventory for coins (Integer type)
        GameInventory<Integer> coinInventory = new GameInventory<>("Coin Inventory");
        coinInventory.addInventoryItem(55); // Add coin value 55
        coinInventory.addInventoryItem(100); // Add coin value 100
        coinInventory.addInventoryItem(45); // Add coin value 45
        coinInventory.addInventoryItem(60); // Add coin value 60
        coinInventory.displayItems(); // Display all coin values

        // Create an inventory for spells (String type)
        GameInventory<String> spellInventory = new GameInventory<>("Spell Inventory");
        spellInventory.addInventoryItem("Healing Spell"); // Add a healing spell
        spellInventory.addInventoryItem("Immoratality Spell"); // Add an immortality spell
        spellInventory.addInventoryItem("Fire Spell"); // Add a fire spell
        spellInventory.addInventoryItem("Wind Spell"); // Add a wind spell
        spellInventory.displayItems(); // Display all spells

        // Create an inventory for weapons (custom `Weapon` type)
        GameInventory<Weapon> weaponInventory = new GameInventory<>("Weapon Inventory");
        weaponInventory.addInventoryItem(new Weapon("AK-47", "Common Used Heavy Gun")); // Add AK-47 weapon
        weaponInventory.addInventoryItem(new Weapon("UJI", "Most Used Short Hand Gun")); // Add UJI weapon
        weaponInventory.displayItems(); // Display all weapons
    }

    /**
     * Inner class to represent a weapon with a name and details.
     */
    private static class Weapon {
        private String weaponName; // Name of the weapon
        private String weaponDetails; // Details about the weapon

        /**
         * Constructor to initialize a weapon with its name and details.
         * 
         * @param weaponName    The name of the weapon.
         * @param weaponDetails The details of the weapon.
         */
        public Weapon(String weaponName, String weaponDetails) {
            this.weaponName = weaponName;
            this.weaponDetails = weaponDetails;
        }

        /**
         * Overrides the toString method to provide a string representation of the weapon.
         * 
         * @return A string combining the weapon name and details.
         */
        @Override
        public String toString() {
            return weaponName + " - " + weaponDetails;
        }
    }
}
