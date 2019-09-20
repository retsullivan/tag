package org.improving.tag.commands;


import org.improving.tag.InputOutput;

public abstract class BaseEmoteCommand implements Command{

    private String cmdText;
    private String cmdResponse;
    private InputOutput io;

    // this. forces us to reference the field instead of the parameter.

    public BaseEmoteCommand(String cmdText, String cmdResponse, InputOutput io){
        this.cmdText = cmdText;
        this.cmdResponse = cmdResponse;
        this.io = io;
    }
    @Override
    public boolean isValid(String input){
        //trim here instead of in input output so we can theoretically accept whitespace
        return (input == null? "" :input).trim().equalsIgnoreCase(cmdText);
        //ternaryoperator <boolean> ? <true> : <false>
    }
    public void execute(String input){
        io.displayText(cmdResponse);
    }


}
