package org.improving.tag.commands;


import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Arrays;

public abstract class BaseEmoteCommand extends BaseAliasedCommand{
    private String cmdResponse;
    private InputOutput io;

    // this. forces us to reference the field instead of the parameter.

    public BaseEmoteCommand(String cmdResponse, InputOutput io, String...aliases){
        super(aliases);
        this.cmdResponse = cmdResponse;
        this.io = io;
    }
@Override
    public void execute(String input, Game game){
        io.displayText(cmdResponse);
    }

}

