package org.improving.tag;


import java.util.Date;
import java.util.Scanner;

public class Game {

    private Date startTime;
    private Date endTime;


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

        while (loop == true) {
            System.out.print("> ");
            String input = scanner.nextLine(); //waits for input until the program continues
            input = input.trim();
            if (input.equalsIgnoreCase("look")) {
                System.out.println("You look around.");
            }
            else if (input.equalsIgnoreCase("inventory")) {
                System.out.println("You are carrying nothing.");
            }
            else if (input.equalsIgnoreCase("dance")) {
                System.out.println("You dance around.");
            }
            else if (input.equalsIgnoreCase("jump")) {
                System.out.println("You jump in the air.");
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
}