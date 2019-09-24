/*package org.improving.tag;
import java.util.ArrayList;
import java.util.HashMap;

public class InventoryTracker {

    // HashMap with arrayLists of items by ID.
    public static HashMap<Integer, ArrayList<String>> items = new HashMap<Integer, ArrayList<String>>();
    // Backpack with a slightly different structure.
    public static HashMap<Integer, String> backpack = new HashMap<Integer, String>();

    public static void main(String[] args) {

        // Creating the arrayLists.
        ArrayList<String> books = new ArrayList<String>();
        ArrayList<String> weapons = new ArrayList<String>();
        ArrayList<String> food = new ArrayList<String>();
        ArrayList<String> medicine = new ArrayList<String>();
        ArrayList<String> puppies = new ArrayList<String>();

        // Adding content to them...
        for (int i = 0; i < 10; i++) {
            books.add("Books.toString());
                    weapons.add("Weapons.toString());
                            food.add("Food.toString());
                                    medicine.add("Medicine.toString());
                                            puppies.add("Puppies.toString());
        }

        // Putting the arrayLists to the HashMap of items by their IDs.
        items.put(ID.books, books); items.put(ID.weapons, weapons);
        items.put(ID.food, food); items.put(ID.medicine, medicine);
        items.put(ID.puppies, puppies);

        // Printing all the content in all arrayLists in all IDs.
        for (ArrayList<String> e : items.values()) {
            for (int i = 0; i < e.size(); i++) {
                if (e.get(i)!=null) {
                    System.out.println(e.get(i));
                }
            }
        }

        // Here you could add any item to the backpack.
        backpack.put(ID.books, books.get(0));
        backpack.put(ID.weapons, weapons.get(1));
        backpack.put(ID.food, food.get(2));
        backpack.put(ID.medicine, medicine.get(3));
        backpack.put(ID.puppies, puppies.get(4));
    }

    public class ID {

        //Defining constant-IDs.
        public static final int books = 0;
        public static final int weapons = 1;
        public static final int food = 2;
        public static final int medicine = 3;
        public static final int puppies = 4;

    }

}*/


