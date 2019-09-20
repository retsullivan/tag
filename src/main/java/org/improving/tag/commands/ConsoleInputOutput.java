package org.improving.tag.commands;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleInputOutput implements org.improving.tag.InputOutput {
    private Scanner scanner = new Scanner(System.in);

    public String receiveInput() {
        return scanner.nextLine();
    }


    public void displayText(String text) {
        System.out.println(text);
    }

    public void displayPrompt(String prompt){
        System.out.print(prompt);
    }
}
