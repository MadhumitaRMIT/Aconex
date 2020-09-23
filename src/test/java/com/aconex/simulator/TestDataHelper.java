package com.aconex.simulator;

import com.aconex.simulator.entities.Square;
import com.aconex.simulator.input.SiteMapReader;
import com.aconex.simulator.processor.SiteMapProcessor;

import java.util.List;

public class TestDataHelper {

    public static Square[][] getSiteMap() {
        List<String> lines = new SiteMapReader().apply("input/input1.txt");
        return new SiteMapProcessor().apply(lines);
    }
}
