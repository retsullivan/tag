package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component //this tells Spring that it should register this as a command when it scans our library

public class DemoCommand implements Command{  //YOU NEED TO IMPLEMENT COMMAND :-p
    //Best practices this should be "private final InputOutput io;" so it cannot be modified
    //finals are fixed after the constructor is completed
    //Finals are only assigned once

    private final InputOutput io; //this get initialised inside the constructor
    private int ingCount = 0;

    public DemoCommand(InputOutput io){
        this.io = io;       //this is allowable because it's inside the constructor
    }

    @Override
    public boolean isValid(String input, Game game){
        return input.trim().endsWith("ing");
    }

    @Override
    public void execute (String input, Game game){
        ingCount = ingCount + 1;
        io.displayText("We have 'ing'ed " +ingCount + " times");
    }

}
