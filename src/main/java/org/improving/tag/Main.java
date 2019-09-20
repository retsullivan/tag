package org.improving.tag;
import org.improving.tag.commands.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringContext.class);

        Game game = context.getBean(Game.class); //hands off the Game Class cookie cutter to __?
        game.run();

        long elapsedTicks = game.getEndTime().getTime()-
                game.getStartTime().getTime();
           double elapsedSeconds = elapsedTicks/1000.00;
           System.out.println("We were running for +" + elapsedSeconds + "s");

    }

}
