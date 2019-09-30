package org.improving.tag.commands;
import org.improving.tag.Game;
import org.improving.tag.GameExitException;
import org.improving.tag.InputOutput;
import org.improving.tag.commands.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class BaseAliasedCommand<BasedAliasedCommand> implements Command {
    private final InputOutput io;
    private List<String> aliases = new ArrayList<>();

    public BaseAliasedCommand(InputOutput io, String...aliases){
        this.io = io;
        this.aliases.addAll(Arrays.asList(aliases));
    }

    @Override
    public boolean isValid(String input, Game game){
        var trimmedInput = getCommandPart(input).trim();
        return aliases.stream().anyMatch(trimmedInput::equalsIgnoreCase);
    }

    public void childExecute(String input, Game game) throws GameExitException {}

    public String getErrorMessage(){
        return "Huh? I don't understand";
    }

    @Override
    public void execute(String input, Game game) throws GameExitException{
        //letting the child class handle the command
        try{  childExecute(input, game);
        } catch (UnsupportedOperationException ex)
        //if input was invalid, do this - it's a runtime exception
        { io.displayText(getErrorMessage());
        }

    }


    public String getCommandPart(String input){
        //if (input ==null) return null;
       // if
        return input;

        // if (input ==null) return false;
        // input = input.trim();
        // var parts = input.split(" ");
        // if (parts.length == 1) return false;
        // return parts[0].equalsIgnoreCase("move");


    }
}


