package org.improving.tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exit {
    private String name;
    private Location destination;
    private List<String> aliases = new ArrayList<>();

//tdh.getExits().add(new Exit("Heaven Avenue"),tmcs, "h", "ave","heaven", "ha");

    public Exit() {
    }

    public Exit(String name, Location destination, String... aliases) {
        this.name = name;
        this.destination = destination;
        this.aliases.addAll(Arrays.asList(aliases));
    }

    //public Exit(String heaven_avenue) {
    //}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public String toString() {      //overriding Object's regular "ToString"
        return this.getName();
    }


//    @Override
//    public int hashCode(){
//        int hash = 7;
//
//        hash = 31*hash + (this.getName() == null ? 0:getName().hashCode());
//        hash = 31*hash + (this.getdestination() == null ? 0:getdestination().hashCode());
//
//        this is to help keep keys differentiable from each other when they're stored in a hashtable
//        You should still be able to pull a specific object even if it is considered "equal" objects"
//    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Exit) {
            Exit exit = (Exit) obj;
            return this.getName().equals(exit.getName()) && this.getDestination().equals(exit.getDestination());
        } else return super.equals(obj); //equals shouldn't throw, so we revert to Object class definition
    }

}
