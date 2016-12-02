package com.company.day2;

public class KeyPadV2 extends AbstractKeyPad{
    /*
    1
  2 3 4
5 6 7 8 9
  A B C
    D
     */
    private Key key1 = new Key("1");
    private Key key2 = new Key("2");
    private Key key3 = new Key("3");
    private Key key4 = new Key("4");
    private Key key5 = new Key("5");
    private Key key6 = new Key("6");
    private Key key7 = new Key("7");
    private Key key8 = new Key("8");
    private Key key9 = new Key("9");
    private Key keyA = new Key("A");
    private Key keyB = new Key("B");
    private Key keyC = new Key("C");
    private Key keyD = new Key("D");

    public KeyPadV2(){
        key1.setLeft(null).setRight(null).setUp(null).setDown(key3);
        key2.setLeft(null).setRight(key3).setUp(null).setDown(key6);
        key3.setLeft(key2).setRight(key4).setUp(key1).setDown(key7);
        key4.setLeft(key3).setRight(null).setUp(null).setDown(key8);
        key5.setLeft(null).setRight(key6).setUp(null).setDown(null);
        key6.setLeft(key5).setRight(key7).setUp(key2).setDown(keyA);
        key7.setLeft(key6).setRight(key8).setUp(key3).setDown(keyB);
        key8.setLeft(key7).setRight(key9).setUp(key4).setDown(keyC);
        key9.setLeft(key8).setRight(null).setUp(null).setDown(null);
        keyA.setLeft(null).setRight(keyB).setUp(key6).setDown(null);
        keyB.setLeft(keyA).setRight(keyC).setUp(key7).setDown(keyD);
        keyC.setLeft(keyB).setRight(null).setUp(key8).setDown(null);
        keyD.setLeft(null).setRight(null).setUp(keyB).setDown(null);
        currentKey = key5;
    }
}
