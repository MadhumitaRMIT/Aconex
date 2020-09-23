package com.aconex.simulator.entities.enums;

/**
 * List of possible activities and respective fuel usages.
 */
public enum Activity {
    CLEARING_PLAIN_SQUARE(1),
    VISITING_CLEAN_SQUARE(1),
    CLEARING_ROCKY_SQUARE(2),
    CLEARING_TREE_SQUARE(2),
    NOOP(0);

    private int fuelUsage;

    Activity(int fuelUsage) {
        this.fuelUsage = fuelUsage;
    }

    public int getFuelUsage() {
        return fuelUsage;
    }
}
