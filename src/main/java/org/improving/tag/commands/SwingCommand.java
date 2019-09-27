package org.improving.tag.commands;
import org.improving.tag.Adversary;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;
import java.util.Random;

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

        } else {
            System.nanoTime();
            var criticalHit = new Random().nextInt(1_000_000_000) % 4;
            if (criticalHit == 1) {
                io.displayText("Critical Hit! You have defeated " + adversary.getName());
                game.getPlayer().getLocation().setAdversary(null);
            } else {
                int damageTaken = adversary.getDamageTaken();
                int playerAttackStrength = 5;
                adversary.setDamageTaken(damageTaken + playerAttackStrength);
                io.displayText("Nice swing! Adversary Hit Points are down to "
                        + (adversary.getHitPoints() - adversary.getDamageTaken()));
                io.displayText("That's a lot of damage!");
                if (adversary.getHitPoints() - adversary.getDamageTaken() <= 0) {
                    io.displayText(adversary.getName() + " has been defeated!");
                    game.getPlayer().getLocation().setAdversary(null);
                }
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