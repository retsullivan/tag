package org.improving.tag;

import org.improving.tag.commands.*;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.Scanner;

@Component
public class Game {
    private Date startTime;
    private Date endTime;
    private Command[] commands;
    private InputOutput io;
    private Player p;
    private Location startingLocation;

    public Game(Command[] commands, InputOutput io) {
        startingLocation = buildWorld();
        this.commands = commands;
        this.io = io;
        this.p = new Player(startingLocation);              //need to provide a location here
    }

    public Location getStartingLocation() {
        return startingLocation;
    }

    public Player getPlayer() {
        return p;
    }

    public Date getStartTime() {
        return startTime;
    }

    private void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    private void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void run() {
        this.setStartTime(new Date());
        boolean loop = true;

        while (loop) {
            io.displayPrompt("> ");
            String input = io.receiveInput();
            Command validCommand = getValidCommand(input);

            if (null != validCommand) {
                validCommand.execute(input, this);  //don't type "game: "
            } else if (input.equalsIgnoreCase("exit")) {
                io.displayText("Goodbye.");
                loop = false;
            } else
                io.displayText("Huh? I don't understand.");
        }
        this.setEndTime(new Date());
    }


    private Command getValidCommand(String input) {
        Command validCommand = null;

        for (Command command : commands) {
            if (command.isValid(input, this)) {
                validCommand = command;
            }
        }
        return validCommand;
    }

    private Location buildWorld() {     //this is creating descriptions for each location in the world
        var tdh = new Location();
        tdh.setName("The Deathly Hallows");

        var td = new Location();
        td.setName("The Dessert");

        var ta = new Location();
        ta.setName("The Amazon");

        var tmcs = new Location();
        tmcs.setName("The Mac and Cheese Shop");

        var tr = new Location();
        tr.setName("The Reef");

        var tm = new Location();
        tm.setName("The Mall");

        var tvh = new Location();
        tvh.setName("The Velvet Moose");

        var md = new Location();
        md.setName("Mount Doom");

        var tvd = new Location();
        tvd.setName("The Volcano of Death");

        var tap = new Location();
        tap.setName("The Airport");

        var aict = new Location();
        aict.setName("An Ice Cream Truck");

        var tms = new Location();
        tms.setName("The Mountains");


        //initializing all the exits
        tdh.getExits().add(new Exit("Heaven Avenue" ,tmcs, "h", "ave","heaven", "ha"));
        tdh.getExits().add(new Exit("The Deathly Brownie", td, "tdb", "deathly", "brownie", "db"));

        td.getExits().add(new Exit("Camel Path", ta, "cp", "c", "camel", "path"));

        tmcs.getExits().add(new Exit("Highway 121", ta, "121", "hwy", "hwy 121", "h121"));




        return tdh;

    }

}

