import org.improving.tag.Game;
import org.improving.tag.Player;
import org.improving.tag.commands.SetNameCommand;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SetNameCommandTests {

    //these are set in the arrange() block
    SetNameCommand target;
    TestInputOutput io;
    Game game;

    @BeforeEach
    public void arrange(){
        io = new TestInputOutput();             //InputOutput io = new TestInputOutput();
        target = new SetNameCommand(io);        //SetNameCommand target = new DanceCommand(io);
        game = new Game(null, null, null);
    }

    @Test
    public void isValid_should_be_true_when_input_is_set_name(){
        //Act
        var result = target.isValid("@set name=rachel", game);   //Boolean result - target.isValid("@set name=", null);
        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_Set_Name_with_spaces(){
        //Act
        var result = target.isValid("     @set name=rachel   ", game);
        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_dance_with_caps(){
        //Act
        var result = target.isValid("@sEt name=RacHel", game);   //Boolean result - target.isValid("dance", null);
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
    public void isValid_should_be_false_when_input_is_only_set_name_equals(){
        var io = new TestInputOutput();
        var target = new SetNameCommand(io);
        //Act
        var result = target.isValid("@set name =", game);
        //Assert
        assertFalse(result);

    }

    @Test
    public void execute_should_set_name(){
        //act
        game = mock(Game.class);                //makes a fake game for testing purposes
        Player player = new Player(null);               //making a new player
        player.setName("hi");                       //setting name
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