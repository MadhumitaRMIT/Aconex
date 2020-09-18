package simulator.entities.enums;
import simulator.commands.Command;
import simulator.entities.enums.Cost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Bulldozer {
    private Position position;
    private Map<Cost, Integer> itemisedCostMap;
    private List<Command> commandList;
    private boolean placed;
    
    public Bulldozer(Position position) {
        this.position = position;
        this.commandList = new ArrayList<>();
        this.placed = false;
        initCostMap();
    }
    private void initCostMap() {
        this.itemisedCostMap = new TreeMap<>();
        Arrays.stream(Cost.values()).forEach(cost -> itemisedCostMap.put(cost, 0));
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Command getLastCommand() {
        return commandList.get(commandList.size() - 1);
    }

    public Map<Cost, Integer> getItemisedCostMap() {
        return itemisedCostMap;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }

    public List<Command> getCommandList() {
        return commandList;
    }
}
