package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class SetNameCommand implements Command{
    private InputOutput io;
    public SetNameCommand (InputOutput io){
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input ==null) return false;
        input = input.trim();
        if (!(input.contains("="))) return false;
        var parts = input.split("=");
        if (parts.length == 1) return false;
        return parts[0].equalsIgnoreCase("@set name"); //this returns whether the first 4 letters are move
    }

    @Override
    public void execute(String input, Game game) {
        input = input.trim();
        var newName = input.split("="); //splits at "="
        game.getPlayer().setName(newName[1].trim());
        io.displayText("Your name is now " + game.getPlayer().getName());
    }
}

