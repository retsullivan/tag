import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.improving.tag.commands.LickCommand;

public class LickCommandTest {

        LickCommand target;
        TestInputOutput io;

        @BeforeEach
        public void arrange(){
            io = new TestInputOutput();     //InputOutput io = new TestInputOutput();
            target = new LickCommand(io);      //MoveCommand target = new DanceCommand(io);
        }

        @Test
        public void isValid_should_be_true_when_input_is_lick(){
            //Act
            var result = target.isValid("lick a rock");
            //Assert
            assertTrue(result);
        }

        @Test
        public void isValid_should_be_true_when_input_is_lick_with_spaces(){
            //Act
            var result = target.isValid("     lick a rock   ");
            //Assert
            assertTrue(result);
        }

        @Test
        public void isValid_should_be_true_when_input_is_lick_with_caps(){
            //Act
            var result = target.isValid("licK a ROCK");
            //Assert
            assertTrue(result);
        }
        @Test
        public void isValid_should_be_false_when_input_is_foobar(){
            var io = new TestInputOutput();
            var target = new LickCommand(io);
            //Act
            var result = target.isValid("foobar");
            //Assert
            assertFalse(result);

        }

        @Test
        public void isValid_should_be_false_when_input_is_null(){
            var io = new TestInputOutput();
            var target = new LickCommand(io);
            //Act
            var result = target.isValid(null);
            //Assert
            assertFalse(result);
        }

        @Test
        public void isValid_should_be_false_when_input_is_only_one_word(){
            var io = new TestInputOutput();
            var target = new LickCommand(io);
            //Act
            var result = target.isValid("lick");
            //Assert
            assertFalse(result);

        }
        @Test
        public void execute_should_display_all_words_but_move() {
            //Act
            target.execute("lick a rock");
            //assert
            assertEquals("You lick a rock. Gross.", io.lastText);
        }

        @Test
        public void execute_should_display_all_words_but_move_with_spaces() {
            //Act
            target.execute("  lick a rock     ");
            //assert
            assertEquals("You lick a rock. Gross.", io.lastText);
        }

        @Test
        public void execute_should_display_all_words_but_move_with_uppercase() {
            //Act
            target.execute("Lick A ROCK");
            //assert
            assertEquals("You lick a rock. Gross.", io.lastText);
        }




}
