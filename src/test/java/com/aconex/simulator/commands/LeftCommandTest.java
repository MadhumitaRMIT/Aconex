package com.aconex.simulator.commands;

import com.aconex.simulator.entities.Position;
import com.aconex.simulator.entities.enums.Direction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeftCommandTest {

    @Test
    public void turnLeftToEastWorks() {

        LeftCommand leftCommand = new LeftCommand();

        Position currentPosition = new Position(0,0, Direction.EAST);
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(0, 0, Direction.NORTH));

        List<Position> actual = leftCommand.apply(currentPosition);

        assertEquals(1, actual.size());
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void turnLeftToWestWorks() {

        LeftCommand leftCommand = new LeftCommand();

        Position currentPosition = new Position(0,0, Direction.WEST);
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(0, 0, Direction.SOUTH));

        List<Position> actual = leftCommand.apply(currentPosition);

        assertEquals(1, actual.size());
        assertArrayEquals(expected.toArray(), actual.toArray());

    }

    @Test
    public void turnLeftToSouthWorks() {

        LeftCommand leftCommand = new LeftCommand();

        Position currentPosition = new Position(0,0, Direction.SOUTH);
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(0, 0, Direction.EAST));

        List<Position> actual = leftCommand.apply(currentPosition);

        assertEquals(1, actual.size());
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void turnLeftToNorthWorks() {

        LeftCommand leftCommand = new LeftCommand();

        Position currentPosition = new Position(0,0, Direction.NORTH);
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(0, 0, Direction.WEST));

        List<Position> actual = leftCommand.apply(currentPosition);

        assertEquals(1, actual.size());
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

}