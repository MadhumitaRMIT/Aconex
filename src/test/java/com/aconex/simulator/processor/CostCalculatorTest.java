package com.aconex.simulator.processor;

import com.aconex.simulator.commands.AdvanceCommand;
import com.aconex.simulator.commands.QuitCommand;
import com.aconex.simulator.commands.RightCommand;
import com.aconex.simulator.entities.Bulldozer;
import com.aconex.simulator.entities.Position;
import com.aconex.simulator.entities.Square;
import com.aconex.simulator.entities.enums.Cost;
import com.aconex.simulator.entities.enums.Direction;
import com.aconex.simulator.entities.enums.Type;
import com.aconex.simulator.output.CostCalculator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CostCalculatorTest {

    @Test
    public void test() {
        Bulldozer bulldozer = new Bulldozer(new Position(2,3, Direction.SOUTH));
        bulldozer.getCommandList().add(new AdvanceCommand(4));
        bulldozer.getCommandList().add(new RightCommand());
        bulldozer.getCommandList().add(new AdvanceCommand(2));
        bulldozer.getCommandList().add(new QuitCommand("Protected Tree"));
        Map<Cost, Integer> input = bulldozer.getItemisedCostMap();
        input.put(Cost.FUEL_COST, 8);
        input.put(Cost.COMMUNICATION_COST, 3);
        input.put(Cost.DESTRUCTION_OF_PROTECTED_TREE_COST, 1);

        CostCalculator costCalculator = new CostCalculator(getSiteMap());
        Map<Cost, Integer> actual = costCalculator.apply(bulldozer);

        assertEquals(4, (int) actual.get(Cost.UNCLEARED_SQUARE_COST));
        assertEquals(5, actual.size());
    }

    private Square[][] getSiteMap() {
        /**
         * o o r t
         * o r T r
         * o r T T
         */
        Square[][] expected = new Square[3][4];
        Square plainSqr = new Square(Type.PLAIN);
        plainSqr.setCleared(true);
        expected[0][0] = plainSqr;
        expected[0][1] = plainSqr;
        Square rockySqr = new Square(Type.ROCKY);
        rockySqr.setCleared(true);
        expected[0][2] = rockySqr;
        Square treeSqr = new Square(Type.TREE);
        treeSqr.setCleared(true);
        expected[0][3] = treeSqr;
        expected[1][0] = new Square(Type.PLAIN);
        expected[1][1] = new Square(Type.ROCKY);
        expected[1][2] = new Square(Type.PROTECTED_TREE);
        expected[1][3] = rockySqr;
        expected[2][0] = new Square(Type.PLAIN);
        expected[2][1] = new Square(Type.ROCKY);
        expected[2][2] = new Square(Type.PROTECTED_TREE);
        Square protectedSqr = new Square(Type.PROTECTED_TREE);
        expected[2][3] = protectedSqr;

        return expected;
    }
}