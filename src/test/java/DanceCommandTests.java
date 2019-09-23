
import org.improving.tag.commands.DanceCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class DanceCommandTests {

    DanceCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange(){
        io = new TestInputOutput();     //InputOutput io = new TestInputOutput();
        target = new DanceCommand(io);      //DanceCommand target = new DanceCommand(io);
    }

    @Test
    public void isValid_should_be_true_when_input_is_dance(){
        //Act
        var result = target.isValid("dance", null);   //Boolean result - target.isValid("dance", null, null);
        //Assert
        assertTrue(result);

    }
    @Test
    public void isValid_should_be_false_when_input_is_foobar(){
        var io = new TestInputOutput();     //InputOutput io = new TestInputOutput();
        var target = new DanceCommand(io);  //DanceCommand target = new DanceCommand(io);
        //Act
        var result = target.isValid("foobar", null);   //Boolean result - target.isValid("dance", null);
        //Assert
        assertFalse(result);

    }

    @Test
    public void isValid_should_be_false_when_input_is_null(){
        var io = new TestInputOutput();
        var target = new DanceCommand(io);
        //Act
        var result = target.isValid(null, null);
        //Assert
        assertFalse(result);

    }

    @Test
    public void isValid_should_be_true_when_input_is_dance_with_spaces(){
        //Act
        var result = target.isValid("     dance   ", null);
        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_dance_with_caps(){
        //Act
        var result = target.isValid("DancE", null);   //Boolean result - target.isValid("dance", null);
        //Assert
        assertTrue(result);
    }

    @Test
    public void execute_should_return_phrase(){
        //act
        target.execute(null, null);
        //assert
        assertEquals("You dance around.", io.lastText);
    }





}

