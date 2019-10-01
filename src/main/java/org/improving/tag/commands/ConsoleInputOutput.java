package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleInputOutput implements InputOutput {
private Scanner scanner;

    public ConsoleInputOutput (Scanner scanner) {
        this.scanner = scanner;
    }

    //private Scanner scanner = new Scanner(System.in);

    public String receiveInput() {
        return scanner.nextLine();
    }

    @Override
    public void displayText(Object text) {
        if (!"".equals(text.toString())) { //if(text.toString !="")
            System.out.println(text);
        }
    }
    public void displayPrompt(String prompt){
        System.out.print(prompt);
    }

    public void displayNewLine(){
    }

}
