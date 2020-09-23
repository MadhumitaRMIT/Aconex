package com.aconex.simulator.commands;


import com.aconex.simulator.entities.Position;
import com.aconex.simulator.entities.enums.Direction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuitCommandTest {

    @Test
    public void quitCommandWorks() {

        QuitCommand quitCommand = new QuitCommand("test");

        Position currentPosition = new Position(0,0, Direction.EAST);

        List<Position> actual = quitCommand.apply(currentPosition);

        assertTrue(actual.isEmpty());
    }

}