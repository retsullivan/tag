package org.improving.tag.commands;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;

public class AttackCommand implements Command {

    private InputOutput io;


    public AttackCommand(InputOutput io){
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game){
        return input.trim().equalsIgnoreCase("attack");
    }

    @Override
    public void execute(String input, Game game){


    }

    }

}
