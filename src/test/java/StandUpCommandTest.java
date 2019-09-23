import org.improving.tag.commands.StandUpCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StandUpCommandTest {

    StandUpCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange(){
        io = new TestInputOutput();     //InputOutput io = new TestInputOutput();
        target = new StandUpCommand(io);      //DanceCommand target = new DanceCommand(io);
    }

    @Test
    public void isValid_should_be_true_when_input_is_stand_up(){
        //Act
        var result = target.isValid("stand", null);   //Boolean result - target.isValid("dance", null);
        //Assert
        assertTrue(result);

    }
    @Test
    public void isValid_should_be_false_when_input_is_foobar(){
        var io = new TestInputOutput();     //InputOutput io = new TestInputOutput();
        var target = new StandUpCommand(io);  //DanceCommand target = new DanceCommand(io);
        //Act
        var result = target.isValid("foobar", null);   //Boolean result - target.isValid("dance", null);
        //Assert
        assertFalse(result);

    }

    @Test
    public void isValid_should_be_false_when_input_is_null(){
        var io = new TestInputOutput();
        var target = new StandUpCommand(io);
        //Act
        var result = target.isValid(null, null);
        //Assert
        assertFalse(result);

    }

    @Test
    public void isValid_should_be_true_when_input_is_stand_up_with_spaces(){
        //Act
        var result = target.isValid("     stand   ", null);
        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_stand_up_with_caps(){
        //Act
        var result = target.isValid("StAnd", null);   //Boolean result - target.isValid("dance", null);
        //Assert
        assertTrue(result);
    }

    @Test
    public void execute_should_return_phrase(){
        //act
        target.execute(null, null);
        //assert
        assertEquals("You stand up.", io.lastText);
    }





}