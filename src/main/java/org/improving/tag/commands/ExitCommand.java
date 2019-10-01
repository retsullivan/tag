package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.GameExitException;
import org.improving.tag.InputOutput;
import org.improving.tag.SaveGameFactory;
import org.springframework.stereotype.Component;

    @Component //lets spring find the class
    public class ExitCommand extends BaseAliasedCommand {

        private final SaveGameFactory saveFactory;
        //making these final *forces* you to initialize it

        public ExitCommand(SaveGameFactory saveFactory, InputOutput io) {
            //spring looks for a constructor and supplies all the components it can find for the parameters
            super(io, "exit", "E", "X", "ex", "exi"); //this io comes from BaseAliasedCommand
            this.saveFactory = saveFactory;  //letting Spring initialize the saveFactory
        }
        @Override
        public void childExecute(String input, Game game) throws GameExitException {
            io.displayText("Goodbye");
            saveFactory.save(game);
            throw new GameExitException();
        }
}


