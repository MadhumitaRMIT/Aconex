package com.aconex.simulator.entities.enums;

/**
 * Names of the cost-items of the simulated land clearing operation and respective credits.
 */
public enum Cost {
    COMMUNICATION_COST("communication overhead", 1),
    FUEL_COST("fuel usage", 1),
    UNCLEARED_SQUARE_COST("uncleared squares", 3),
    DESTRUCTION_OF_PROTECTED_TREE_COST("destruction of protected tree", 10),
    PAINT_DAMAGE_COST("paint damage to bulldozer", 2);

    private String name;
    private int credit;

    Cost(String s, int credit) {
        this.name = s;
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public String getName() {
        return name;
    }
}
