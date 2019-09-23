package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class LickCommand implements Command {
    private InputOutput io;

    public LickCommand(InputOutput io) {
        this.io = io;
    }


    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        input = input.trim();
        var parts = input.split(" ");
        if (parts.length == 1) return false;
        return parts[0].equalsIgnoreCase("lick"); //this returns whether the first 4 letters are lick
    }

    @Override
    public void execute(String input, Game game) {
        input = input.trim();
        var lickVictim = input.substring(5).toLowerCase(); //automatically calculates how long the string is
        io.displayText("You lick " + lickVictim + ". Gross.");

    }
}
