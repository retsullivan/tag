package org.improving.tag;

import org.improving.tag.commands.*;

import java.util.Date;
import java.util.Scanner;

public class Game {
    private Date startTime;
    private Date endTime;
    private BaseEmoteCommand[] commands;

    public Game () {
        commands =  new BaseEmoteCommand[]{
                    new LookCommand(),
                    new DanceCommand(),
                    new JumpCommand(),
                    new InventoryCommand()};
    }

    public Date getStartTime() {
        return startTime;
    }
    private void setStartTime(Date startTime){
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }

    private void setEndTime(Date endTime){
        this.endTime = endTime;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        this.setStartTime(new Date());

        //Declares a variable named scanner of type Scanner - it will get input from system.in
        boolean loop = true;

        while (loop) {
            System.out.print("> ");
            String input = scanner.nextLine(); //waits for input until the program continues
            input = input.trim();
            BaseEmoteCommand validCommand = getValidCommand(input);

            if (null != validCommand){
                validCommand.execute(input);
            }
            else if (input.equalsIgnoreCase("exit")){
                System.out.println("Goodbye.");
                loop = false;
            }
            else
                System.out.println("Huh? I don't understand.");
        }
        this.setEndTime(new Date());
    }


    private BaseEmoteCommand getValidCommand(String input) {
        BaseEmoteCommand validCommand = null;

        for (BaseEmoteCommand command: commands){
            if(command.isValid(input)){
               validCommand = command;
            }
        }
        return validCommand;
    }
}
