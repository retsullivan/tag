import org.improving.tag.commands.DanceCommand;
import org.improving.tag.commands.MoveCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveCommandTests {

    MoveCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange(){
        io = new TestInputOutput();     //InputOutput io = new TestInputOutput();
        target = new MoveCommand(io);      //MoveCommand target = new DanceCommand(io);
    }

    @Test
    public void isValid_should_be_true_when_input_is_move(){
        //Act
        var result = target.isValid("move to the moon", null);   //Boolean result - target.isValid("dance", null);
        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_move_with_spaces(){
        //Act
        var result = target.isValid("     move to the moon   ", null);
        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_dance_with_caps(){
        //Act
        var result = target.isValid("Move Too thE mOOn", null);   //Boolean result - target.isValid("dance", null);
        //Assert
        assertTrue(result);
    }
    @Test
    public void isValid_should_be_false_when_input_is_foobar(){
        var io = new TestInputOutput();     //InputOutput io = new TestInputOutput();
        var target = new MoveCommand(io);  //DanceCommand target = new DanceCommand(io);
        //Act
        var result = target.isValid("foobar", null);   //Boolean result - target.isValid("dance", null);
        //Assert
        assertFalse(result);

    }

    @Test
    public void isValid_should_be_false_when_input_is_null(){
        var io = new TestInputOutput();
        var target = new MoveCommand(io);
        //Act
        var result = target.isValid(null, null);
        //Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_only_one_word(){
        var io = new TestInputOutput();
        var target = new MoveCommand(io);
        //Act
        var result = target.isValid("move", null);
        //Assert
        assertFalse(result);

    }
    @Test
    public void execute_should_display_all_words_but_move() {
        //Act
        target.execute("move to the moon", null);
        //assert
        assertEquals("You proceed to the moon.", io.lastText);
    }

    @Test
    public void execute_should_display_all_words_but_move_with_spaces() {
        //Act
        target.execute("  move to the moon     ", null);
        //assert
        assertEquals("You proceed to the moon.", io.lastText);
    }

    @Test
    public void execute_should_display_all_words_but_move_with_uppercase() {
        //Act
        target.execute("  moVe to the mooN     ", null);
        //assert
        assertEquals("You proceed to the moon.", io.lastText);
    }


    public void move_command_displays_YSNP_if_if_adversary_at_Current_Location()
    {



    }


    }




