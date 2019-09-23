import org.improving.tag.commands.SitDownCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SitDownCommandTests {
    SitDownCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange(){
        io = new TestInputOutput();     //InputOutput io = new TestInputOutput();
        target = new SitDownCommand(io);      //DanceCommand target = new DanceCommand(io);
    }

    @Test
    public void isValid_should_be_true_when_input_is_sit(){
        //Act
        var result = target.isValid("sit", null);   //Boolean result - target.isValid("dance", null);
        //Assert
        assertTrue(result);

    }
    @Test
    public void isValid_should_be_false_when_input_is_foobar(){
        var io = new TestInputOutput();     //InputOutput io = new TestInputOutput();
        var target = new SitDownCommand(io);  //DanceCommand target = new DanceCommand(io);
        //Act
        var result = target.isValid("foobar", null);   //Boolean result - target.isValid("dance", null);
        //Assert
        assertFalse(result);

    }

    @Test
    public void isValid_should_be_false_when_input_is_null(){
        var io = new TestInputOutput();
        var target = new SitDownCommand(io);
        //Act
        var result = target.isValid(null, null);
        //Assert
        assertFalse(result);

    }

    @Test
    public void isValid_should_be_true_when_input_is_stand_up_with_spaces(){
        //Act
        var result = target.isValid("     sit   ", null);
        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_stand_up_with_caps(){
        //Act
        var result = target.isValid("SIt", null);   //Boolean result - target.isValid("dance", null);
        //Assert
        assertTrue(result);
    }

    @Test
    public void execute_should_return_phrase(){
        //act
        target.execute(null, null);
        //assert
        assertEquals("You sit down.", io.lastText);
    }

}