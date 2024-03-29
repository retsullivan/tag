package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class LookCommand extends BaseAliasedCommand {


    public LookCommand(InputOutput io) {
        super(io,"look", "whereami", "Where am I", "donde estoy", "l");

        //super("look", "You Look Around", io);
    }

    @Override
    public boolean isValid(String input, Game game) {



        return input.trim().equalsIgnoreCase("look") ||
                input.trim().equalsIgnoreCase("whereami") ||
                input.trim().equalsIgnoreCase("Where am I") ||
                input.trim().equalsIgnoreCase("?donde estoy?");
    }

    @Override
    public void execute(String input, Game game) {
        var location = game.getPlayer().getLocation();

        io.displayText("You are at " + location.getName());
        io.displayText(location.getDescription());
        if(location.getTreasureDescription() != "") {
            io.displayText("You see a " + location.getTreasure() + " in the corner.");
        }
        io.displayNewLine();
        io.displayText("Exits:");


        for (var exit: location.getExits())
        {
            io.displayText("  " + exit.getName()); //display text automatically moves to next line
        }
    }


}