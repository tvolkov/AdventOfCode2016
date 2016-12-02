package com.company.day2;

public abstract class AbstractKeyPad {
    protected Key currentKey;

    public void move(Direction direction) {
        switch (direction) {
            case UP:
                currentKey = currentKey.up == null ? currentKey : currentKey.up;
                break;
            case DOWN:
                currentKey = currentKey.down == null ? currentKey : currentKey.down;
                break;
            case LEFT:
                currentKey = currentKey.left == null ? currentKey : currentKey.left;
                break;
            case RIGHT:
                currentKey = currentKey.right == null ? currentKey : currentKey.right;
                break;
        }
    }

    public Key getCurrentKey() {
        return currentKey;
    }
}
