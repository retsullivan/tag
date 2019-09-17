package org.improving.tag;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Declares a variable named scanner of type Scanner - it will get input from system.in
        Scanner scanner = new Scanner(System.in);

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

    }


}
