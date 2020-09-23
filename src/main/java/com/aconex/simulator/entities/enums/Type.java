package com.aconex.simulator.entities.enums;

/**
 * The possible types of squares and relevant activities.
 */
public enum Type {
    PLAIN(Activity.CLEARING_PLAIN_SQUARE),
    ROCKY(Activity.CLEARING_ROCKY_SQUARE),
    TREE(Activity.CLEARING_TREE_SQUARE),
    PROTECTED_TREE(Activity.NOOP);

    private Activity relevantActivity;

    Type(Activity i) {
        this.relevantActivity = i;
    }

    public static Type of(char c){
        switch (c) {
            case 'o':
                return Type.PLAIN;
            case 't':
                return Type.TREE;
            case 'r':
                return Type.ROCKY;
            case 'T':
                return Type.PROTECTED_TREE;
            default:
                return Type.PLAIN;
        }
    }

    public Activity getRelevantActivity() {
        return relevantActivity;
    }
}
