package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component

public class MoveCommand implements Command{
  private InputOutput io;
  public MoveCommand (InputOutput io){
      this.io = io;
  }


    @Override
    public boolean isValid(String input) {
        if (input ==null) return false;
        input = input.trim();
        var parts = input.split(" ");
        if (parts.length == 1) return false;
        return parts[0].equalsIgnoreCase("move"); //this returns whether the first 4 letters are move
    }

    @Override
    public void execute(String input) {
        input = input.trim();
        var destination = input.substring(5).toLowerCase(); //automatically calculates how long the string is
        io.displayText("You proceed " + destination + ".");

    }
}
