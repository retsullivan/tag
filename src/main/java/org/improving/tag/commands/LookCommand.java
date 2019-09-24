package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class LookCommand extends BaseAliasedCommand {
    private InputOutput io;

    public LookCommand(InputOutput io) {
        super("look", "whereami", "Where am I", "donde estoy", "l");
        this.io=io;
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

        io.displayText(location.getName());
        io.displayText(location.getDescription());
        io.displayText("");
        io.displayText("Exits:");

        for (var exit: location.getExits())
        {
            io.displayText("  " + exit.getName()); //display text automatically moves to next line
        }
    }
}