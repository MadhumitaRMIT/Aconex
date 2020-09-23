package main.java.com.aconex.simulator.output;

import main.java.com.aconex.simulator.commands.QuitCommand;
import main.java.com.aconex.simulator.entities.Bulldozer;
import main.java.com.aconex.simulator.entities.Square;
import main.java.com.aconex.simulator.entities.enums.Cost;
import main.java.com.aconex.simulator.entities.enums.LandTypes;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Calculation implements Function<Bulldozer, Map<Cost, Integer>> {

    private final Square[][] siteMap;

    public Calculation(Square[][] siteMap) {
        this.siteMap = siteMap;
    }

    @Override
    public Map<Cost, Integer> apply(Bulldozer bulldozer) {

        Map<Cost, Integer> integerCostMap = bulldozer.getItemisedCostMap();

        System.out.println("\n"+ ((QuitCommand) bulldozer.getLastCommand()).getReason() + "\n");
        System.out.println(bulldozer.getCommandList().stream().map(Objects::toString).filter(Objects::nonNull).collect(Collectors.joining(", ")));

        integerCostMap.put(Cost.uncleared_square, (int) Arrays.stream(siteMap)
                        .flatMap(Arrays::stream)
                        .filter(square -> !square.isCleared() && !square.getType().equals(LandTypes.Protected_Tree))
                        .count());

        System.out.println("\nThe costs for this land clearing operation were:\n");
        System.out.printf("%-30s %20s %20s\n", "Item", "Quantity", "Cost");
        integerCostMap.forEach((key, value) -> {
            System.out.printf("%-30s %20d %20d\n", key.getName(),
                    value, key.getCredit() * value);
        });
        System.out.printf("%-30s\n", "----");
        System.out.printf("%-30s %40d", "Total", integerCostMap.entrySet().stream().
                mapToInt(value -> value.getKey().getCredit() * value.getValue()).sum());
        System.out.println();

        return integerCostMap;
    }
}
