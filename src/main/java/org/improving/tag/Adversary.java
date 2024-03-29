package org.improving.tag;

import org.improving.tag.Items.Item;
import org.improving.tag.Items.UniqueItems;

public class Adversary {

    private String name;
    private int hitPoints;
    private int damageTaken = 0;
    private int attackDamage;
    public Item item = UniqueItems.NOTHING;

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public Item getItem() { return item; }

    public void setItem(Item item) {this.item = item;  }











}
