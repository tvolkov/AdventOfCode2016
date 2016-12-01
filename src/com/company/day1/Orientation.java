package com.company.day1;

enum Orientation {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Orientation turn(Direction direction){
        switch (direction) {
            case RIGHT:
                return turnRight();
            case LEFT:
                return turnLeft();
            default:
                return null;
        }
    }

    private Orientation turnRight(){
        if (this.equals(WEST))
            return NORTH;
        return Orientation.values()[ordinal() + 1];
    }

    private Orientation turnLeft(){
        if (this.equals(NORTH))
            return WEST;
        return Orientation.values()[ordinal() - 1];

    }
}
