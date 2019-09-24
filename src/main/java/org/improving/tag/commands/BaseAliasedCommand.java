package org.improving.tag.commands;
import org.improving.tag.Game;
import org.improving.tag.commands.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Array;
import java.util.Optional;

public abstract class BaseAliasedCommand<BasedAliasedCommand> implements Command {

    private List<String> aliases = new ArrayList<>();

    public BaseAliasedCommand(String...aliases){
        this.aliases.addAll(Arrays.asList(aliases));
    }

    @Override
    public boolean isValid(String input, Game game){
        var trimmedInput = input.trim();
        return aliases.stream().anyMatch(trimmedInput::equalsIgnoreCase);
    }
}
        //.filter(input::equalsIgnoreCase).findFirst().isPresent() was replaced with anyMatch()
        //stream handles data once piece at a time
        //call equals, ignore case for each entry in the list
        //think of it as a conveyer belt, wrong answers get thrown away
        //only care about the first one we say yes (will stop looking after one is found)
        //will result in either 1 or 0 aliases being found
        // the : : syntax means we're handing filter a pointer to the method, not an invocation


