package com.aconex.simulator.commands;

import com.aconex.simulator.entities.Position;
import java.util.List;
public interface Command {
    List<Position> apply(Position currentPosition);
}

