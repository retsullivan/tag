package org.improving.tag.commands;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class DanceCommand extends BaseEmoteCommand {
    private InputOutput io;

    public DanceCommand (InputOutput io) {
        super("You dance around like a chicken.", io, "Dance","D", "da", "dan", "danc");
        this.io=io;
    }
}

