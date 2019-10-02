package org.improving.tag.commands;
import org.improving.tag.Adversary;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.Items.Item;
import org.springframework.stereotype.Component;
import java.util.Random;

import static org.improving.tag.Items.UniqueItems.NOTHING;

@Component
public class SwingCommand implements Command {

    private InputOutput io;

    public SwingCommand(InputOutput io) {
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        return input.trim().equalsIgnoreCase("swing");
    }

    @Override

    public void execute(String input, Game game) {
        var adversary = game.getPlayer().getLocation().getAdversary();
        if (adversary == null) {
            io.displayText("You swing at the air for some reason.");

        } else { //adversary present
            System.nanoTime();
            var criticalHit = new Random().nextInt(1_000_000_000) % 4;
            if (criticalHit == 1) {
                io.displayText("Critical Hit! You have defeated " + adversary.getName());
                Item item = game.getPlayer().getLocation().getAdversary().getItem();
                if (item != NOTHING) {
                    io.displayText("You have looted " + item + ".");
                    io.displayText(item.getDescription() + " added to your inventory.");
                    game.getPlayer().getInventory().addItem(item);
                }
                game.getPlayer().getLocation().setAdversary(null);
            } else {
                var success = new Random().nextInt(1_000_000_000) % 3;
                if (success == 1) {
                    int damageTaken = adversary.getDamageTaken();
                    int playerAttackStrength = 5;
                    adversary.setDamageTaken(damageTaken + playerAttackStrength);
                    io.displayText("Nice swing! Adversary Hit Points are down to "
                            + (adversary.getHitPoints() - adversary.getDamageTaken()));
                    io.displayText("That's a lot of damage!");
                }
                else {
                     io.displayText("Swing and a miss! " + adversary.getName() + " evaded your attack ");
                }
                }

                if (adversary.getHitPoints() - adversary.getDamageTaken() <= 0) {
                    io.displayText(adversary.getName() + " has been defeated!");

                    Item item = game.getPlayer().getLocation().getAdversary().getItem();
                    if (item != NOTHING) {
                        io.displayText("You have looted " + item + ".");
                        io.displayText(item.getDescription() + " added to your inventory.");
                        game.getPlayer().getInventory().addItem(item);
                    }

                    game.getPlayer().getLocation().setAdversary(null);
                }
            }
        }
    }




//        } else {
//            //randomly generate a number
//            System.nanoTime();
//            var rand = new Random().nextInt(100);
//            int damageTaken = adversary.getDamageTaken();
//            int playerAttackStrength = 10;
//
//            if (rand < 20) {
//                adversary.setDamageTaken(damageTaken + playerAttackStrength);
//                io.displayText("Adversary Hit Points are down to "
//                        + (adversary.getHitPoints() - adversary.getDamageTaken()));
//                io.displayText("That's a lot of damage!");
//                if (adversary.getHitPoints() - adversary.getDamageTaken() <= 0 ){
//                    io.displayText(adversary.getName() + " has been defeated!");
//                    game.getPlayer().getLocation().setAdversary(null);
//                }
//            }
//            else io.displayText("Attacked failed - You have no power here!");
//        }
//    }
//}