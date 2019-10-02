package org.improving.tag.Items;




public enum UniqueItems implements Item{
//this is secretly a hashmap
// the UniqueItems are keys, the descriptions are values

    THE_ONE_RING("One Ring", "a truly precious item.  You wants it."),
    BLUE_SHELL("Blue Shell", "a mighty offensive weapon. Use it to knock out the leader."),
    HORCRUX("Horcrux", "an evil talisman containing a portion of a sinister soul."),
    EGGO_WAFFLE("EGGO Waffle", "part of a balanced breakfast and rumored to boost psychic abilities"),
    JELLOED_STAPLER("Stapler Encased in Jello", "an iconic prank"),
    GIANT_POKING_DEVICE("Giant Poking Device", "long enough to stretch across a New York City street"),
    SONIC_SCREWDRIVER("Sonic Screwdriver", "used for wibbly wobbly, timey wimey...stuff"),
    FLAMETHROWER("Flamethrower", "used for attacking mustachioed Italian plumbers"),
    RIDDLES_IN_THE_DARK("Riddle in the dark", "string or nothing"),
    UNFORGETTABLE_MUSHROOM("Unforgettable Mushroom", "an edible toadstool that will make you larger"),
    EVERLASTING_GOBSTOPPER("Everlasting Gobstopper", "a never-ending morsel that tastes like pure imagination"),
    ROLL_OF_DUCT_TAPE("Roll of Duct Tape", "used for fixing anything and everything"),

    NOTHING("", ""){
        //@Override
       // public String getDescription(){
        //    throw new UnsupportedOperationException();
       // }
    };

    private final String description;
    private final String name;

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
        return name + ": " + description;
    }

//    @Override
//    public int compareTo(UniqueItems other){
//
//    }

}
