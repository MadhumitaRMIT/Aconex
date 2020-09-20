package main.simulator.commands;

import main.simulator.entities.Position;
import main.simulator.entities.enums.Direction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RightCommandTest {

    @Test
    public void turnRightToEastWorks() {

        RightCommand rightCommand = new RightCommand();

        Position currentPosition = new Position(0,0, Direction.EAST);
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(0, 0, Direction.SOUTH));

        List<Position> actual = rightCommand.apply(currentPosition);

        assertEquals(1, actual.size());
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void turnRightToWestWorks() {

        RightCommand rightCommand = new RightCommand();

        Position currentPosition = new Position(0,0, Direction.WEST);
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(0, 0, Direction.NORTH));

        List<Position> actual = rightCommand.apply(currentPosition);

        assertEquals(1, actual.size());
        assertArrayEquals(expected.toArray(), actual.toArray());

    }

    @Test
    public void turnRightToSouthWorks() {

        RightCommand rightCommand = new RightCommand();

        Position currentPosition = new Position(0,0, Direction.SOUTH);
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(0, 0, Direction.WEST));

        List<Position> actual = rightCommand.apply(currentPosition);

        assertEquals(1, actual.size());
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void turnRightToNorthWorks() {

        RightCommand rightCommand = new RightCommand();

        Position currentPosition = new Position(0,0, Direction.NORTH);
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(0, 0, Direction.EAST));

        List<Position> actual = rightCommand.apply(currentPosition);

        assertEquals(1, actual.size());
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}