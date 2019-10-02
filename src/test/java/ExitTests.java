import org.improving.tag.Exit;
import org.improving.tag.Location;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExitTests {

    @Test
    public void toString_should_include_name() {
        //arrange
        var target = new Exit("Door", new Location());

        //act
        var result = target.toString();

        //assert
        assertTrue(result.contains("Door"));
    }


    @Test
    public void equal_should_be_true_when_name_and_destination_match() {
        //arrange
        var destination = new Location();
        var targetA = new Exit("Door", destination);
        var targetB = new Exit("Door", destination, "this", "intentionally", "filled", "in");
        //act
        var result = targetA.equals(targetB);
        //assert
        assertTrue(result);
    }

    @Test
    public void equal_should_be_false_when_compared_to_non_exit() {
        //arrange
        var destination = new Location();
        var targetA = new Exit("Door", destination);
        //act
        var result = targetA.equals("Door");
        //assert
        assertFalse(result);
    }

    @Test
    public void equal_should_be_true_when_name_and_destination_match_of_course() {
        //arrange

        var locationA = new Location();
        var locationB = new Location();

        locationA.setName("The Attic");
        locationB.setName("The Attic");


        var targetA = new Exit("Door", locationA);
        var targetB = new Exit("Door", locationB, "this", "intentionally", "filled", "in");
        //act
        var result = targetA.equals(targetB);
        //assert
        assertTrue(result);
    }
}
