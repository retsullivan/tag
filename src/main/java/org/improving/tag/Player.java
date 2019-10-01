package org.improving.tag;

import java.util.Map;

public class Player {
    private String name = "The Player";
    private int hitPoints = 100;
    private Location location;
    private Inventory inventory = new Inventory();

    //this constructor requires a location to make a player
    public Player(Location location) {
        this.location = location;
    }

    public Location getLocation() {return location;}
    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

//this is an example of encapsulation (setting it a private and then making public getters and setters)
    public int getHitPoints() {
        return hitPoints;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Inventory getInventory() {
       return inventory;
    }
}
