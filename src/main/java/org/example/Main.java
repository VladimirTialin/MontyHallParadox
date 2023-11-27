package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Integer, Boolean> test = new HashMap<>();
    private static final Game game=new Game();
    public static void main(String[] args) {
        int win=0, loss=0;
        for (int i = 0; i < 1000; i++) {
            game.start();
            test.put(i, game.isResult());
            if(game.isResult()) win++;
            else loss++;
        }
        double winPerc = (double) win / test.size();
        double lossPerc = (double) loss / test.size();
        System.out.printf(
                "Statistics:\nWin user: %s;  win: %.3f %%\n" +
                "Loss user: %s;  loss: %.3f %%",
                win,winPerc,loss, lossPerc);

    }
}
