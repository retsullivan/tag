package org.improving.tag;
import org.improving.tag.Items.Item;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final List<Item> items = new ArrayList<>();


    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getInventoryDisplay() {
        String inventoryDisplay = "";
        for(Item item: items){
            //displayString = displayString + "/n" + item;
            inventoryDisplay += "\n"+ item;
        }
        return inventoryDisplay;
    }
}
