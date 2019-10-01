package org.improving.tag.Items;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


public enum UniqueItems implements Item{
//this is secretly a hashmap
// the UniqueItems are keys, the descriptions are values

    THE_ONE_RING("the one ring", "a truly precious item.  You wants it."),
    BLUE_SHELL("a blue shell", "a mighty offensive weapon. Use it to knock out the leader."),
    HORCRUX("a horcrux", "an evil talisman containing a portion of a sinister soul."),
    EGGO_WAFFLE("an Eggo waffle", "part of a balanced breakfast and rumored to boost psychic abilities"),
    NOTHING("", ""){
        //@Override
       // public String getDescription(){
        //    throw new UnsupportedOperationException();
       // }
    };

    private String description;
    private String name;

    UniqueItems(String name, String description){
        this.name = name;
       this.description = description;
    }
   @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}
