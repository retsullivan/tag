package org.improving.tag;

import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;

    public class Location {

        private String name = "";
        private String description = "";
        private List<String> tags = new ArrayList<>();  //Creates an empty ArrayList<String>
        private List<Exit> exits = new ArrayList<>();
        private Adversary adversary = new Adversary();

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

        public Adversary getAdversary() {  return adversary; }

        public void setAdversary(Adversary adversary) { this.adversary = adversary; }

    }
