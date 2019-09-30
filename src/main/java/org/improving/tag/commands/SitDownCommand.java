package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class SitDownCommand extends BaseEmoteCommand {


    public SitDownCommand(InputOutput io) {

        super("You sit down.", io, "Sit", "Sit down", "sd");
    }

}