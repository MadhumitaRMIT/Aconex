package com.aconex.simulator.entities.enums;

public enum Direction {
    EAST,
    WEST,
    NORTH,
    SOUTH;


    public Direction turnLeft(){
        switch (this){
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            default:
                return this;
        }
    }

    public Direction turnRight(){
        switch (this){
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            default:
                return this;
        }
    }

}
