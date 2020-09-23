package com.aconex.simulator.processor;

import com.aconex.simulator.TestDataHelper;
import com.aconex.simulator.commands.*;
import com.aconex.simulator.entities.Bulldozer;
import com.aconex.simulator.entities.Position;
import com.aconex.simulator.entities.Square;
import com.aconex.simulator.entities.enums.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandProcessorTest {

    private CommandProcessor commandProcessor;

    private Square[][] site;

    @BeforeEach
    public void setup() {
        site = TestDataHelper.getSiteMap();
        commandProcessor = new CommandProcessor(site);

    }

    @Test
    public void firstCommandWorks() {

        Command command = new AdvanceCommand(5);
        Bulldozer input = new Bulldozer(new Position(0,0, Direction.EAST));

        Bulldozer output = commandProcessor.apply(input, command);

        assertEquals(1, output.getCommandList().size());
        assertEquals(new Position(0, 4, Direction.EAST), output.getPosition());

    }

    @Test
    public void subsequentCommandWorks() {

        Command command = new AdvanceCommand(2);
        Bulldozer input = new Bulldozer(new Position(0,3, Direction.SOUTH));
        input.getCommandList().add(new AdvanceCommand(4));
        input.getCommandList().add(new RightCommand());
        input.setPlaced(true);

        Bulldozer output = commandProcessor.apply(input, command);

        assertEquals(3, output.getCommandList().size());
        assertEquals(new Position(2, 3, Direction.SOUTH), output.getPosition());

    }

    @Test
    public void subsequentQuitCommandWorks() {

        Command command = new QuitCommand("test");
        Bulldozer input = new Bulldozer(new Position(0,3, Direction.SOUTH));
        input.getCommandList().add(new AdvanceCommand(4));
        input.getCommandList().add(new RightCommand());
        input.setPlaced(true);

        Bulldozer output = commandProcessor.apply(input, command);

        assertEquals(3, output.getCommandList().size());
        assertEquals(new Position(0, 3, Direction.SOUTH), output.getPosition());

    }

    @Test
    public void subsequentNoopCommandWorks() {

        Command command = new NoOpCommand("test");
        Bulldozer input = new Bulldozer(new Position(0,3, Direction.SOUTH));
        input.getCommandList().add(new AdvanceCommand(4));
        input.getCommandList().add(new RightCommand());
        input.setPlaced(true);

        Bulldozer output = commandProcessor.apply(input, command);

        assertEquals(3, output.getCommandList().size());
        assertEquals(new Position(0, 3, Direction.SOUTH), output.getPosition());

    }

}