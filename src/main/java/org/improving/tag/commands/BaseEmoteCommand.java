package org.improving.tag.commands;


public abstract class BaseEmoteCommand implements Command{

    private String cmdText;
    private String cmdResponse;

    // this. forces us to reference the field instead of the parameter.

    public BaseEmoteCommand(String cmdText, String cmdResponse){
        this.cmdText = cmdText;
        this.cmdResponse = cmdResponse;
    }
    @Override
    public boolean isValid(String input){
        return input.equalsIgnoreCase(cmdText);
    }

    public void execute(String input){
        System.out.println(cmdResponse);
    }


}
