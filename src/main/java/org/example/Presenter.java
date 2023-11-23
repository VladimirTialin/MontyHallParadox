package org.example;

import java.util.Map;
import java.util.Random;

public class Presenter {
    public int door(int userChoose){
        Random rnd= new Random();
        int choose;
        while (true) {
            choose = rnd.nextInt(1, 3);
            if(choose!=userChoose) return choose;
        }
    }
}
