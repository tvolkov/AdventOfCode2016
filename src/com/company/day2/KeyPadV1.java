package com.company.day2;

class KeyPadV1 extends AbstractKeyPad {
    private Key key1 = new Key("1");
    private Key key2 = new Key("2");
    private Key key3 = new Key("3");
    private Key key4 = new Key("4");
    private Key key5 = new Key("5");
    private Key key6 = new Key("6");
    private Key key7 = new Key("7");
    private Key key8 = new Key("8");
    private Key key9 = new Key("9");

    public KeyPadV1() {
        key1.setLeft(null).setRight(key2).setUp(null).setDown(key4);
        key2.setLeft(key1).setRight(key3).setUp(null).setDown(key5);
        key3.setLeft(key2).setRight(null).setUp(null).setDown(key6);
        key4.setLeft(null).setRight(key5).setUp(key1).setDown(key7);
        key5.setLeft(key4).setRight(key6).setUp(key2).setDown(key8);
        key6.setLeft(key5).setRight(null).setUp(key3).setDown(key9);
        key7.setLeft(null).setRight(key8).setUp(key4).setDown(null);
        key8.setLeft(key7).setRight(key9).setUp(key5).setDown(null);
        key9.setLeft(key8).setRight(null).setUp(key6).setDown(null);
        currentKey = key5;
    }
}
