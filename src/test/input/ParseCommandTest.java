package simulator.input;

import simulator.commands.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    private Parser Parser = new Parser();

    @Test
    public void parsesAdvanceCommand() {
        Command command = Parser.apply("ADVANCE 4");

        assertTrue(command instanceof AdvanceCommand);
        assertEquals(4, ((AdvanceCommand) command).getStep());
        assertEquals("advance 4", command.toString());
    }

    @Test
    public void parsesAdvanceCommandWhenShortVersionUsed() {
        Command command = Parser.apply("A 4");

        assertTrue(command instanceof AdvanceCommand);
        assertEquals(4, ((AdvanceCommand) command).getStep());
        assertEquals("advance 4", command.toString());
    }

    @Test
    public void parsesLeftCommand() {
        Command command = Parser.apply("LEFT");

        assertTrue(command instanceof LeftCommand);
        assertEquals("turn left", command.toString());
    }

    @Test
    public void parsesLeftCommandWhenShortVersionUsed() {
        Command command = Parser.apply("L");

        assertTrue(command instanceof LeftCommand);
        assertEquals("turn left", command.toString());
    }

    @Test
    public void parsesRightCommand() {
        Command command = Parser.apply("RIGHT");

        assertTrue(command instanceof RightCommand);
        assertEquals("turn right", command.toString());
    }

    @Test
    public void parsesRightCommandWhenShortVersionUsed() {
        Command command = Parser.apply("R");

        assertTrue(command instanceof RightCommand);
        assertEquals("turn right", command.toString());
    }

    @Test
    public void parsesQuitCommand() {
        Command command = Parser.apply("QUIT");

        assertTrue(command instanceof QuitCommand);
        assertEquals("quit", command.toString());
    }

    @Test
    public void parsesQuitCommandWhenShortVersionUsed() {
        Command command = Parser.apply("Q");

        assertTrue(command instanceof QuitCommand);
        assertEquals("quit", command.toString());
    }

    @Test
    public void parsesBadFormat1() {
        Command command = Parser.apply("A");

        assertTrue(command instanceof NoOpCommand);
    }

    @Test
    public void parsesBadFormat2() {
        Command command = Parser.apply("L 4");

        assertTrue(command instanceof NoOpCommand);
    }
}