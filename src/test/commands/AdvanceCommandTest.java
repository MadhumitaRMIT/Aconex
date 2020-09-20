package main.simulator.commands;

import main.simulator.entities.Position;
import main.simulator.entities.enums.Direction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdvanceCommandTest {

    @Test
    public void advanceToEastWorks() {

        AdvanceCommand advanceCommand = new AdvanceCommand(4);

        Position currentPosition = new Position(0,0, Direction.EAST);
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(0, 1, Direction.EAST));
        expected.add(new Position(0, 2, Direction.EAST));
        expected.add(new Position(0, 3, Direction.EAST));
        expected.add(new Position(0, 4, Direction.EAST));

        assertEquals(4, advanceCommand.getStep());

        List<Position> actual = advanceCommand.apply(currentPosition);

        assertEquals(4, actual.size());
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void advanceToWestWorks() {

        AdvanceCommand advanceCommand = new AdvanceCommand(5);

        Position currentPosition = new Position(1,5, Direction.WEST);
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(1, 4, Direction.WEST));
        expected.add(new Position(1, 3, Direction.WEST));
        expected.add(new Position(1, 2, Direction.WEST));
        expected.add(new Position(1, 1, Direction.WEST));
        expected.add(new Position(1, 0, Direction.WEST));

        assertEquals(5, advanceCommand.getStep());

        List<Position> actual = advanceCommand.apply(currentPosition);

        System.out.println("test");

        assertEquals(5, actual.size());
        assertArrayEquals(expected.toArray(), actual.toArray());


    }

    @Test
    public void advanceToSouthWorks() {

        AdvanceCommand advanceCommand = new AdvanceCommand(4);

        Position currentPosition = new Position(1,0, Direction.SOUTH);
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(2, 0, Direction.SOUTH));
        expected.add(new Position(3, 0, Direction.SOUTH));
        expected.add(new Position(4, 0, Direction.SOUTH));
        expected.add(new Position(5, 0, Direction.SOUTH));

        assertEquals(4, advanceCommand.getStep());

        List<Position> actual = advanceCommand.apply(currentPosition);

        assertEquals(4, actual.size());
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void advanceToNorthWorks() {

        AdvanceCommand advanceCommand = new AdvanceCommand(4);

        Position currentPosition = new Position(4,5, Direction.NORTH);
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(3, 5, Direction.NORTH));
        expected.add(new Position(2, 5, Direction.NORTH));
        expected.add(new Position(1, 5, Direction.NORTH));
        expected.add(new Position(0, 5, Direction.NORTH));

        assertEquals(4, advanceCommand.getStep());

        List<Position> actual = advanceCommand.apply(currentPosition);

        assertEquals(4, actual.size());
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

}