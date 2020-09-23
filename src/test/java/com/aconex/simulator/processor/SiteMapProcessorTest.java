package com.aconex.simulator.processor;

import com.aconex.simulator.entities.Square;
import com.aconex.simulator.entities.enums.Type;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SiteMapProcessorTest {

    @Test
    public void test() {
        SiteMapProcessor siteMapProcessor = new SiteMapProcessor();
        Square[][] expected = new Square[3][4];
        expected[0][0] = new Square(Type.PLAIN);
        expected[0][1] = new Square(Type.PLAIN);
        expected[0][2] = new Square(Type.ROCKY);
        expected[0][3] = new Square(Type.PROTECTED_TREE);
        expected[1][0] = new Square(Type.ROCKY);
        expected[1][1] = new Square(Type.ROCKY);
        expected[1][2] = new Square(Type.TREE);
        expected[1][3] = new Square(Type.PLAIN);
        expected[2][0] = new Square(Type.PLAIN);
        expected[2][1] = new Square(Type.PLAIN);
        expected[2][2] = new Square(Type.PLAIN);
        expected[2][3] = new Square(Type.PLAIN);

        List<String> input = new ArrayList<>();
        input.add("oorT");
        input.add("rrto");
        input.add("oooo");
        Square[][] actual = siteMapProcessor.apply(input);

        assertArrayEquals(expected, actual);

    }

}