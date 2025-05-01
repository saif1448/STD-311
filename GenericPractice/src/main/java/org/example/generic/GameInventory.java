package org.example.generic;

import java.util.*;

/**
 * A generic class representing a game inventory.
 * This class allows storing and managing a list of items of any type.
 *
 * @param <T> The type of items that the inventory will hold.
 */
public class GameInventory<T> {

    // A list to store inventory items of type T.
    private List<T> inventoryItemList = new ArrayList<>();

    // The name of the inventory.
    private String inventoryName;

    /**
     * Constructor to initialize the inventory with a name.
     *
     * @param inventoryName The name of the inventory.
     */
    public GameInventory(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    /**
     * Adds an item to the inventory.
     *
     * @param item The item to be added to the inventory.
     */
    public void addInventoryItem(T item) {
        inventoryItemList.add(item);
    }

    /**
     * Displays all items in the inventory along with their index.
     * Prints the inventory name and each item in the list.
     */
    public void displayItems() {
        System.out.println("Printing Inventory Items for " + inventoryName);
        int count = 1;
        for (var item : inventoryItemList) {
            System.out.println(count + ". " + item);
            count++;
        }
    }
}
