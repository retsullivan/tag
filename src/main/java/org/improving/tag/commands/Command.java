package org.improving.tag.commands;
import org.improving.tag.Game;

public interface Command {      //you can't put anything private in here

    //needs the input and also passes in the an instance of our game class
    boolean isValid(String input, Game game);
    void execute(String input, Game game);
}
