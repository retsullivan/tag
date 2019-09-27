package org.improving.tag.commands;
import org.improving.tag.Adversary;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AttackCommand implements Command {

    private InputOutput io;

    public AttackCommand(InputOutput io) {
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        return input.trim().equalsIgnoreCase("attack");
    }

    @Override
    public void execute(String input, Game game) {
        var adversary = game.getPlayer().getLocation().getAdversary();
        if (adversary == null) {
            io.displayText("Attack what?");
        } else {
            //randomly generate a number
            System.nanoTime();
            var rand = new Random().nextInt(100);
            int damageTaken = adversary.getDamageTaken();
            int playerAttackStrength = 10;

            if (rand < 20) {
                adversary.setDamageTaken(damageTaken + playerAttackStrength);
                io.displayText("Adversary Hit Points are down to "
                        + (adversary.getHitPoints() - adversary.getDamageTaken()));
                io.displayText("That's a lot of damage!");
                if (adversary.getHitPoints() - adversary.getDamageTaken() <= 0 ){
                    io.displayText(adversary.getName() + " has been defeated!");
                    game.getPlayer().getLocation().setAdversary(null);
                }
            }
            else io.displayText("Attacked failed - You have no power here!");
        }
    }
}
        // need to account for killing the adversary eventually
        // While adversary hit points >0…
        // don’t have to do that yet




