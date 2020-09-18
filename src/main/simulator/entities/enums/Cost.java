package simulator.entities.enums;

public enum Cost{
    communication_overhead("communication overhead",1),
    fuel_cost("fuel usage",1),
    uncleared_square("uncleared squares",3),
    protected_tree_damage("protected tree destructed", 10),
    paint_damage("bulldozer paint damage",2);
 
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