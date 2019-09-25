import org.improving.tag.FileSystemAdaptor;
import org.improving.tag.Game;
import org.improving.tag.SaveGameFactory;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.configuration.IMockitoConfiguration;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class SaveGameFactoryTest {

    @Test
    public void save_should_preserve_location_name() throws IOException {       //pass in Game game?
        //arrange
        TestInputOutput io = new TestInputOutput();
        FileSystemAdaptor fsa = mock(FileSystemAdaptor.class);
        SaveGameFactory target = new SaveGameFactory(fsa, io);
        Game g = new Game(null, io, target); //has to be under SGF so that target can be passed

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
}
