package org.improving.tag;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start of Main");
        Game game = new Game ();                      //new is the keyword that invokes the constructor(s) of game
        System.out.println("Declared Game");

        game.run();
        System.out.println("After Run");
        long elapsedTicks = game.getEndTime().getTime()-
                game.getStartTime().getTime();
           double elapsedSeconds = elapsedTicks/1000.00;
           System.out.println("We were running for +" + elapsedSeconds + "s");

    }

}
