package org.improving.tag;

import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.file.Files.readAllLines;

@Component
public class FileSystemAdaptor {

    public String saveToFile(Map<String, String> contents) throws IOException {
        var file =   File.createTempFile("saveGame", "");   //need to allow it to throw file Exception

        try ( var writer = new FileWriter(file)) { //Try with resources - replaces a Try/Catch/Throw

            //there is no construct that lets you get key and value at same time

            for (var pair : contents.entrySet()) {        //there is no construct that lets you get key and value at same time
                writer.append(pair.getKey() + "|" + pair.getValue());
            }
        } //this will close the file we are writing to
        return file.getAbsolutePath();

    }

    public Map<String, String> loadFile(String path) throws IOException {

        Map<String, String> properties = new HashMap<>();
        List<String> contents = Files.readAllLines(Path.of(path));
        for(String line : contents){            //for each line of the file, we need to split it at the |"
            String[] temp = line.split("\\|");
            //this puts the first half of each line in the "Location" part of the map
            //this puts the second half of each line in the "Name"
            properties.put(temp [0], temp[1]);
        }

        return properties;
    }
}
