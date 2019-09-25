package org.improving.tag;

import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

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
}
