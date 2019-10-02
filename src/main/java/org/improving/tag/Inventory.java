package org.improving.tag;
import org.improving.tag.Items.Item;
import org.improving.tag.Items.ItemComparator;
import org.improving.tag.Items.UniqueItems;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final List<Item> items = new ArrayList<>();

    public Inventory() {
        items.add(UniqueItems.UNFORGETTABLE_MUSHROOM);
        items.add(UniqueItems.EVERLASTING_GOBSTOPPER);
        items.add(UniqueItems.ROLL_OF_DUCT_TAPE);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getInventoryDisplay() {
        String inventoryDisplay = "";

        items.sort(new ItemComparator());

        for (Item item : items) {
            //displayString = displayString + "/n" + item;
            inventoryDisplay += "\n" + item;
        }
        return inventoryDisplay;
    }
}
    //implements Comparable<Inventory
    // @Override
    //public int compareTo(Inventory inventory) {
    //    return 0;
    //



