import org.improving.tag.FileSystemAdaptor;
import org.improving.tag.Game;
import org.improving.tag.SaveGameFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import org.mockito.configuration.IMockitoConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class SaveGameFactoryTest {

    private TestInputOutput io;
    private FileSystemAdaptor fsa;
    private SaveGameFactory target;
    private Game g;

    @BeforeEach
    public void setup(){    //this lets us use the same set of variables
        io = new TestInputOutput();
        fsa = mock(FileSystemAdaptor.class);
        target = new SaveGameFactory(fsa, io);
        g = new Game(null, io, target); //has to be under SGF so that target can be passed
    }

    @Test
    public void save_should_preserve_location_name() throws IOException {       //pass in Game game?
        //arrange - now taken care of by the setup() method


        //declares a variable DictClass (the class is Dictionary<String, String>)
        Class<Map<String, String>> dictClass =
                //shows you the path of how it gets the info for DictClass
                (Class<Map<String, String>>) (Class) Map.class;
        //
        ArgumentCaptor<Map<String, String>> contentsCaptor = ArgumentCaptor.forClass(dictClass);
        when(fsa.saveToFile(any())).thenReturn("This is dumb");


        //act
        String path = target.save(g);               //this returns the location of the saved

        //assert
        verify(fsa).saveToFile(contentsCaptor.capture());
        var loc = contentsCaptor.getValue().get("location");
        assertEquals("The Deathly Hallows", loc);
        assertNotNull(path);                         //makes sure it's not null
        assertNotEquals("", path);         //makes sure the string isn't empty

    }

    @Test
    public void load_should_load_save_file() throws IOException {
        //Arrange - now taken care of by the setup() method
        String path = "this is a fake path";

        when(fsa.loadFile(path)).thenReturn(Map.of("location", "The Amazon")); //interacts with a external file

        //Act
        target.load(path, g);   //loads the save game factory

        //Assert
        //the location will be the same as the location in the save file
        assertEquals("The Amazon", g.getPlayer().getLocation().getName());

    }
}
