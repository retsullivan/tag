package org.improving.tag.commands;

public class LookCommand {
    public boolean isValid(String input){
        /*if (input.equalsIgnoreCase("look")) {
            return true;
        }
        else
            return false; */
       // boolean isEqual = input.equals("look");
       // return isEqual;
        return input.equalsIgnoreCase("look");
    }

    public void execute(String input){
        System.out.println("You look around.");
    }
}
