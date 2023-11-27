package org.example;

import java.util.Random;
public class User {
    private static final Random rnd = new Random();
    private final String [] chooseAns={"y","n"};
    public User() {
    }
    public int choose(int [] key) {
           return key[rnd.nextInt(key.length)];
    }
    public boolean reply() {
        String ans=chooseAns[rnd.nextInt(chooseAns.length)];
        while (true) {
            if (ans.equalsIgnoreCase("y")) return true;
            else if (ans.equalsIgnoreCase("n")) return false;
        }
    }
}
