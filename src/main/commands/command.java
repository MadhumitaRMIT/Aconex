package simulator.commands;

import simulator.entities.Position;
import java.util.List;
public interface Command {
    List<Position> apply(Position currentPosition);
}

