package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Game game=new Game();
        String result;
        Map<Integer,String> test= new HashMap<>();
        for (int i = 0; i < 10; i++) {
            game.start();
            if(game.isTestWin()) result="Win user!";
            else result="Win presenter!";
            test.put(i,result);
        }
        for (Map.Entry print: test.entrySet()){
            System.out.println(print);
        }

    }
}