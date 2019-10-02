package org.improving.tag.commands;

import org.improving.tag.Game;

import org.improving.tag.InputOutput;

import org.improving.tag.Items.Item;
import org.springframework.stereotype.Component;

@Component
public class OpenCommand extends BaseAliasedCommand{

    public OpenCommand (InputOutput io){
        super(io, "Open", "O", "OP", "OPE");
    }

    @Override
    public void childExecute(String input, Game game) {
        Item item = game.getPlayer().getLocation().openTreasure();
        io.displayText("You have found a " + item + ".");

        game.getPlayer().getInventory().addItem(item);
        /* if(game.getPlayer().getLocation().getTreasure().getDescription() == ""){
            io.displayText("You see no treasure.");
        }
        else{
            io.displayText("You open the " + game.getPlayer().getLocation().getTreasure().getDescription() + " .");
            io.displayText("You have found a " + game.getPlayer().getLocation().getTreasure().getItem() + ".");
            io.displayText("It is " + game.getPlayer().getLocation().getTreasure().getItem().getDescription() + ".");
        }
        */


        //eventually add this item to inventory





    }

}
