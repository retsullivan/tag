package org.improving.tag;

import org.improving.tag.Items.Item;

import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;

    public class Location {

        private String name = "";
        private String description = "";
        private List<String> tags = new ArrayList<>();  //Creates an empty ArrayList<String>
        private List<Exit> exits = new ArrayList<>();
        private Adversary adversary;     //private Adversary adversary = null;
        private TreasureChest treasure = TreasureChest.NO_TREASURE; //uses the empty chest we created


        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getTags() {
            return tags;
        }

        public List<Exit> getExits() {
            return exits;
        }

        public Adversary getAdversary() {return adversary; }
        public void setAdversary(Adversary adversary) {
                    this.adversary = adversary;
                }

        public TreasureChest getTreasure() {return treasure; }

        public void setTreasure(TreasureChest treasure) { this.treasure = treasure;}

        public String getTreasureDescription() {
                return treasure.getDescription();
        }

        public Item openTreasure(){
            if(TreasureChest.NO_TREASURE.equals(treasure)){
                throw new UnsupportedOperationException();
            }
            Item treasureItem = treasure.getItem();
            //making the treasure go away after opening treasure box
            treasure = treasure.NO_TREASURE;
            return treasureItem;


        }
    }
