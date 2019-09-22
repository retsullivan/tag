package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class StandUpCommand extends BaseEmoteCommand{

        public StandUpCommand(InputOutput io) {

            super("stand", "You stand up.", io);
    }
}
