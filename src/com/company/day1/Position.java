package com.company.day1;

class Position {
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    int x = 0;
    int y = 0;

}
