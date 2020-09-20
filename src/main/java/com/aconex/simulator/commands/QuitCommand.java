package com.aconex.simulator.commands;
import com.aconex.simulator.entities.Position;
import java.util.ArrayList;
import java.util.List;

public class QuitCommand implements Command {

    private String reason;

    public QuitCommand(String reason) {
        this.reason = reason;
    }

    @Override
    public List<Position> apply(Position currentPosition) {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return "quit";
    }

    public String getReason() {
        return reason;
    }
}
