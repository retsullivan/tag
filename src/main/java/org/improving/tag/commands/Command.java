package org.improving.tag.commands;

public interface Command {      //you can't put anything private in here

    boolean isValid(String input);
    void execute(String input);
}
