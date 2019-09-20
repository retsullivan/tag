package org.improving.tag.commands;
import org.springframework.stereotype.Component;

@Component
public class InventoryCommand extends BaseEmoteCommand {
    public InventoryCommand() {
        super("inventory", "You have 0 items.");
    }
}