package com.aconex.simulator.input;

import com.aconex.simulator.commands.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandParserTest {

    private CommandParser commandParser = new CommandParser();

    @Test
    public void parsesAdvanceCommand() {
        Command command = commandParser.apply("ADVANCE 4");

        assertTrue(command instanceof AdvanceCommand);
        assertEquals(4, ((AdvanceCommand) command).getStep());
        assertEquals("advance 4", command.toString());
    }

    @Test
    public void parsesAdvanceCommandWhenShortVersionUsed() {
        Command command = commandParser.apply("A 4");

        assertTrue(command instanceof AdvanceCommand);
        assertEquals(4, ((AdvanceCommand) command).getStep());
        assertEquals("advance 4", command.toString());
    }

    @Test
    public void parsesLeftCommand() {
        Command command = commandParser.apply("LEFT");

        assertTrue(command instanceof LeftCommand);
        assertEquals("turn left", command.toString());
    }

    @Test
    public void parsesLeftCommandWhenShortVersionUsed() {
        Command command = commandParser.apply("L");

        assertTrue(command instanceof LeftCommand);
        assertEquals("turn left", command.toString());
    }

    @Test
    public void parsesRightCommand() {
        Command command = commandParser.apply("RIGHT");

        assertTrue(command instanceof RightCommand);
        assertEquals("turn right", command.toString());
    }

    @Test
    public void parsesRightCommandWhenShortVersionUsed() {
        Command command = commandParser.apply("R");

        assertTrue(command instanceof RightCommand);
        assertEquals("turn right", command.toString());
    }

    @Test
    public void parsesQuitCommand() {
        Command command = commandParser.apply("QUIT");

        assertTrue(command instanceof QuitCommand);
        assertEquals("quit", command.toString());
    }

    @Test
    public void parsesQuitCommandWhenShortVersionUsed() {
        Command command = commandParser.apply("Q");

        assertTrue(command instanceof QuitCommand);
        assertEquals("quit", command.toString());
    }

    @Test
    public void parsesBadFormat1() {
        Command command = commandParser.apply("A");

        assertTrue(command instanceof NoOpCommand);
    }

    @Test
    public void parsesBadFormat2() {
        Command command = commandParser.apply("L 4");

        assertTrue(command instanceof NoOpCommand);
    }
}