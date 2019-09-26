package org.improving.tag;

import com.sun.source.tree.TryTree;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SaveGameFactory {

    private final FileSystemAdaptor fsa;
    private final InputOutput io;

    public SaveGameFactory(FileSystemAdaptor fsa, InputOutput io) {
        this.fsa = fsa;
        this.io = io;
    }

    public String save(Game game)  {

        var locationName = game.getPlayer().getLocation().getName();

        Map<String, String> saveContents = new HashMap<>();

        saveContents.put("location", locationName);
        String path = null;
        try{
           path = fsa.saveToFile(saveContents);
           io.displayText("Saved: " + path);
        } catch (IOException ex){
            io.displayText(ex.toString());
        }
        return path;
    }

    public void load(String path, Game game)  {
        Map<String, String> saveContents;
        try {
            saveContents = fsa.loadFile(path);
        } catch (IOException ex){
            io.displayText(ex.toString());
            io.displayText("Failed to Load file");
            return;
        }
        Location lastKnownLocation = game.getLocationOf(saveContents.get("location"));
        game.getPlayer().setLocation(lastKnownLocation);
    }
}
