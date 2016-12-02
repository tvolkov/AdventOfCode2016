package com.company.day2;

class Key {
    String value = "5";
    Key left;
    Key right;
    Key up;
    Key down;

    Key(String value) {
        this.value = value;
    }

    Key setLeft(Key left) {
        this.left = left;
        return this;
    }

    Key setRight(Key right) {
        this.right = right;
        return this;
    }

    Key setUp(Key up) {
        this.up = up;
        return this;
    }

    Key setDown(Key down) {
        this.down = down;
        return this;
    }
}
