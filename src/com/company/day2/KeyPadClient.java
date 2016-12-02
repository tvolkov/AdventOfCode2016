package com.company.day2;

class KeyPadClient {
    AbstractKeyPad keyPad = new KeyPadV2();

    public void move(char c) {
        keyPad.move(getDirection(c));
    }

    public String getKey() {
        return keyPad.getCurrentKey().value;
    }

    private Direction getDirection(char c) {
        switch (c) {
            case 'U':
                return Direction.UP;
            case 'D':
                return Direction.DOWN;
            case 'L':
                return Direction.LEFT;
            case 'R':
                return Direction.RIGHT;
            default:
                throw new RuntimeException("Invalid input");
        }
    }
}
