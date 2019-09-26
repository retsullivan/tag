import org.improving.tag.FileSystemAdaptor;
import org.improving.tag.Game;
import org.improving.tag.Player;
import org.improving.tag.SaveGameFactory;
import org.improving.tag.commands.LoadCommand;
import org.improving.tag.commands.SetNameCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class LoadCommandTest {

    //these are set in the arrange() block
    private LoadCommand target;
    private TestInputOutput io;
    private Game game;
    private SaveGameFactory factory;
    private FileSystemAdaptor fsa;

    @BeforeEach
    public void arrange(){
        io = new TestInputOutput();             //InputOutput io = new TestInputOutput();
        target = new LoadCommand(io, factory);        //LoadNameCommand target = new LoadCommand(io);
        game = new Game(null, null, null);
        factory = new SaveGameFactory(fsa, io);
        fsa = new FileSystemAdaptor();
    }

    @Test
    public void isValid_should_be_true_when_input_is_load_filename(){
        //Act
        var result = target.isValid("load filename", game);   //Boolean result - target.isValid("@set name=", null);
        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is__load_filename_load_filename(){
        //Act
        var result = target.isValid("     load filename  ", game);
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_load_filename_with_caps(){
        //Act
        var result = target.isValid("loAd fileNAme", game);   //Boolean result - target.isValid("dance", null);
        //Assert
        assertTrue(result);
    }
    @Test
    public void isValid_should_be_false_when_input_is_foobar(){
        var io = new TestInputOutput();     //InputOutput io = new TestInputOutput();
        var target = new SetNameCommand(io);  //DanceCommand target = new DanceCommand(io);
        //Act
        var result = target.isValid("foobar", game);   //Boolean result - target.isValid("dance", null);
        //Assert
        assertFalse(result);

    }

    @Test
    public void isValid_should_be_false_when_input_is_null(){
        var io = new TestInputOutput();
        var target = new SetNameCommand(io);
        //Act
        var result = target.isValid(null, game);
        //Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_only_load(){
        var io = new TestInputOutput();
        var target = new SetNameCommand(io);
        //Act
        var result = target.isValid("load ", game);
        //Assert
        assertFalse(result);
    }

    @Test
    public void execute_should_set_location_to_fileLocation(){
        //act
        game = mock(Game.class);                //makes a fake game for testing purposes
        Player player = new Player(null);               //making a new player
        //player.setLocation();                       //setting name
        player.setHitPoints(50);                    //setting hit points
        player = spy(player);

        when(game.getPlayer()).thenReturn(player);  //this is to show us when/if the program is getting the player information

        //Act
        target.execute("@set name=Rachel", game);   //This is changing the player name

        //Assert
        //this is checking to makes sure getPlayer was called 2 times
        // verify(game, times(2)).getPlayer(); (an interesting exercise in figuring out how to use mock - not needed)
        //verify that name was set to "Rachel"
        verify (player).setName("Rachel");      //we need to make sure this meets our requirements
        //assertEquals("Your name is now Rachel", io.lastText);

    }


 /*   @Test
    public void load_should_load_save_file() throws IOException {
        //Arrange - now taken care of by the setup() method
        String path = "____";

        when(fsa.loadFile(path)).thenReturn(Map.of("location", "The Amazon")); //interacts with a external file

        //Act
        target.load(path, g);   //loads the save game factory

        //Assert
        //the location will be the same as the location in the save file
        assertEquals("The Amazon", g.getPlayer().getLocation().getName());

    } */





    @Test
    public void execute_should_display_all_words_but_set_name_Rachel() {
        //Act
        target.execute("@set name=Rachel", game);
        //assert
        assertEquals("Your name is now Rachel",  io.lastText);
    }

    @Test
    public void execute_should_display_all_words_but_move_with_spaces() {
        //Act
        target.execute("  @set name=Rachel  ", game);
        //assert
        assertEquals("Your name is now Rachel", io.lastText);
    }

    @Test
    public void execute_should_display_all_words_but_set_name_with_uppercase() {
        //Act
        target.execute("@Set NAme=RaChel", game);
        //assert
        assertEquals("Your name is now RaChel", io.lastText);
    }
}